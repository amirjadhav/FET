package com.cybage;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Employee {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;

	@OneToOne(mappedBy = "employee", fetch = FetchType.LAZY,
			cascade = CascadeType.ALL)	
	private Project project;
	public Employee() {
		super();
	}
	public Employee(int id, String name, Project project) {
		super();
		this.id = id;
		this.name = name;
		this.project = project;
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
	public Project getProject() {
		return project;
	}
	public void setProject(Project project) {
		this.project = project;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", project=" + project + "]";
	}
}