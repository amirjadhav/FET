package com.cybage.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import com.cybage.dao.DbUtil;
import com.cybage.dao.UserDao;
import com.cybage.model.Users;

public class UserService {
	
	UserDao ud = new UserDao();
	
	public List<Users> getUsers() throws Exception{
		return ud.findAllUsers();
	}
	public int deleteUser(String username) throws Exception{
		return ud.deleteUser(username);
	}
	public int addUser(Users user) throws Exception{
		return ud.addUser(user);
	}
	public Users getUser(String username) throws Exception{		 
		return ud.findUser(username);
	}
	public int updateUser(Users user) throws Exception{
		return ud.updateUser(user);		
	}
}
