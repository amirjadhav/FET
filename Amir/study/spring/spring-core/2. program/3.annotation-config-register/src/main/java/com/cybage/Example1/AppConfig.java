package com.cybage.Example1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean(name = {"e1", "e2"})
	public Employee getEmp() {
		return new Employee(102, "dmjadhav");
	}
}
