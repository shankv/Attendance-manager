package com.attendance;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;



/**
 * Servlet implementation class controller
 */
@WebServlet("/controller")
public class controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   private databaseutil xxx;
   @Resource(name="jdbc/attendance_manager")
   private DataSource datasource;
   
	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();
		
		
		try{
			xxx = new databaseutil(datasource);
		}catch(Exception e)
		{
			throw new  ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String theCommand = request.getParameter("command");
		switch(theCommand)
		{
		case "TEACHER":
			 try {
				teacherLogin(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 break;
		case "ADD":
			 try {
				addStudent(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}



	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int rollNo =Integer.parseInt(request.getParameter("rollNo"));
		String name = request.getParameter("name");
		student theStudent = new student(rollNo,name);
		xxx.addStudent(theStudent);
		
	}



	private void teacherLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String theUser = request.getParameter("user");
		
		String thepass = request.getParameter("password");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/teacher_main.jsp"); 
		dispatcher.forward(request, response); 
	/*	if("shashank".equals(theUser) && "verma".equals(thepass))
		{  
			RequestDispatcher dispatcher = request.getRequestDispatcher("/teacher_main.jsp"); 
			dispatcher.forward(request, response);
		}
		else{
			RequestDispatcher dispatcher = request.getRequestDispatcher("/teacher_login.jsp");
			dispatcher.forward(request, response);
			String error ="Invalid deatails";
			request.setAttribute("ERROR", error);
		} */
	}
}
