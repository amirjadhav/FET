package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(path = "/user")
public class HomeController {

	@RequestMapping(path = "/", method = RequestMethod.GET)
	public String indexPage() {
		return "index";
	}

	@GetMapping(path = "/home") // http://localhost:8080/user/home
	public String Home() {
		return "home";
	}

	@PostMapping(path = "/home")
	public String postMethod() {
		return "post";
	}
}
