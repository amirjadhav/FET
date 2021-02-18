package com.example;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AppController {
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.CREATED)
	public String getIndex() {		
		return "index";
	}
	
	@RequestMapping(path = "/home/{id}/{name}", method = RequestMethod.GET) 	 
	public ResponseEntity<String> getIndex1(@RequestBody Employee emp) {
		System.out.println(emp);

		return new ResponseEntity<String>("response from server"+ emp, HttpStatus.OK);		
	}
	
	@RequestMapping(path = "/home1/{id}/{name}", method = RequestMethod.GET) 	 
	public ResponseEntity<String> getIndex2(  @PathVariable int id, @PathVariable String name) {
		Employee emp = new Employee(id, name);
		System.out.println(emp);
		return new ResponseEntity<String>("response from server"+ emp, HttpStatus.OK);		
	}
	
//	//	this is using spring
//	@RequestMapping(path = "/emp", method = RequestMethod.GET) 	 
//	public String getIndex3(Model model) {
//		model.addAttribute("id", 123456);
//		model.addAttribute("name", "dmjadhav");
//		return "viewemp";		
//	}
	
	//	this is using spring
	@RequestMapping(path = "/emp", method = RequestMethod.GET) 	 
	public ModelAndView getIndex3() {
		ModelAndView mv = new ModelAndView("viewemp");		
		mv.addObject("id", 123456);
		mv.addObject("name", "dmjadhav");
		return mv;		
	}
	 
}