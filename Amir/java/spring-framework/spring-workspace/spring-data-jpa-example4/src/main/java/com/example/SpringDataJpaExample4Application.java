package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@SpringBootApplication
public class SpringDataJpaExample4Application implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaExample4Application.class, args);
	}
	
	@Autowired
	EmployeeRepository er;
	
	@Override
	public void run(String... args) throws Exception {
		er.save(new Employee("adm101", "running"));
		er.save(new Employee("bdm101", "running"));
		er.save(new Employee("cdm101", "swimming"));
		er.save(new Employee("ddm101", "swimming"));		
		er.save(new Employee("edm101", "dancing"));
		er.save(new Employee("fdm101", "dancing"));
		er.save(new Employee("gdm101", "cricket"));
		er.save(new Employee("hdm101", "cricket"));
		er.save(new Employee("idm101", "running"));
		er.save(new Employee("jdm101", "running"));
		er.save(new Employee("kdm101", "swimming"));
		er.save(new Employee("ldm101", "swimming"));		
		er.save(new Employee("mdm101", "dancing"));
		er.save(new Employee("ndm101", "dancing"));
		er.save(new Employee("odm101", "cricket"));
		er.save(new Employee("pdm101", "cricket"));

		//System.out.println(er.findAllByOrderByNameDesc());
		//System.out.println(er.findAll(Sort.by(Sort.Direction.ASC, "hobby")));	

		System.out.println(er.myMethod());
		System.out.println(er.myMethod1());
		System.out.println("---------------------------------------------");
		
		Page<Employee> page = er.findAll(PageRequest.of(0, 8, Sort.Direction.DESC, "hobby"));
		System.out.println(page.getTotalPages());	//total pages
		System.out.println(page.getNumber());		//page number
		System.out.println(page);
		System.out.println(page.getContent());
	}

}
