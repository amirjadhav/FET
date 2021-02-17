package com.cybage;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.cybage")
public class FirstExampleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FirstExampleApplication.class, args);	
	}
	@Autowired
	EmployeeRepository er;
	
	@Autowired
	ProjectReposity pr;
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Collection demo...");
		
		Employee e1 = new Employee();		 
		e1.setName("dm101");		
		er.save(e1);	 
		
		
		Project p1 = new Project("cybage-training", e1);
		Project p2 = new Project("cybage-education", e1);
		pr.save(p1);
		pr.save(p2);
		
		System.out.println("printing data");
		System.out.println(er.findAll());
	}
}