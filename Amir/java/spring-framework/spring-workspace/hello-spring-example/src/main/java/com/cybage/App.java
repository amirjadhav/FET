package com.cybage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App {

	public static void main(String[] args) {
		//1. using beans.xml
		/*
		 * //Employee emp = new Employee(101,"amir");
		 * 
		 * ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		 * // load and create employee object in container //Employee object stored in
		 * IOC container
		 * 
		 * 
		 * boolean isAvailable = context.containsBean("emp");
		 * 
		 * if(isAvailable) {
		 * System.out.println("Employee Objet is available in IOC container"); }
		 * 
		 * // Employee e = context.getBean("emp",Employee.class); Employee e =
		 * (Employee)context.getBean("emp"); System.out.println(e);
		 */

		//2. using config

		// ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
		ApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);

		Employee e = (Employee) context.getBean("emp");
		System.out.println(e);

		Employee e1 = (Employee) context.getBean("emp1");
		System.out.println(e1);

	}
}
