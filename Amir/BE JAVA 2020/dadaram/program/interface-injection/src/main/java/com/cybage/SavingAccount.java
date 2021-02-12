package com.cybage;

public class SavingAccount implements Account{
	private int id;
	private String name;
	public SavingAccount() {
		super();
	}
	public SavingAccount(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "SavingAccount [id=" + id + ", name=" + name + "]";
	}	
}
