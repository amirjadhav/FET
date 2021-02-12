package com.cybage;

public class Employee {

	private int id = 1234;
	private String name = "dm";
	
	
	public Employee(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	@Override	//we are modifying toString from Object class
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + "]";
	}
	public void display(int a) {
		int temp = 10;
		System.out.println(a + temp);
	}
}
