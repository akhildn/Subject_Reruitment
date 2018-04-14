package com.subject.entity;

public class Recruiter {
	int id;
	String recruiterName;
	String phoneNumber;
	String email;
	String address;
	String username;
	String password;
	public Recruiter() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public Recruiter(int id, String recruiterName, String phoneNumber, String email, String address, String username,
			String password) {
		super();
		this.id = id;
		this.recruiterName = recruiterName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.address = address;
		this.username = username;
		this.password = password;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRecruiterName() {
		return recruiterName;
	}
	public void setRecruiterName(String recruiterName) {
		this.recruiterName = recruiterName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Recruiter [id=" + id + ", recruiterName=" + recruiterName + ", phoneNumber=" + phoneNumber + ", email="
				+ email + ", address=" + address + ", username=" + username + ", password=" + password + "]";
	}

	
}
