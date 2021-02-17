package com.cybage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.config.EnableSpringDataWebSupport;
 
import com.cybage.model.User;
import com.cybage.repository.UserRepository;

@SpringBootApplication
@EnableSpringDataWebSupport
public class FirstExampleApplication implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(FirstExampleApplication.class, args);
	}
	@Autowired
	UserRepository ur;
	
	@Override
	public void run(String... args) throws Exception {
		
		System.out.println("------inserting records-----");
		User user1 = new User("adm101", "swimming", 41);
		User user2 = new User("bdm102", "cycling", 40);
		User user3 = new User("cdm103", "running", 39);
		User user4 = new User("ddm104", "dancing", 38);
		User user5 = new User("edm105", "swimming", 37);
		User user6 = new User("fdm106", "swimming", 42);
		User user7 = new User("fdm107", "swimming", 41);
		User user8 = new User("fdm108", "swimming", 40);

		ur.save(user1);
		ur.save(user2);
		ur.save(user3);
		ur.save(user4);	
		ur.save(user5);	
		ur.save(user6);	
		ur.save(user7);	
		ur.save(user8);		

		//without sorting
		Page<User> result = ur.findAll(PageRequest.of(0, 4));
		for(User r : result) {
			System.out.println(r);
		}
		
		//with sorting
		System.out.println("with sorting");
		result = ur.findAll(PageRequest.of(0, 4, Sort.by("age")));
		for(User r : result) {
			System.out.println(r);
		}
	}
}