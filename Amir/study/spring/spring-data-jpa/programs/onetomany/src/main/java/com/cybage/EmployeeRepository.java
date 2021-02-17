package com.cybage;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>{
	List<Employee> findByProjectProjectId(int id);
}
