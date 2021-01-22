package com.cybage.model;

public class RetiredEmployee extends Employee {
	private int pension;

	public RetiredEmployee() {
		super();
	}

	public RetiredEmployee(int id,String name, String address, int pension) {
		super(id, name, address);
		this.pension= pension;

	}

	@Override
	public String toString() {
		return "RegularEmployee [salary=" + pension + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getAddress()=" + getAddress() + "]";
	}

	@Override
	public int getCompansation() {
		
		return this.pension;
	}

}