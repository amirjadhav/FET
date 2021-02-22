package com.cybage.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.cybage.model.Users;

public class UserDao {
	public List<Users> findAllUsers() throws Exception{
		String sql = "select * from users";
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ResultSet rs = ps.executeQuery();
		
		List<Users> users = new ArrayList();
		while(rs.next()) {
			users.add(new Users(rs.getString(1), rs.getString(2), rs.getString(3)));
		}
		return users;
	}
	
	public Users findUser(String username) throws Exception{
		String sql = "select * from users where username = ? ";
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);
		ResultSet rs = ps.executeQuery();
		
		Users user = new Users();
		if(rs.next()) {
			user = new Users(rs.getString(1), rs.getString(2), rs.getString(3));
		}
		System.out.println("inside dao: "+ user);
		return user;
	}
	public int deleteUser(String username) throws Exception {
		String sql = "delete from users where username=?";
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, username);
		return ps.executeUpdate();		
	}
	public int addUser(Users user) throws Exception{
		String sql = "insert into users values (?, ?, ?)";
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user.getUsername());
		ps.setString(2, user.getPassword());
		ps.setString(3, user.getRole());
		return ps.executeUpdate();
	}

	public int updateUser(Users user) throws Exception{		
		String sql = "update users set password = ?, userrole = ? where username = ? ";
		Connection con = DbUtil.getConnection();
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, user.getPassword());
		ps.setString(2, user.getRole());
		ps.setString(3, user.getUsername());
		return ps.executeUpdate();
	}
}
