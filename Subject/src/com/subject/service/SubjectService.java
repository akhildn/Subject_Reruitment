package com.subject.service;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;

import com.subject.entity.Subject;

public class SubjectService extends BaseService {
	
	public void addSubject(Subject s) throws Exception {
		
			con.setAutoCommit(false);
			PreparedStatement p = con.prepareStatement("select max(id) from subject");
			ResultSet rs = p.executeQuery();
			int id = 0;
			while(rs.next()){
				id = rs.getInt(1);
			}
			p = con.prepareStatement("insert into subject values (?,?,?,?,?,?,?,?,?,?)");
			p.setInt(1, id+1);
			p.setString(2,s.getFirstName());
			p.setString(3,s.getLastName());
			p.setString(4,s.getPhoneNumber());
			p.setString(5,s.getEmail());
			LocalDate date = s.getDob();
			p.setDate(6, Date.valueOf(date));
			p.setString(7,s.getEthnicity());
			p.setInt(8,s.getHeight());
			p.setString(9,s.getUsername());
			p.setString(10,s.getPassword());
			p.executeUpdate();
			
			con.commit();
	}

	public boolean validate(String username, String password) throws Exception {
		PreparedStatement p = con.prepareStatement("select password from subject where username= ?");
		p.setString(1, username);
		ResultSet rs = p.executeQuery();
		String dbPassword = null;
		if(rs.next()) {
			dbPassword = rs.getString(1);
		}
		if(dbPassword.equals(password)) {
			return true;
		}else {
			return false;
		}
	}

	public int getSubjectIdByUsername(String username)throws Exception {
		PreparedStatement p = con.prepareStatement("select id from subject where username= ?");
		p.setString(1, username);
		ResultSet rs = p.executeQuery();
		if(rs.next()) {
			return rs.getInt(1);
		}
		return 0;
	}

}
