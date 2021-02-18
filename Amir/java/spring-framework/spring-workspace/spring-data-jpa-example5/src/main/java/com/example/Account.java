package com.example;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int accountId;
	private String accountName;
	
	@OneToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "empid", nullable = false)
	private Employee employee;

	public Account() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Account(int accountId, String accountName, Employee employee) {
		super();
		this.accountId = accountId;
		this.accountName = accountName;
		this.employee = employee;
	}

	public Account(String accountName, Employee employee) {
		super();
		this.accountName = accountName;
		this.employee = employee;
	}

	public int getAccountId() {
		return accountId;
	}

	public void setAccountId(int accountId) {
		this.accountId = accountId;
	}

	public String getAccountName() {
		return accountName;
	}

	public void setAccountName(String accountName) {
		this.accountName = accountName;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Account [accountId=" + accountId + ", accountName=" + accountName + ", employee=" + employee + "]";
	}
	
	
	
	
}
