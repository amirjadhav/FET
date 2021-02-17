package com.cybage.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.model.User;
import com.cybage.repository.UserRepository;


@RestController
@RequestMapping("/user")
public class EmpCrudOperations {
	@Autowired
	UserRepository ur;
	@GetMapping
	public List<User> findAll() {
		return ur.findAll();
	}
	@GetMapping("/{age}")
	public List<User> findByAge(@PathVariable int age) {
		return ur.findByAge(age);
	}
	@GetMapping("/active/{active}")
	public List<User> findByActive(@PathVariable int active) {
		return ur.findByActive(active);
	}
}