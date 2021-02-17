package com.cybage.Example;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

public class Employee{
	private int empId;
	private String name;
	public Employee() {
		super();
	}
	public Employee(int empId, String name) {
		super();
		this.empId = empId;
		this.name = name;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + "]";
	}
	
	@PostConstruct
	public void myDestroyMethod() throws Exception {
		System.out.println("employee is getting deleted");
	}
	@PreDestroy
	public void myInitMethod() throws Exception {
		System.out.println("all property set...");
	}
}