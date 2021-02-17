package com.cybage;

import java.util.Arrays;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;
 
@Controller 
public class HomeController { 
	@Autowired
	private GreetingService greetingService;
	@RequestMapping("/")
	public String home() {
		System.out.println(greetingService.getGreetingMsg());
		return "home";
	}
}
