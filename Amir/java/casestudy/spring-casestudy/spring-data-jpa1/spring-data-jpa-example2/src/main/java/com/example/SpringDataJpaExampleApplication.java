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
		  
		 rr.save(new Regular("dm102", 12345));
		 retRepo.save(new Retired("dm103", 100));
		  
		 System.out.println("------------------");
		 
		 System.out.println("------------------");
		 System.out.println(rr.findById(1));
		 System.out.println("------------------");
		 System.out.println(retRepo.findById(2));
	}
}
