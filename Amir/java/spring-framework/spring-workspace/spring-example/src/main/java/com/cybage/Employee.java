package com.cybage;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;

public class Employee implements InitializingBean, DisposableBean{
	private int id;
	private String name;
	private Address address;
	private List<String> skills;

	public Employee() {
		super();
	}

	public Employee(int id, String name, Address address, List<String> skills) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.skills = skills;
		System.out.println("constructor called");
	}
	public Employee(int id, String name,  List<String> skills) {
		super();
		this.id = id;
		this.name = name;
		this.skills = skills;
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

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<String> getSkills() {
		return skills;
	}

	public void setSkills(List<String> skills) {
		this.skills = skills;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", address=" + address + ", skills=" + skills + "]";
	}
	
	public void myInit() {
		System.out.println("my init called");
	}
	public void myDestroy() {
		System.out.println("my destroy method called");
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println("this is bean initialization ...");
	}

	public void destroy() throws Exception {
		System.out.println("my destroy method called (using disposable bean");
	}
	 
	
	
 


}
