package com.cybage;

import java.util.List;
import java.util.Optional;

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
		ur.save(new User("dm101", "swimming", 35));
		ur.save(new User("dm102", "cycling", 36));
		ur.save(new User("dm103", "swimming", 37));
		
		Optional<User> user = ur.findById(1L);
		User usr = user.get();
		usr.setAge(45);
		ur.save(usr);
		System.out.println(usr);
		
	}
 
 	 
}