package com.cybage;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // This class used for configuration
public class ConfigClass {

	@Bean(name = "emp")
	public Employee getEmp() {
		return new Employee(101, "dm101");
	}

	@Bean(name = "emp1")
	public Employee getEmp1() {
		return new Employee(102, "dm102");
	}
}
