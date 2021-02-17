package com.cybage.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.model.Employee;
import com.cybage.service.EmployeeService;

@RestController
public class EmpCrudOperations {
	@Autowired
	EmployeeService es;

	@GetMapping("/allemp")
	public List<Employee> findAll(){
		
		return es.allEmployee(); 
	}
}