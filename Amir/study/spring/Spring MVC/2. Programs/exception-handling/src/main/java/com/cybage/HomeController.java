package com.cybage;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class HomeController {
	@RequestMapping("/home")
	public String home() {
		System.out.println(10/0);
		return "home";	
	}
	
 
	
	@RequestMapping("/index")
	public String index() {
		return "index";	
	}

	@RequestMapping("/user")
	@ExceptionHandler({MyException.class})	//method level exception
	public String user() {
		return "user";	
	}

	//exception handling at controller level
	@ExceptionHandler(MyException.class)
	public ModelAndView handleException(MyException	me) {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("ExceptionPage");
		modelAndView.addObject("message", me.getExceptionMsg());
		return modelAndView;
	}
}

