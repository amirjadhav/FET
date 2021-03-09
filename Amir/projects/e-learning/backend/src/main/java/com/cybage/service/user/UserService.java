package com.cybage.service.user;

import java.util.List;

import com.cybage.model.User;

public interface UserService {

	List<User> findAll();

	User save(User user);

	User findById(int id);

	User update(User user);

	void deleteById(int id);

}
