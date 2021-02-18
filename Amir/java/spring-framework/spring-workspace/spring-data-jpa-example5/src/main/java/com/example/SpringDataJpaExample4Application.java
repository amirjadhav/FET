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
	
	@Autowired
	AccountRepository ar;
	
	@Override
	public void run(String... args) throws Exception {
		 Account account = new Account();
		 account.setAccountName("accountname");
		 
		 Employee emp = new Employee();
		 emp.setName("myname");
		 emp.setAccount(account);
		 
		 account.setEmployee(emp);
		 
		 er.save(emp);
		 System.out.println(er.findAll());
	}

}
