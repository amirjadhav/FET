package com.cybage;

import javax.persistence.Entity;

@Entity
public class Contract extends Employee{
	private int rate;

	public Contract() {
		super();
	}

	public Contract(int id, String name) {
		super(id, name);
	}
	public Contract(String name, int rate) {
		super(name);
		this.rate = rate;
	}
	public Contract(String name) {
		super(name);
	}

	public int getRate() {
		return rate;
	}

	public void setRate(int rate) {
		this.rate = rate;
	}

	@Override
	public String toString() {
		return "Contract [rate=" + rate + ", getId()=" + getId() + ", getName()=" + getName() + "]";
	}

}
