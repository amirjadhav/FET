package com.cybage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/home")
	public String home() {
		return "home";	
	}
	@RequestMapping("/")
	public String home1() {
		return "home";	
	}
	@RequestMapping("/index")
	public String index() {
		return "index";	
	}
}


