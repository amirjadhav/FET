package com.cybage;
 
import java.util.ArrayList;
import java.util.Arrays;
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
		
		Employee e1 = new Employee("dm1");
		Employee e2 = new Employee("dm2");
		Employee e3 = new Employee("dm3");
		
		Project p1 = new Project("project1");
		Project p2 = new Project("project2");
		Project p3 = new Project("project3");				
		
		er.save(e1);
		pr.saveAll(Arrays.asList(p1, p2, p3));
		
		
		
		System.out.println("printing data");
//		System.out.println(er.findById(1));
	}
}