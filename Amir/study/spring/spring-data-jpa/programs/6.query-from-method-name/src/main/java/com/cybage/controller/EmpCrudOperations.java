package com.cybage.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
	@GetMapping("/1")
	public Optional<User> findByLastnameAndFirstname(){
		return ur.findByLastnameAndFirstname("jadhav", "asha");
	}
	@GetMapping("/2")
	public List<User> findByLastnameOrFirstname(){
		return ur.findByLastnameOrFirstname("jadhav123", "asha");
	}
	@GetMapping("/3")
	public List<User> findByAgeLessThan(){
		return ur.findByAgeLessThan(37);
	}
}