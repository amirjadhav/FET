package com.example;

import java.util.List;

import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
 

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	public List<Employee> findByHobbyOrderByName(String hobby);
	public List<Employee> findAllByOrderByName();
	
}
