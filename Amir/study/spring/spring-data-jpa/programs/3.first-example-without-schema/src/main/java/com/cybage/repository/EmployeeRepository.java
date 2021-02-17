package com.cybage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cybage.model.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	
}
