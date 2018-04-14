package com.subject.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.subject.service.RecruiterService;
import com.subject.service.SubjectService;


/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public LoginServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
		String action = request.getParameter("action");
		String targetPage = null;
		SubjectService ss = new SubjectService();
		RecruiterService rs = new RecruiterService();
		
		if(action.equals("login")){
			String username = request.getParameter("loginid");
			String password = request.getParameter("loginpassword");
			String userRole = request.getParameter("userrole");
			boolean flag =false;
			if(userRole.equals("admin")){
				if(username.equals("admin")&&password.equals("admin")){
					flag= true;
					System.out.println("Admin " +flag);
				}
			}else if(userRole.equals("subject"))
			{
				flag = ss.validate(username,password);
				
			}else {
				flag = rs.validate(username,password);
			}
			
			if(flag){
				request.getSession().setAttribute("userId",username);
				request.getSession().setAttribute("userRole", userRole);
				targetPage= "welcome.jsp";
				System.out.println(userRole+"  flag !" +flag);
			}else{
				request.setAttribute("error","Login Failed!");
				targetPage= "login.jsp";
			}

		}
		else if(action.equals("logout")){
			request.getSession().invalidate();//killing session
			targetPage= "login.jsp";
			
		}
		// ss.close();
		request.getRequestDispatcher(targetPage).forward(request, response);
		System.out.println("Login Sucessful!");}catch(Exception e) {
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
