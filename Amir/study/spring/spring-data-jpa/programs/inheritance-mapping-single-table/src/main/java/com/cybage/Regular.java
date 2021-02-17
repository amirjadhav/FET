package com.cybage;

import javax.persistence.Entity;

@Entity
public class Regular extends Employee{
	private int salary;

	public Regular() {
		super();
	}

	public Regular(int id, String name ) {
		super(id, name);
	}

	public Regular(int id, String name, int salary) {
		super(id, name);
		this.salary = salary;
	}
	public Regular(String name, int salary) {
		super(name);		
		this.salary = salary;
	}
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Regular [salary=" + salary + ", getId()=" + getId() + ", getName()=" + getName() + "]";
	}
}
