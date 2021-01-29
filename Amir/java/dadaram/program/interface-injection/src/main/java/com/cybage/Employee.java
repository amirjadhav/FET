package com.cybage;

public class Employee{
	private int empId;
	private String name;
	private Account account;
	public Employee() {		
		super();
		System.out.println("empl created");
	}
	public Employee(int empId, String name, Account account) {
		super();
		this.empId = empId;
		this.name = name;
		this.account = account;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Account getAccount() {
		return account;
	}
	public void setAccount(Account account) {
		this.account = account;
	}
	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", name=" + name + ", account=" + account + "]";
	}	 
}
