package com.cybage.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.sql.SQLException;

import org.junit.jupiter.api.Test;

import com.cybage.model.User;

class UserDaoImplTest {
	
	UserDao userDao = new UserDaoImpl();
	@Test
	void testAddUser() throws SQLException {
		int addCount = userDao.addUer(new User(102, "dm101", "dm101", "pune101"));
		assertEquals(1, addCount);
	}

}
