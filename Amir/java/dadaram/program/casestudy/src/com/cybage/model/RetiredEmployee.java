package com.cybage.model;

public class RetiredEmployee extends Employee{
	//id, name, address inherited
	private int pension;

	public RetiredEmployee() {
		super();
	}

	public RetiredEmployee(int id, String name, String address, int pension) {
		super(id, name, address);
		this.pension = pension;		
	}

	public int getPension() {
		return pension;
	}

	public void setPension(int pension) {
		this.pension = pension;
	}

	@Override
	public String toString() {
		return "RetiredEmployee [pension=" + pension + ", getId()=" + getId() + ", getName()=" + getName()
				+ ", getAddress()=" + getAddress() + "]";
	}

	@Override
	public int getCompensation() {
		return this.pension;
	}	
}