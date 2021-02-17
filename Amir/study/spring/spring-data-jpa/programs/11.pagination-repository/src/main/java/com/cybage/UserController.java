package com.cybage;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.model.User;
import com.cybage.repository.UserRepository;

@RestController
public class UserController {
	@Autowired
	UserRepository ur;
	
	@GetMapping("/user")
	public void getUsers() {
		System.out.println("finding all");
		Page<User> result = ur.findAll(PageRequest.of(0, 3));
		for(User u: result) {
			System.out.println(u);
		}
		
		System.out.println("find using hobby");
		System.out.println(ur.findByHobby("swimming", PageRequest.of(0, 2)));
		
		System.out.println("find using age");
		System.out.println(ur.findByAge(35, PageRequest.of(0, 2)));
		
		System.out.println("finding by name");
		System.out.println(ur.findByName("adm", PageRequest.of(0, 2)));
	}
}