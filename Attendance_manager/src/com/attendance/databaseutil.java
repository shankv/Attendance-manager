package com.attendance;

import java.sql.Connection;  
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;



public class databaseutil {
    
	private DataSource datasource;
	private List<student> theStudent;
	public databaseutil(DataSource datasource2) {
		// TODO Auto-generated constructor stub
		datasource = datasource2;
	}
	public  void addStudent(student theStudent2) throws Exception {
		
		Connection con =null;
		PreparedStatement ps =null;
		try{ 
			con =datasource.getConnection();
			String sql ="insert into student"+"(roll_no,name)"+ "value(?,?)";
			ps=con.prepareStatement(sql);
			ps.setInt(1, theStudent2.getRollNo());
			ps.setString(2, theStudent2.getName());
			ps.execute();
			}finally{
				ps.close();
				con.close();
			}
		
	}
	public List<student> getStudent() throws Exception{
		// TODO Auto-generated method stub
		 List<student> theStudent = new ArrayList<>();
		 Connection con = null;
		 Statement mys =null;
		 ResultSet myresult =null;
		 
		 String res = "select * from student order by roll_no";
		 try{
			 con = datasource.getConnection();
			 mys=con.createStatement();
			 myresult = mys.executeQuery(res);
			 
			 while(myresult.next())
			 {
				 int rollNo = myresult.getInt("roll_no");
				 String name = myresult.getString("name");
				 int attend = myresult.getInt("attend");
				 int total = myresult.getInt("total");
				 double percentage = myresult.getDouble("percentage");
				 
				student tempStudent  = new student(rollNo,name,attend , total ,percentage);
				theStudent.add(tempStudent);
			 }
			 return theStudent;
		 } finally{
			  try{
				  if(con != null)
				  {
					  con.close();
				  }
				  if(mys != null)
				  {
					  mys.close();
				  }
				  if(myresult != null)
				  {
					  myresult.close();
				  }
			  }catch(Exception e){
				  e.printStackTrace( );
				  
			  }
			 
		 }
}}
