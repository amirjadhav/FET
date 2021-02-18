package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FormController {
	
	@RequestMapping(path = "/showform")
	public String showForm(Model model) {		
		System.out.println(10/0);
		Employee emp = new Employee(101, "dm101");
		model.addAttribute("emp", emp);
		return "show-form";
	}
	
	@RequestMapping(path = "/submit-form", method = RequestMethod.POST)
	public void submitForm(@ModelAttribute("emp") Employee emp) {		
		System.out.println("form submitted successfully..." + emp);
	}
}
