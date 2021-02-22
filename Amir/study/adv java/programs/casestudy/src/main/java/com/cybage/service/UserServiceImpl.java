package com.cybage.service;

import java.sql.SQLException;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.cybage.dao.UserDao;
import com.cybage.model.User;

public class UserServiceImpl implements UserService{

	public static final Logger log = LogManager.getLogger(UserServiceImpl.class);
	
	private UserDao userDao;
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
	}
	
	private int generateId() {
		int userId = (int)Math.round(Math.random()*99999);
		log.info("user id generated... "+ userId);
		return userId;
	}
	
	@Override
	public int addUer(User user) throws   SQLException{
		if(user.getId() == 0) {
			user.setId(generateId());	
		}		
		log.debug("inside add user ...");
		return userDao.addUer(user);
	}

	@Override
	public List<User> findUser() throws SQLException{

		log.debug("inside find user...");
		return userDao.findUser();
	}

	@Override
	public int deleteUser(int id) throws SQLException {		
		log.debug("inside delete user ...");
		return userDao.deleteUser(id);
	}

	
	@Override
	public User findUserById(int id) throws SQLException {	
		log.debug("inside finding user by id ...");
		return userDao.findUserById(id);
	}
	@Override
	public int udpateUser(User user) throws SQLException {		
		return userDao.udpateUser(user);
	}

}
