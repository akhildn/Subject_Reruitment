package com.subject.entity;

public class ProjectSubject {

	private int id;
	private int projectId;
	private int subjectId;
	private String status;
	private String subjectComments;
	private String recruiterComments;
	
	public ProjectSubject(int id, int projectId, int subjectId, String status, String subjectComments,
			String recruiterComments) {
		super();
		this.id = id;
		this.projectId = projectId;
		this.subjectId = subjectId;
		this.status = status;
		this.subjectComments = subjectComments;
		this.recruiterComments = recruiterComments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getProjectId() {
		return projectId;
	}

	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}

	public int getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(int subjectId) {
		this.subjectId = subjectId;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getSubjectComments() {
		return subjectComments;
	}

	public void setSubjectComments(String subjectComments) {
		this.subjectComments = subjectComments;
	}

	public String getRecruiterComments() {
		return recruiterComments;
	}

	public void setRecruiterComments(String recruiterComments) {
		this.recruiterComments = recruiterComments;
	}

	@Override
	public String toString() {
		return "ProjectSubject [id=" + id + ", projectId=" + projectId + ", subjectId=" + subjectId + ", status="
				+ status + ", subjectComments=" + subjectComments + ", recruiterComments=" + recruiterComments + "]";
	}
	
	
}
