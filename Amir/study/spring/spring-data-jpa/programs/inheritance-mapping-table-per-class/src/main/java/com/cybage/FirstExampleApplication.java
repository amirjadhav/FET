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
	EmployeeRepository<Regular> er;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Collection demo...");
		Regular emp = new Regular("dm", 1234);
		Regular emp1 = new Regular("dm1", 12345);
		er.save(emp);
		er.save(emp1);
	}
}