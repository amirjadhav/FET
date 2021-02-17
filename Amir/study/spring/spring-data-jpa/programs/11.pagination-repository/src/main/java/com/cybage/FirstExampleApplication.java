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
public class FirstExampleApplication  {

	public static void main(String[] args) {
		SpringApplication.run(FirstExampleApplication.class, args);
	}
 
 	 
}