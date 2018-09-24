package com.attendance;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

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
		case "LIST":
			try {
				listStudent(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		case "MARK":
			try {
				mark(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		case"UPDATE":
			 try {
				markupdate(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		case"STUDENT":
			try{
				infoStudent(request,response);
			}
			catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			 
			
		}
	}



	private void infoStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		int id =Integer.parseInt(request.getParameter("rollNo"));
		List<student> theStudent=xxx.infoStudent(id);
		request.setAttribute("STUDENTINFO", theStudent);
		RequestDispatcher dispatcher1 = request.getRequestDispatcher("/studentmain.jsp"); 
		dispatcher1.forward(request, response);	
		
	}

	private void markupdate(HttpServletRequest request, HttpServletResponse response) throws Exception {
		 
		 String rollNo[] = request.getParameterValues("rollNo");
		 String name[] = request.getParameterValues("name");
		 int add=0;
		 for(int i=0;i<name.length;i++)
		 {   
			 int x =i+1;
			 int roll =Integer.parseInt(rollNo[i]);
			 String nam =name[i];
			 String a = request.getParameter(String.valueOf(x));
			 if("1".equals(a))
			 {
				  add=1;
			 }
			 else{
				 add=0;
			 }
			

		xxx.mark(roll,nam, add);
	
		 }
		 List<student> theStudent =xxx.getStudent();
			request.setAttribute("STUDENTINFO", theStudent);
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("/teacher_main.jsp"); 
			dispatcher1.forward(request, response);	}
		
	

	private void mark(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		List<student> theStudent =xxx.getStudent();
		request.setAttribute("STUDENTINFO", theStudent);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/mark.jsp");
				dispatcher.forward(request, response);

	}

	private void listStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		List<student> theStudent =xxx.getStudent();
		request.setAttribute("STUDENTINFO", theStudent);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list_student.jsp");
				dispatcher.forward(request, response);
	}

	private void addStudent(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String name = request.getParameter("name");

		student theStudent = new student(name);
		xxx.addStudent(theStudent);
		 List<student> theStudent1 =xxx.getStudent();
			request.setAttribute("STUDENTINFO", theStudent1);
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("/teacher_main.jsp"); 
			dispatcher1.forward(request, response);	
	}



	private void teacherLogin(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// TODO Auto-generated method stub
		String theUser = request.getParameter("user");
		
		String thepass = request.getParameter("password");
	 
		if("shashank".equals(theUser) && "verma".equals(thepass))
		{  
			List<student> theStudent =xxx.getStudent();
			request.setAttribute("STUDENTINFO", theStudent);
			RequestDispatcher dispatcher1 = request.getRequestDispatcher("/teacher_main.jsp"); 
			dispatcher1.forward(request, response);
		}
		else{
			RequestDispatcher dispatcher2 = request.getRequestDispatcher("/teacher_login.jsp");
			dispatcher2.forward(request, response);
			String error ="Invalid deatails";
			request.setAttribute("ERROR", error);
		} 
	}
}
