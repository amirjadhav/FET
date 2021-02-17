package com.cybage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
		User user2 = new User("bdm101", "cycling", 40);
		User user3 = new User("cdm101", "running", 39);
		User user4 = new User("ddm101", "dancing", 38);
		User user5 = new User("edm101", "swimming", 37);
		User user6 = new User("fdm101", "swimming", 42);
		User user7 = new User("fdm101", "swimming", 41);
		User user8 = new User("fdm101", "swimming", 40);
		ur.save(user1);
		ur.save(user2);
		ur.save(user3);
		ur.save(user4);	
		ur.save(user5);	
		ur.save(user6);	
		ur.save(user7);	
		ur.save(user8);	
		
		System.out.println("------printing all records-----");
		System.out.println(ur.findAll());
		
		System.out.println("------printing certain hobbies-----");
		System.out.println(ur.findByHobbyOrderByNameAsc("swimming"));
		
		System.out.println("------JPQL order by clause (asc)-----");
		System.out.println(ur.findUsersAsc());				
	
		System.out.println("------JPQL order by clause (desc)-----");
		System.out.println(ur.findUsersDesc());	
		
		System.out.println("-------Sorting with a Sort Parameter-----------");
		System.out.println(ur.findAll(Sort.by(Sort.Direction.ASC, "name")));
		
		System.out.println("-------Sorting with a Sort Parameter-----------");
		System.out.println(ur.findAll(Sort.by("age")));
		
		
		System.out.println("-------Sorting with a Sort Parameter-----------");
		Page<User> page = ur.findAll(PageRequest.of(0, 3, Sort.Direction.ASC, "name"));
		System.out.println(page.getContent());
		
		//query using query generation and sorting
		System.out.println("query using query generation and sorting");
		List<User> result = ur.findByName("fdm101", Sort.by(Sort.Direction.DESC, "age"));
		System.out.println(result);
		
		
		//with sort inside method of @Query
		System.out.println("with sort inside method of @Query");
		System.out.println(ur.myMethodofSorting(Sort.by(Sort.Direction.DESC, "name")));
	}
	 
}
