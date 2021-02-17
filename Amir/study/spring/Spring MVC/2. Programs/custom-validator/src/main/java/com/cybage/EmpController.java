package com.cybage;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
 import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/addNew")
@SessionAttributes("employee")
public class EmpController 
{	
	@RequestMapping(method = RequestMethod.GET)
	public String setupForm(Model model) 
	{
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "addEmployee";
	}

	@Autowired
	EmployeeValidator validator;
	@RequestMapping(method = RequestMethod.POST)
	public String submitForm(@ModelAttribute("employee") Employee employee,
			BindingResult result, SessionStatus status) {

	    validator.validate(employee, result);
	     
	    if (result.hasErrors()) {
	        return "addEmployee";
	    }
	    status.setComplete();
	    return "redirect:addNew/success";
	}

	
	@RequestMapping(value = "/success", method = RequestMethod.GET)
	public String success(Model model) 
	{
		return "addSuccess";
	}
}