package com.cybage.Example;

public class Employee {
	private int empId;
	private String name;
	public Employee() {		
		super();
		System.out.println("empl created");
	}
	public Employee(int empId, String name) {
		super();
		System.out.println("empl created");
		this.empId = empId;
		this.name = name;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + "]";
	}	
}
