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
	@RequestMapping("set")
	public String handleTestRequest (Model model,
			HttpServletRequest request,
			HttpServletResponse response) {


		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			Arrays.stream(cookies)
			.forEach(c -> System.out.println(c.getName() + "=" + c.getValue()));
		}

		Cookie newCookie = new Cookie("testCookie", "dmjadhav");
		newCookie.setMaxAge(24 * 60 * 60);
		response.addCookie(newCookie);

		model.addAttribute("msg", "test method msg");
		return "home";
	}

	@RequestMapping("get")
	public String handleRequest (
			@CookieValue(value = "testCookie",
			defaultValue = "defaultCookieValue")
			String cookieValue, Model model) {
		System.out.println(cookieValue);
		model.addAttribute("cookieValue", cookieValue);

		return "home";
	}
}
