package com.example;

import java.util.ArrayList;
import java.util.List;

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
		 Account account1 = new Account();
		 account1.setAccountName("accountname1");
		 
		 Account account2 = new Account();
		 account2.setAccountName("accountname2");
		 
		 List<Account> accounts = new ArrayList<Account>();
		 accounts.add(account1);
		 accounts.add(account2);
		 
		 Employee emp = new Employee();
		 emp.setName("myname");
		 emp.setAccount(accounts);
		 
		 er.save(emp);
		 System.out.println(er.findById(1));
	}

}
