package com.example;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
public class Employee {
	
	@Id				 
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int empid;	
	private String name;

	@OneToMany(targetEntity = Account.class, cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinColumn(name = "ea_fk", referencedColumnName = "empid")
	private List<Account> account;
	
	public Employee() {
		super();
	}

	public Employee(int empid, String name, List<Account> account) {
		super();
		this.empid = empid;
		this.name = name;
		this.account = account;
	}

	public Employee(String name, List<Account> account) {
		super();
		this.name = name;
		this.account = account;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Account> getAccount() {
		return account;
	}

	public void setAccount(List<Account> account) {
		this.account = account;
	}

	@Override
	public String toString() {
		return "Employee [empid=" + empid + ", name=" + name + ", account=" + account + "]";
	}	 
}
