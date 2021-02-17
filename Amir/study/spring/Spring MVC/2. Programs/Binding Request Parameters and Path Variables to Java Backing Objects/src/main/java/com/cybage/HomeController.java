package com.cybage;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {
	@RequestMapping("/employee")	 		//binding request param to employee
	public String home(Employee emp, Model model) {
		System.out.println(emp);
		model.addAttribute("emp", emp);
		return "home";	
	}

	@RequestMapping("/employee/{id}/{name}")			//binding path param to employee
	public String home1(Employee emp, Model model) {
		System.out.println(emp);
		model.addAttribute("emp", emp);
		return "home";	
	}
}
