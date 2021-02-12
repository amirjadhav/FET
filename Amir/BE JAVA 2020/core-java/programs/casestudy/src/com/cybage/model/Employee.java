package com.cybage.model;

public abstract class Employee{		//class which is incomplete
	//properties, instance variables
	private int id;
	private String name;
	private String address;
	
	
	//constructor, constructor overloading
	public Employee(){
		System.out.println("empty object created");
		this.id = 0;
		this.name = null;
		this.address = null;
	}
	public Employee(int id, String name, String address){	//local variable
	//	System.out.println("object with values created");
		this.id = id;
		this.name = name;
		this.address = address;
	}
	public int getId() {
		return this.id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return this.name;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getAddress() {
		return this.address;
	}
	
	@Override
	public String toString() {
return "Employee [id: "+ this.id+ ", name: "+ this.name + ",address: "+this.address+ "]";
	}
	
	public abstract int getCompensation();	//no definition
}
