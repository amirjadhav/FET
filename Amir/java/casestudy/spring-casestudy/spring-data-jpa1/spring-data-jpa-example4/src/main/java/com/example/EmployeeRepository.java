package com.example;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	public List<Employee> findByHobbyOrderByNameDesc(String hobby); 
	public List<Employee>  findAllByOrderByNameDesc(); 
	
	@Query(value = "select * from employee order by hobby desc",  nativeQuery = true)
	public List<Employee> myMethod(); 
	
	@Query(value = "select e from Employee e order by e.name desc",  nativeQuery = false)
	public List<Employee> myMethod1(); 
	
}
