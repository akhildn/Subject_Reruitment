package com.subject.service;

import java.sql.Array;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.subject.entity.Project;
import com.subject.entity.ProjectSubject;

public class ProjectService extends BaseService {
	
public List<Project> getProjects(int recruiterId) throws Exception {
		
		List<Project> projects = new ArrayList<Project>();
		PreparedStatement ps= null;
		if(recruiterId == 0) {
			ps =  con.prepareStatement("select * from project");
		}else {
			ps = con.prepareStatement("select * from project where recruiter_id = ?");
			ps.setInt(1, recruiterId);	
		}	
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Project p = new Project(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5),
						rs.getInt(6),rs.getInt(7),rs.getInt(8));
				
				projects.add(p);
			}
		return projects;
	}

public void addProject(Project p)throws Exception {
	
	con.setAutoCommit(false);
	PreparedStatement ps = con.prepareStatement("select max(id) from project");
	ResultSet rs = ps.executeQuery();
	int id = 0;
	while(rs.next()){
		id = rs.getInt(1);
	}
	ps = con.prepareStatement("insert into project values (?,?,?,?,?,?,?,?)");
	ps.setInt(1, id+1);
	ps.setString(2,p.getProjectName());
	ps.setInt(3,p.getRecruiterId());
	ps.setString(4,p.getEthnicity());
	ps.setInt(5,p.getMinHeight());
	ps.setInt(6,p.getMaxHeight());
	ps.setInt(7,p.getMinAge());
	ps.setInt(8,p.getMaxAge());
	ps.executeUpdate();
	con.commit();
}

public Project getProject(int projectId)throws Exception {
	
	PreparedStatement ps= con.prepareStatement("select * from project where id = ?");
	ps.setInt(1, projectId);		
	ResultSet rs = ps.executeQuery();
	Project p = null;
	while(rs.next()) {
		p = new Project(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getInt(5),
				rs.getInt(6),rs.getInt(7),rs.getInt(8));
		
	}
	return p;
}

public void updateUpdate(Project p)throws Exception {
	
	PreparedStatement ps = con.prepareStatement("update project set project_name = ?, ethnicity = ?, min_height = ?,"
			+ "max_height = ?, min_age = ?, max_age = ? where id = ?" );
	
	ps.setString(1,p.getProjectName());
	ps.setString(2,p.getEthnicity());
	ps.setInt(3,p.getMinHeight());
	ps.setInt(4,p.getMaxHeight());
	ps.setInt(5,p.getMinAge());
	ps.setInt(6,p.getMaxAge());
	ps.setInt(7, p.getProjectId());
	ps.executeUpdate();
	con.commit();
}

public void deleteProject(int deleteProjectId)throws Exception {
	// TODO Auto-generated method stub
	PreparedStatement ps = con.prepareStatement("delete from project where id = ? ");
	ps.setInt(1, deleteProjectId);
	ps.executeQuery();
}

public void sendRequest(int projectId, int subjectId, String comments)throws Exception {
	// TODO Auto-generated method stub
	con.setAutoCommit(false);
	PreparedStatement ps = con.prepareStatement("select max(id) from project_subject");
	ResultSet rs = ps.executeQuery();
	int id = 0;
	while(rs.next()){
		id = rs.getInt(1);
	}
	ps = con.prepareStatement("insert into project_subject (id,project_id,subject_id,status,subject_comments) values (?,?,?,?,?)");
	ps.setInt(1, id+1);
	ps.setInt(2, projectId);
	ps.setInt(3, subjectId);
	ps.setString(4, "requested");
	ps.setString(5, comments);
	ps.execute();
	con.commit();
}

public List<ProjectSubject> getRequests(int userId, String userRole)throws Exception {
	// TODO Auto-generated method stub
	List<ProjectSubject> psr = new ArrayList<ProjectSubject>();
	PreparedStatement p = null;
	if(userRole.equals("subject")) {
		p = con.prepareStatement("select * from project_subject where subject_id = ?");
		p.setInt(1, userId);
		ResultSet rs = p.executeQuery();
		ProjectSubject ps =  null;
		while(rs.next()) {
			ps = new ProjectSubject(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6));
			psr.add(ps);
		}
		
	}else if(userRole.equals("recruiter")) {
		ProjectSubject ps =  null;
		p = con.prepareStatement("select id from project where recruiter_id = ? ");
		List<Integer> projectIds = new ArrayList<Integer>();
		p.setInt(1, userId);
		ResultSet rs = p.executeQuery();
		while(rs.next()) {
			projectIds.add(rs.getInt(1));
		}
		
		p= con.prepareStatement("select * from project_subject where project_id in ? and status = ?");
		p.setArray(1, (Array) projectIds);
		p.setString(2, "requested");
		rs = p.executeQuery();
		while(rs.next()) {
			ps = new ProjectSubject(rs.getInt(1),rs.getInt(2),rs.getInt(3),rs.getString(4),rs.getString(5),rs.getString(6));
			psr.add(ps);
		}
	}
	return psr;
}



}
