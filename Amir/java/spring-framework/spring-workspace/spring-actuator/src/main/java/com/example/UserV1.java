package com.example;

public class UserV1 {
	private int id;
	private String name;
	private int sal;
	public UserV1() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserV1(int id, String name, int sal) {
		super();
		this.id = id;
		this.name = name;
		this.sal = sal;
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
	public int getSal() {
		return sal;
	}
	public void setSal(int sal) {
		this.sal = sal;
	}
	@Override
	public String toString() {
		return "UserV1 [id=" + id + ", name=" + name + ", sal=" + sal + "]";
	}
	
	
	
}
