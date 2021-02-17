package com.cybage;

import java.util.Arrays;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController { 
	@RequestMapping("/home")
	public String home() {
		return "home";
	}

	@RequestMapping("/index")
	public String index() {
		return "index";
	}
}
