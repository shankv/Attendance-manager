package com.attendance;

import java.io.IOException ; 
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;



/**
 * Servlet implementation class sssss
 */
@WebServlet("/test")
public class test extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Resource(name="jdbc/attendance_manager")
	private DataSource datasource;
    /**
     * Default constructor. 
     */
    public test() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		response.setContentType("text/plain");
		PrintWriter out =response.getWriter();
         
         Connection mycon =null;
         Statement mystat = null;
          ResultSet myset =null; 
          
          try{
        	  mycon = datasource.getConnection();
        	  String sql ="select * from student";
        	  mystat= mycon.createStatement();
        	  myset =  mystat.executeQuery(sql);
        	  
        	  while(myset.next())
        	  {
        		  String email =myset.getString("email");
        		  out.println(email);
        	  }
          }catch(Exception e)
          {
        	 e.printStackTrace();
          }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
