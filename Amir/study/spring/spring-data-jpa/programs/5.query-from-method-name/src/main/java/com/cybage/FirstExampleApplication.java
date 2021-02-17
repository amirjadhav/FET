package com.cybage;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.cybage.model.User;
import com.cybage.repository.UserRepository;

@SpringBootApplication
public class FirstExampleApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(FirstExampleApplication.class, args);
	}
	
	@Autowired
    private UserRepository userRepository;
	@Override
	public void run(String...args) throws Exception {
		User user = new User();
		user.setActive(1);
		user.setAge(35);
		user.setEmailAddress("dm@gmail.com");
		user.setFirstname("dm");
		user.setLastname("jadhav");
		user.setStartDate(new Date());
		user = userRepository.save(user);

		System.out.println("-------------------------------------:: " + user.getId());

		System.out.println(" ---------------@NamedQuery ---------------------");
		System.out.println("--------------findByEmailAddress -----------------");

		User user2 = userRepository.findByEmailAddress("dm@gmail.com");
		System.out.println(user2.toString());

		System.out.println(" ---------------@NamedQuery ---------------------");
		System.out.println("--------------findByLastname -----------------");

		List < User > user3 = userRepository.findByLastname("jadhav");
		System.out.println(user3.get(0).toString());
	}

}
