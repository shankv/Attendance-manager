package com.attendance;

import java.sql.Connection;
import java.sql.PreparedStatement;
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
			System.out.println(theStudent2.getRollNo() + theStudent2.getName());
			con =datasource.getConnection();
            System.out.println(theStudent2.getName());

			String sql ="insert into student"+"(roll_no,name)"+ "value(?,?)";
			ps=con.prepareStatement(sql);
			ps.setInt(1, theStudent2.getRollNo());
			ps.setString(2, theStudent2.getName());
			ps.execute();
			
            System.out.println(theStudent2.getName());
			}finally{
				ps.close();
				con.close();
			}
		
	}
	
}
