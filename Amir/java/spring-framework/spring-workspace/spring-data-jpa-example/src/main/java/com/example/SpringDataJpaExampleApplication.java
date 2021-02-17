package com.example;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringDataJpaExampleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaExampleApplication.class, args);
	}
	@Autowired
	RegularRepository rr;
	
	@Autowired
	RetiredRepository retRepo;
	
	
	@Override
	public void run(String... args) throws Exception {
		 rr.save(new Regular("regularEmp", 12345));
		 System.out.println(rr.findAll());
		 
		 retRepo.save(new Retired("retiredemp", 100));
		 System.out.println(retRepo.findAll());
	}

}
