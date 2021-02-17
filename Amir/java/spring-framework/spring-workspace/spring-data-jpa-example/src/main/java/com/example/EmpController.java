package com.example;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class EmpController {
//
//	@Autowired
//	EmployeeRepository er;
//
////	// add employee
////	@RequestMapping(path = "/employee/{name}", method = RequestMethod.POST)
////	@ResponseBody
////	public String addEmployee(@PathVariable String name) {
////		er.save(new Employee(name));
////		return "successfully added employee with name : " + name;
////	}
//
//	// get employee
//	@RequestMapping(path = "/employee", method = RequestMethod.GET)
//	@ResponseBody
//	public List<Employee> getAllEmployee() {
//		return er.findAll();
//	}
//
//	// get employee
//	@RequestMapping(path = "/employee/{id}", method = RequestMethod.GET)
//	@ResponseBody
//	public Optional<Employee> getEmployeeById(@PathVariable int id) {
//		return er.findById(id);
//	}
//
//	// get employee by name
//	@RequestMapping(path = "/employee/name/{name}", method = RequestMethod.GET)
//	@ResponseBody
//	public List<Employee>  getEmployeeByName(@PathVariable String name) {
//		return er.myMethodName(name);
//	}
//
//	// delete employee
//	@RequestMapping(path = "/employee/{id}", method = RequestMethod.DELETE)
//	@ResponseBody
//	public String deleteEmployeeById(@PathVariable int id) {
//		er.deleteById(id);
//		return "deleted employee with id : " + id;
//	}
//
////	// delete employee
////	@RequestMapping(path = "/employee/{id}/{name}", method = RequestMethod.PUT)
////	@ResponseBody
////	public String updateEmployee(@PathVariable int id, @PathVariable String name) {
////		er.save(new Employee(id, name));
////		return "updated employee with id : " + id;
////	}
}