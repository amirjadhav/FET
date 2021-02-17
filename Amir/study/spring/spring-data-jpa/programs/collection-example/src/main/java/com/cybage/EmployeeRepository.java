package com.cybage;

import java.util.List;

import javax.persistence.Embeddable;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
	//query data from embeddable table
	List<Employee> findByAddressPin(int pin);
	List<Employee> findByAddressCity(String city);	
	
}
