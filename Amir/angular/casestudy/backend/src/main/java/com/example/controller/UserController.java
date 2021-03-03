package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.User;
import com.example.repository.UserRepository;

@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserRepository userRepository;

	@GetMapping
	public List<User> getAllUser() {
		return userRepository.findAll();
	}

	@GetMapping("/{id}")
	public Optional<User> getUserById(@PathVariable int id) {
		return userRepository.findById(id);
	}

	@PostMapping
	public User addUser(@RequestBody User user) {
		return userRepository.save(user);
		
	}
	
	@PutMapping
	public User updateUser(@RequestBody User user) {
		return userRepository.save(user);
		
	}
	
	@DeleteMapping("/{id}")
	public void deleteUserById(@PathVariable int id) {
		userRepository.deleteById(id);
	}
}
