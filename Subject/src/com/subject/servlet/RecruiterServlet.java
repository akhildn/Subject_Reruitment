package com.subject.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.subject.entity.Recruiter;
import com.subject.service.RecruiterService;

/**
 * Servlet implementation class RecruiterServlet
 */
@WebServlet("/RecruiterServlet")
public class RecruiterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecruiterServlet() {
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
			RecruiterService rs= new RecruiterService();
			
			if(action.equals("listRecruiters")) {
				List<Recruiter> recruiters = rs.getRecruiters();
				request.setAttribute("recruiters", recruiters );
				targetPage = "recruiters.jsp";
			}else if(action.equals("addRecruiter")){
				
				String name = request.getParameter("name");
				String phoneNumber = request.getParameter("phoneNumber");
				String email = request.getParameter("email");
				String address = request.getParameter("address");
				String username = request.getParameter("username");
				String password = request.getParameter("password");
			
				Recruiter r = new Recruiter(0, name, phoneNumber, email, address, username, password);
				rs.addRecruiter(r);
				
				List<Recruiter> recruiters = rs.getRecruiters();
				request.setAttribute("recruiters", recruiters );
				targetPage = "recruiters.jsp";				
			
			}else if(action.equals("delete")){
				int deleteRecruiterId = Integer.parseInt(request.getParameter("recruiterId"));
				rs.deleteRecruiter(deleteRecruiterId);
				System.out.println("book deleted !!");
				List<Recruiter> recruiters = rs.getRecruiters();
				request.setAttribute("recruiters", recruiters );
				targetPage = "recruiters.jsp";			
			}else if(action.equals("searchRecruiter")) {
				String searchTitle = request.getParameter("searchname");
				List<Recruiter> recruiters= rs.searchRecruiter(searchTitle);
				request.setAttribute("recruiters", recruiters );
				targetPage = "recruiters.jsp";		
			}else if(action.equals("editRecruiter")) {
				int recruiterId = Integer.parseInt(request.getParameter("recruiterId"));
				Recruiter r = rs.getRecruiter(recruiterId);
				request.setAttribute("recruiter", r);
				targetPage = "editRecruiter.jsp";
			}else if(action.equals("updateRecruiter")){
				int recruiterId = Integer.parseInt(request.getParameter("recruiterId"));
				String name = request.getParameter("name");
				String phoneNumber = request.getParameter("phoneNumber");
				String email = request.getParameter("email");
				String address = request.getParameter("address");
				String username = request.getParameter("username");
				String password = request.getParameter("password");
				
				Recruiter r = new Recruiter(recruiterId, name, phoneNumber, email, address, username, password);
				rs.updateRecruiter(r);
			
				List<Recruiter> recruiters = rs.getRecruiters();
				request.setAttribute("recruiters", recruiters );
				targetPage = "recruiters.jsp";
				
			}else {
				
			}
			rs.close();
			request.getRequestDispatcher(targetPage).forward(request, response);
		}catch(Exception e) {
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
