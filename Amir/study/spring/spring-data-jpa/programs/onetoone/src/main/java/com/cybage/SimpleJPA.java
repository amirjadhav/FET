package com.cybage;

import javax.persistence.EntityManager;

import org.springframework.data.jpa.repository.support.SimpleJpaRepository;

public class SimpleJPA extends SimpleJpaRepository<Employee, Integer>{

	public SimpleJPA(Class<Employee> domainClass, EntityManager em) {
		super(domainClass, em);
		// TODO Auto-generated constructor stub
	}
	
}
