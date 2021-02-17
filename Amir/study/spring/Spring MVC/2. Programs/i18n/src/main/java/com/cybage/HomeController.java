package com.cybage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

@Controller
public class HomeController {
	@RequestMapping("/home")
	public String home(Model model) {
		List<Employee> list = new ArrayList<Employee>();
		list.add(new Employee(101, "dm101", "email"));
		list.add(new Employee(102, "dm102", "email"));
		model.addAttribute("employees", list);
		
		return "home";
	}
}
