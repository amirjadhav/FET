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
	
	//adding record
	private void addRecord() {
		er.save(new Employee("dm101"));
		er.save(new Employee("dm102"));
		er.save(new Employee("dm103"));
		er.save(new Employee("dm104"));
	}
	//retrieve record
	public List<Employee> allEmployee(){
		addRecord();
		return er.findAll();
	}
	public Optional<Employee> getEmployeeById(int id) {
		System.out.println(er.findById(id));
		return er.findById(id);
	}

}