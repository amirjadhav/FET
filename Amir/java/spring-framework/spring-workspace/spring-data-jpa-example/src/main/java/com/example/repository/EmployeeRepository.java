package com.example.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.model.Employee;

//JpaRepository<Employee, Integer>  : table name and type of primary key
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

	@Query("select e from Employee e where e.name = ?1")
	public List<Employee> myfindByName(String name);
	// spring data jpa will implement all methods related to employee entity
	
}
