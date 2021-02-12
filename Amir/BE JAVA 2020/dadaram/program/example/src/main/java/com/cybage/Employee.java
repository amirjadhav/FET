package com.cybage;

import org.springframework.beans.factory.DisposableBean;

//pojo
public class Employee {
	private int id;
	private String name;
	 
	public Employee() {
		super();
		System.out.println("empty object created...");
	}

	public Employee(int id, String name ) {
		super();
		this.id = id;
		this.name = name;
 	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		System.out.println("id set");
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		System.out.println("name set");
		this.name = name;
	}

	 
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name +  "]";
	}

	public void myMethod() {
		System.out.println("emp bean is ready to use...");
	}
	public void myDestroyMethod() {
		System.out.println("employee bean will be removed from ioc container");
	}
//	public void destroy() throws Exception {
//		System.out.println("employee bean will be removed from ioc container");
//	}
}
