package com.cybage;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.cybage.auditing.AuditorAwareImpl;
import com.cybage.model.User;
import com.cybage.repository.UserRepository;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditorAware")
public class FirstExampleApplication{

	public static void main(String[] args) {
		SpringApplication.run(FirstExampleApplication.class, args);
	}

	@Bean
	public AuditorAware<String> auditorAware() {
		return new AuditorAwareImpl();
	}

}
