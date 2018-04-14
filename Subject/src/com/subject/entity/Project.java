package com.subject.entity;

public class Project {

	private int projectId;
	private String projectName;
	private int recruiterId;
	private String ethnicity;
	private int minHeight;
	private int maxHeight;
	private int minAge;
	private int maxAge;
	public Project(int projectId, String projectName, int recruiterId, String ethnicity, int minHeight, int maxHeight,
			int minAge, int maxAge) {
		super();
		this.projectId = projectId;
		this.projectName = projectName;
		this.recruiterId = recruiterId;
		this.ethnicity = ethnicity;
		this.minHeight = minHeight;
		this.maxHeight = maxHeight;
		this.minAge = minAge;
		this.maxAge = maxAge;
	}
	public int getProjectId() {
		return projectId;
	}
	public void setProjectId(int projectId) {
		this.projectId = projectId;
	}
	public String getProjectName() {
		return projectName;
	}
	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}
	public int getRecruiterId() {
		return recruiterId;
	}
	public void setRecruiterId(int recruiterId) {
		this.recruiterId = recruiterId;
	}
	public String getEthnicity() {
		return ethnicity;
	}
	public void setEthnicity(String ethnicity) {
		this.ethnicity = ethnicity;
	}
	public int getMinHeight() {
		return minHeight;
	}
	public void setMinHeight(int minHeight) {
		this.minHeight = minHeight;
	}
	public int getMaxHeight() {
		return maxHeight;
	}
	public void setMaxHeight(int maxHeight) {
		this.maxHeight = maxHeight;
	}
	public int getMinAge() {
		return minAge;
	}
	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}
	public int getMaxAge() {
		return maxAge;
	}
	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}
	
	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", projectName=" + projectName + ", recruiterId=" + recruiterId
				+ ", ethnicity=" + ethnicity + ", minHeight=" + minHeight + ", maxHeight=" + maxHeight + ", minAge="
				+ minAge + ", maxAge=" + maxAge + "]";
	}
	
	
}
