package com.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.model.Employee;
import com.example.repository.EmployeeRepository;

@Controller
public class EmpController {

	@Autowired
	EmployeeRepository er;

	// add employee
	@RequestMapping(path = "employee/{name}", method = RequestMethod.POST)
	@ResponseBody
	public String addEmployee(@PathVariable String name) {
		er.save(new Employee(name));
		return "Employee added with name " + name;
	}

	@RequestMapping(path = "/employee", method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> getAllEmployee() {
		return er.findAll();
	}

	@RequestMapping(path = "/employee/{id}", method = RequestMethod.GET)
	@ResponseBody
	public Optional<Employee> getEmployeeById(@PathVariable int id) {
		System.out.println(er.findById(id));
		return er.findById(id);

	}

	@RequestMapping(path = "/employee/{id}", method = RequestMethod.DELETE)
	@ResponseBody
	public void deleteEmployeeById(@PathVariable int id) {
		er.deleteById(id);
	}
	
	@RequestMapping(path = "/employee/name/{name}", method = RequestMethod.GET)
	@ResponseBody
	public List<Employee> findEmployeeByName(@PathVariable String name) {
		return er.myfindByName(name);
	}
	
	@RequestMapping(path = "/employee/{id}/{name}", method = RequestMethod.PUT)
	@ResponseBody
	public String UpdateEmployeeById(@PathVariable int id,@PathVariable String name) {
		er.save(new Employee(id,name));
		return "Employee updated with id "+id;
		
	}
	
	@RequestMapping("/count")
	@ResponseBody
	public Long count() {
		er.save(new Employee(1, "amir"));
		System.out.println(er.count());
		return er.count();

	}

}
