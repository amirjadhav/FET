package com.cybage.controller;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cybage.model.Employee;
import com.cybage.service.EmployeeService;

@RestController
public class EmpCrudOperations {
	@Autowired
	EmployeeService es;

	@GetMapping("/insert")
	public String insert() {
		es.insert();
		return "added into database";
	}
	@GetMapping("/employee")
	public List<Employee> findAll(){
		return es.findAll(); 
	}
	@GetMapping("/employee/{id}")
	public Optional<Employee> findById(@PathVariable("id") int id){
		return es.findById(id); 
	}
	
}