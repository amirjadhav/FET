package com.cybage;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.annotation.JsonCreator.Mode;

@Controller
public class HomeController {
	
	@RequestMapping("/show")
	public ModelAndView showLogin() {
		Employee emp = new Employee(101, "dm");
		ModelAndView mv = new ModelAndView("login");
		mv.addObject("employee", emp);
		return mv;
	}
	
	@RequestMapping("/example")
	@ResponseBody
	public Employee showInfo() {
		Employee emp = new Employee(101, "dm");		
		return emp;
	}
	
	@PostMapping
	@RequestMapping(name = "/addemp")
	public ResponseEntity<Employee>  add(@RequestBody Employee employee) {
		System.out.println(employee);
		return  ResponseEntity.ok(employee);
	}
}

