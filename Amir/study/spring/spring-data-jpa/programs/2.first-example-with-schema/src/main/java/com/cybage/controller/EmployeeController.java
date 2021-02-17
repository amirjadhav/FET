package com.cybage.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController    
public class EmployeeController {
	@GetMapping
	public String index() {
		return "this is index page";
	}
}