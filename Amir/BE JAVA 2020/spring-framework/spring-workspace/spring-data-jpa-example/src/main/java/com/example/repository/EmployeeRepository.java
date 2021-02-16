package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Employee;

//JpaRepository<Employee, Integer>  : table name and type of primary key
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	
	// spring data jpa will implement all methods related to employee entity
	
}
