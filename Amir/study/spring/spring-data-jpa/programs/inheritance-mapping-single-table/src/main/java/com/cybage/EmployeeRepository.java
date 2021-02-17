package com.cybage;

import java.util.List;

import javax.persistence.Embeddable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface EmployeeRepository<T extends Employee>  
extends CrudRepository<T, Integer>{
	
}
