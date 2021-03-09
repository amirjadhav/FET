package com.cybage.service.user;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.model.User;
import com.cybage.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository userRepository;

	@Override
	public List<User> findAll() {
		return userRepository.findAll();
	}

	@Override
	public User save(User user) {
		return userRepository.save(user);
	}

	@Override
	public User findById(int id) {
		return userRepository.findById(id).get();
	}

	@Override
	public User update(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteById(int id) {
		userRepository.deleteById(id);

	}

}
