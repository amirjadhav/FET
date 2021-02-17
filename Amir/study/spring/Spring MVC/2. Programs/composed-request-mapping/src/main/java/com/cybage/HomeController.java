package com.cybage;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {
	@GetMapping("/get")
	public @ResponseBody ResponseEntity<String> get(@RequestHeader Map<String, String> header){
		System.out.println(header);
		return new ResponseEntity<String>("GET Response", HttpStatus.OK);
	}
	@GetMapping("/get/{id}")
	public @ResponseBody ResponseEntity<String>
	  getById(@PathVariable String id) {
	    return new ResponseEntity<String>("GET Response : "
	      + id, HttpStatus.OK);
	}
	@PostMapping("/post")
	public @ResponseBody ResponseEntity<String> post() {
	    return new ResponseEntity<String>("POST Response", HttpStatus.OK);
	}
	@PutMapping("/put")
	public @ResponseBody ResponseEntity<String> put() {
	    return new ResponseEntity<String>("PUT Response", HttpStatus.OK);
	}
	@DeleteMapping("/delete")
	public @ResponseBody ResponseEntity<String> delete() {
	    return new ResponseEntity<String>("DELETE Response", HttpStatus.OK);
	}
}

