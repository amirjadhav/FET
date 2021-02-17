package com.cybage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


//using controller annotation 
@Controller
public class HomeController {
	@RequestMapping("/")
	public String home() { 
		return "home";	
	}
	@RequestMapping("/index")
	public String index() {
		return "index";	
	}
}


