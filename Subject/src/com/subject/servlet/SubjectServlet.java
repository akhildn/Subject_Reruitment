package com.subject.servlet;

import java.io.IOException;
import java.time.LocalDate;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.subject.entity.Subject;
import com.subject.service.SubjectService;

/**
 * Servlet implementation class SubjectServlet
 */
@WebServlet("/SubjectServlet")
public class SubjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SubjectServlet() {
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
		if(action.equals("signup")){
			String firstName = request.getParameter("firstName");
			String lastName = request.getParameter("lastName");
			String phoneNumber = request.getParameter("phoneNumber");
			String email = request.getParameter("email");
			String date = request.getParameter("dateOfBirth");
			LocalDate dob = LocalDate.parse(date);
			String ethnicity = request.getParameter("ethnicity");
			int height = Integer.parseInt(request.getParameter("height"));
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			Subject s = new Subject(0, firstName, lastName, phoneNumber, email, dob, ethnicity, height, username, password);
				ss.addSubject(s);
				targetPage= "login.jsp";
			}
		ss.close();
		request.getRequestDispatcher(targetPage).forward(request, response);
		} catch (Exception e) {
				// TODO Auto-generated catch block
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
