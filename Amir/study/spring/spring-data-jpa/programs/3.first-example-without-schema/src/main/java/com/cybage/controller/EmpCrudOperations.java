package com.cybage.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.model.Employee;
import com.cybage.service.EmployeeService;

@RestController
public class EmpCrudOperations {
	@Autowired
	EmployeeService es;

	@GetMapping("/emploee")
	public List<Employee> findAll(){
		return es.allEmployee(); 
	}
	@GetMapping("/emploee/{id}")
	public Optional<Employee> findAll(@PathVariable int id){
		System.out.println("id is: "+ id);
		return es.getEmployeeById(id); 
	}
}