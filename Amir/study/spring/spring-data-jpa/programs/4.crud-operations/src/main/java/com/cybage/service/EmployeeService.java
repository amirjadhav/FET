package com.cybage.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cybage.model.Employee;
import com.cybage.repository.EmployeeRepository;

@Service
public class EmployeeService {
	@Autowired
	private EmployeeRepository er;


	@PersistenceContext
	EntityManager em;
	
	public void insert() {
		Employee emp = new Employee("dm101");
		Employee emp1 = new Employee("dm102");
		Employee emp2 = new Employee("dm103");
		Employee emp3 = new Employee("dm104");
		
		er.save(emp);
		er.save(emp1);
		er.save(emp2);
		er.save(emp3);
	
	}
	public List<Employee> findAll(){
		return er.findAll();
	}
	public Optional<Employee> findById(int id) {
		return er.findById(id);
	}
	 
}