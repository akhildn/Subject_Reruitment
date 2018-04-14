package com.subject.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.subject.entity.Project;
import com.subject.entity.ProjectSubject;
import com.subject.service.ProjectService;
import com.subject.service.RecruiterService;
import com.subject.service.SubjectService;

/**
 * Servlet implementation class ProjectServlet
 */
@WebServlet("/ProjectServlet")
public class ProjectServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProjectServlet() {
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
			ProjectService ps= new ProjectService();
			RecruiterService rs = new RecruiterService();
			SubjectService ss = new SubjectService();
			String username = (String) request.getSession().getAttribute("userId");
			String userRole = (String) request.getSession().getAttribute("userRole");
			int recruiterId = 0;
			int subjectId = 0;
			if(userRole.equals("recruiter")) {
				recruiterId = rs.getRecruiterIdByUsername(username);
			}else if(userRole.equals("subject")) {
				subjectId = ss.getSubjectIdByUsername(username);
			}
			
			if(action.equals("listProjects")) {
				List<Project> projects = ps.getProjects(recruiterId);
				request.setAttribute("projects", projects );
				targetPage = "projects.jsp";
			}else if(action.equals("addProject")) {
				String projectName = request.getParameter("name");
				String ethnicity = request.getParameter("ethnicity");
				int minHeight = Integer.parseInt(request.getParameter("minHeight"));
				int maxHeight = Integer.parseInt(request.getParameter("maxHeight"));
				int minAge = Integer.parseInt(request.getParameter("minAge"));
				int maxAge = Integer.parseInt(request.getParameter("maxAge"));
				Project p = new Project(0, projectName, recruiterId, ethnicity, minHeight, maxHeight, minAge, maxAge);
				ps.addProject(p);
				List<Project> projects = ps.getProjects(recruiterId);
				request.setAttribute("projects", projects );
				targetPage = "projects.jsp";
			}else if(action.equals("editProject")) {
				int projectId = Integer.parseInt(request.getParameter("projectId"));
				Project p = ps.getProject(projectId);
				request.setAttribute("project", p);
				targetPage = "editProject.jsp";
			}else if(action.equals("updateProject")){
				
				int projectId = Integer.parseInt(request.getParameter("projectId"));
				String projectName = request.getParameter("name");
				String ethnicity = request.getParameter("ethnicity");
				
				int minHeight = Integer.parseInt(request.getParameter("minHeight"));
				int maxHeight = Integer.parseInt(request.getParameter("maxHeight"));
				int minAge = Integer.parseInt(request.getParameter("minAge"));
				int maxAge = Integer.parseInt(request.getParameter("maxAge"));
				
				Project p = new Project(projectId, projectName, recruiterId, ethnicity, minHeight, maxHeight, minAge, maxAge);
				ps.updateUpdate(p);
			
				List<Project> projects = ps.getProjects(recruiterId);
				request.setAttribute("projects", projects );
				targetPage = "projects.jsp";
				
			}else if(action.equals("delete")){
				int deleteProjectId = Integer.parseInt(request.getParameter("projectId"));
				ps.deleteProject(deleteProjectId);
				System.out.println("book deleted !!");
				
				List<Project> projects = ps.getProjects(recruiterId);
				request.setAttribute("projects", projects );
				targetPage = "projects.jsp";	
			}else if(action.equals("sendRequest")){
				int projectId = Integer.parseInt(request.getParameter("projectId"));
				String comments = request.getParameter("comments");
				ps.sendRequest(projectId,subjectId,comments);
				targetPage = "myRequests.jsp";
			}else if(action.equals("listRequests")) {
				List<ProjectSubject> psr = null;
				if(userRole.equals("recruiter")){
					psr = ps.getRequests(recruiterId, userRole);
				}else if(userRole.equals("subject")){
					psr = ps.getRequests(subjectId, userRole);
				}
				request.setAttribute("requests", psr );
				targetPage = "myRequest.jsp";
			}
			rs.close();
			ps.close();
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
