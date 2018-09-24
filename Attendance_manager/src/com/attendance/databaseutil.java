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
			String sql ="insert into student"+"(name)"+ "value(?)";
			ps=con.prepareStatement(sql);
			ps.setString(1, theStudent2.getName());
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
}
	public void mark(int roll, String nam, int add)throws Exception {
		// TODO Auto-generated method stub
		
		Connection con =null;
		
		PreparedStatement ps =null;
		ResultSet rs =null;
		int rollNo=0 ,total=0;
		double percentage=0;
		String name=null;
		int attend1=0;

		
		try{
			
			String sql = "select * from student where roll_no=?";
			con=datasource.getConnection();
			ps=con.prepareStatement(sql);
			ps.setInt(1, roll);
		rs= 	ps.executeQuery();
			while(rs.next())
			{
				  rollNo = rs.getInt("roll_no");
				 name = rs.getString("name");
				  attend1 = rs.getInt("attend");
				  total = rs.getInt("total");
				  percentage = rs.getDouble("percentage");
			}
			attend1+=add;
			total=total+1;
			percentage =(attend1*100)/total;
			con=datasource.getConnection();
			String Sql1 ="update student "+ "set name=?,attend=?,total=?,percentage=? "+"where roll_no=?";
			ps=con.prepareStatement(Sql1);
			ps.setInt(5, rollNo);
			ps.setString(1, name);
            ps.setInt(2,attend1);
            ps.setInt(3, total);
            ps.setDouble(4, percentage);
            ps.execute();
			
		}finally{
			ps.close();con.close();rs.close();
		
		}
		
	}
	public List<student> infoStudent(int id) throws Exception {
		// TODO Auto-generated method stub
		 List<student> theStudent = new ArrayList<>();
		 Connection con = null;
		 Statement mys =null;
		 ResultSet myresult =null;
		 PreparedStatement ps= null;
		
		 try{
				String sql = "select * from student where roll_no=?";
			 con = datasource.getConnection();
			 ps =con.prepareStatement(sql);
			 ps.setInt(1, id);
			 myresult = ps.executeQuery();
			 
			 while(myresult.next())
			 {
				 int roll = myresult.getInt("roll_no");
				 String name = myresult.getString("name");
				 int attend = myresult.getInt("attend");
				 int total = myresult.getInt("total");
				 double percentage = myresult.getDouble("percentage");
				
				 
				student tempStudent  = new student(id,name,attend , total ,percentage);
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
			 
		
		
	}}
	
	
}
