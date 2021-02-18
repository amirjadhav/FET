package com.example;

import java.util.Map;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminController {
	
	@GetMapping(path = "/adminhome", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public Employee getAdmin(@RequestParam Map<String, String> allParam) {
		System.out.println(allParam);
		return new Employee(121	, ":asdfasdf");
	}
}
