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
	EmployeeRepository er;


	@Override
	public void run(String... args) throws Exception {
		System.out.println("Collection demo...");

		Address a1 = new Address(411046, "Katraj");
		Address a2 = new Address(413203, "solapur");
		List<Address> address = new ArrayList<>();
		address.add(a1);
		address.add(a2);

		Employee e1 = new Employee();	 
		e1.setName("dm101");
		e1.setAddress(address);		
		er.save(e1);


		a1 = new Address(411047, "Kondhwa");
		a2 = new Address(411001, "Pune");
		address = new ArrayList<>();
		address.add(a1);
		address.add(a2);

		e1 = new Employee();	 
		e1.setName("dm102");
		e1.setAddress(address);		
		er.save(e1);



		System.out.println("printing data...");
		System.out.println(er.findById(1));	

		//finding data using city
		System.out.println("Employee from solapur");
		System.out.println(er.findByAddressCity("Pune"));

		//finding data using pin
		System.out.println("Employee from solapur");
		System.out.println(er.findByAddressPin(411046));

	}
}