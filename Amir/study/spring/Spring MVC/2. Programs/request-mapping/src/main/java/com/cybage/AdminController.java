package com.cybage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("admin")		
public class AdminController {
	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String admin() {
		return "admin";	
	}
	@RequestMapping(path = "/product", produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<String> getProduct(){
		List<String> city = new ArrayList<String>();
		city.add("Pune");
		city.add("Mumbai");
		city.add("Delhi");
		city.add("Chennai");
		return city;
	}	
}

