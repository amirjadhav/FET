package com.cybage;

public class CurrentAccount implements Account{
	private int id;
	private String name;
	public CurrentAccount() {
		super();
	}
	public CurrentAccount(int id, String name) {
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
		return "CurrentAccount [id=" + id + ", name=" + name + "]";
	}
}
