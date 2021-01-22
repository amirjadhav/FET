package com.cybage.model;

public class RegularEmployee extends Employee {
	private int salary;

	public RegularEmployee() {
		super();
	}

	public RegularEmployee(int id,String name, String address, int salary) {
		super(id, name, address);
		this.salary = salary;

	}

	@Override
	public String toString() {
		return "RegularEmployee [salary=" + salary + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getAddress()=" + getAddress() + "]";
	}

	@Override
	public int getCompansation() {
		return this.salary;
	}

}