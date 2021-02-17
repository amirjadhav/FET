package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PaginationAndSortingApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(PaginationAndSortingApplication.class, args);
	}
	@Autowired
	EmployeeRepository er;
	@Override
	public void run(String... args) throws Exception {
		er.save(new Employee("admin101","swimming"));
		er.save(new Employee("ddmin101","swimming"));
		er.save(new Employee("edmin101","swimming"));
		er.save(new Employee("sdmin101","swimming"));
		er.save(new Employee("bdmin101","cricket"));
		
		//System.out.println(er.findByHobbyOrderByName("swimming"));
		System.out.println(er.findAllByOrderByName());
		
		
	}
	
	
}
