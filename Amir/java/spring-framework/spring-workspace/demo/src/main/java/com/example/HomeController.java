package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/user")
public class HomeController {
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String getIndex() {
		return "index";				// http://localhost:8080/user/index.jsp
	}
	
	@GetMapping(path = "/home")
	public String getHome() {
		return "home";		// http://localhost:8080/user/home.jsp
	}
	
	@PostMapping(path = "/emp")
	//@RequestMapping(path = "/emp", method = RequestMethod.POST)
	public String postEmp() {
		return "emp";		// http://localhost:8080/user/emp.jsp
	}
	
	
	
	
	
	
	
		
	@GetMapping("/users")	// http://localhost:8080/user/users
	public String getUser() {
		return "user";
	}
	
	@PostMapping("/users")
	public String postUser() {
		return "postuser";
	}
	
//	@PutMapping("/users")
//	public String updateUser() {
//		return "updateuser";
//	}
//	
//	@DeleteMapping("/users")
//	public String deleteUser() {
//		return "deleteuser";
//	}
	
	
	
	
	
	
}
