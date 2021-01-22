package com.cybage.model;

public abstract class Employee {
	private int id;
	private String name;
	private String address;

	public Employee() {
		this.id = 0;
		this.name = null;
		this.address = null;
	}

	public Employee(int id, String name, String address) {
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

	public void setAddress(String add) {
		this.address = add;
	}

	public String getAddress() {
		return this.address;
	}

	@Override
	public String toString() {
		return "Employee id : " + this.id + " , name : " + this.name + " , Address : " + this.address;
	}
	public abstract int getCompansation();
}

