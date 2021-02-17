package com.cybage;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.cybage")
public class FirstExampleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FirstExampleApplication.class, args);	
	}
	@Autowired
	EmployeeRepository er;
	
	
	@Override
	public void run(String... args) throws Exception {
		System.out.println("Collection demo...");
		
		Employee e1 = new Employee();	 
		Project p1 = new Project();
		e1.setName("dm101");
		e1.setProject(p1);
		p1.setProjectName("training");
		p1.setEmployee(e1);
		er.save(e1);
		
		System.out.println("printing data...");
//		System.out.println(er.findById(1));
		
		System.out.println("finding by project name");
		System.out.println(er.findByProjectProjectName("training"));
	}
}