package com.cybage.Example1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
	@Bean("emp")
	public Employee getEmp() {
		return new Employee(102, "dmjadhav");
	}
}
