package com.cybage;

import java.util.ArrayList;
import java.util.List;

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
	EmployeeRepository<Regular> rr;

	@Autowired
	EmployeeRepository<Contract> cr;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Collection demo...");
		Regular emp = new Regular("dm", 1234);
		Regular emp1 = new Regular("dm1", 12345);
		rr.save(emp);
		rr.save(emp1);

		Contract c1 = new Contract("c1", 543);
		Contract c2 = new Contract("c2", 543234);
		cr.save(c1);
		cr.save(c2);
		
		System.out.println("printing... (regular)");
		System.out.println(rr.findAll());
		
		
		System.out.println("printing... (contract)");
		System.out.println(cr.findAll());
		
		


	}
}