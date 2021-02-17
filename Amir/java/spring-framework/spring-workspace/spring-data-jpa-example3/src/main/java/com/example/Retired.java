package com.example;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class Retired extends Employee{
	private int pension;

	public Retired() {
		super();
	}

	public Retired(int id, String name) {
		super(id, name);
	}

	public Retired(String name) {
		super(name);
	}
	public Retired(String name, int pension) {
		super(name);
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
		return "Retired [pension=" + pension + ", getPension()=" + getPension() + "]";
	}
	
}
