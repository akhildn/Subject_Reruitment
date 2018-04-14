package com.subject.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import com.subject.entity.Recruiter;

public class RecruiterService extends BaseService{

	public List<Recruiter> getRecruiters() throws Exception {
		
		List<Recruiter> recruiters = new ArrayList<Recruiter>();
		PreparedStatement ps= con.prepareStatement("select * from recruiter");
		ResultSet rs = ps.executeQuery();
		while(rs.next()) {
			Recruiter r = new Recruiter(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
					rs.getString(6),rs.getString(7));
			recruiters.add(r);
		}
		return recruiters;
	}

	public void addRecruiter(Recruiter r) throws Exception {
		
		con.setAutoCommit(false);
		PreparedStatement p = con.prepareStatement("select max(id) from recruiter");
		ResultSet rs = p.executeQuery();
		int id = 0;
		while(rs.next()){
			id = rs.getInt(1);
		}
		p = con.prepareStatement("insert into recruiter values (?,?,?,?,?,?,?)");
		p.setInt(1, id+1);
		p.setString(2,r.getRecruiterName());
		p.setString(3,r.getPhoneNumber());
		p.setString(4,r.getEmail());
		p.setString(5,r.getAddress());
		p.setString(6, r.getUsername());
		p.setString(7,r.getPassword());
		p.executeUpdate();
		con.commit();
		
	}

	public void deleteRecruiter(int deleteRecruiterID)throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement ps = con.prepareStatement("delete from recruiter where id = ? ");
		ps.setInt(1, deleteRecruiterID);
		ps.executeQuery();
	}

	public List<Recruiter> searchRecruiter(String searchTitle)throws Exception {
		
		List<Recruiter> recruiters= new ArrayList<Recruiter>();
		PreparedStatement p = con.prepareStatement("select * from recruiter where name like ?");
		p.setString(1,"%"+searchTitle+"%");
		ResultSet rs = p.executeQuery();
		Recruiter r  = null;
		while(rs.next()){
			r = new Recruiter(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
					rs.getString(6),rs.getString(7));
			recruiters.add(r);
		}
		return recruiters;
	}

	public Recruiter getRecruiter(int recruiterId)throws Exception {
		// TODO Auto-generated method stub
		PreparedStatement p = con.prepareStatement("select * from recruiter where id = ?");
		p.setInt(1, recruiterId);
		ResultSet rs = p.executeQuery();
		Recruiter r = null;
		while(rs.next()){
			r = new Recruiter(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),
					rs.getString(6),rs.getString(7));
			}
		return r;
	}

	public void updateRecruiter(Recruiter r)throws Exception {
		// TODO Auto-generated method stub
		
		PreparedStatement p = con.prepareStatement("update recruiter set name = ?, ph_no= ?, email =?,"
				+ "address = ?, username= ?, password =? where id = ?" );
		p.setString(1, r.getRecruiterName());
		p.setString(2, r.getPhoneNumber());
		p.setString(3, r.getEmail());
		p.setString(4, r.getAddress());
		p.setString(5, r.getUsername());
		p.setString(6, r.getPassword());
		p.setInt(7, r.getId());
		p.executeUpdate();
		con.commit();
	}
	
	public boolean validate(String username, String password) throws Exception {
		PreparedStatement p = con.prepareStatement("select password from recruiter where username= ?");
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

	public int getRecruiterIdByUsername(String username)throws Exception {
		PreparedStatement p = con.prepareStatement("select id from recruiter where username= ?");
		p.setString(1, username);
		ResultSet rs = p.executeQuery();
		int recruiterId = 0;
		if(rs.next()) {
			recruiterId = rs.getInt(1);
		}
		return recruiterId;
	}
	

}
