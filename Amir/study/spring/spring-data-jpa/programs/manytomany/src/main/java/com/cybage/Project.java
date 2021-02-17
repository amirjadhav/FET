package com.cybage;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.aspectj.weaver.tools.Trace;

@Entity
public class Project {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String projectName;
	
	@ManyToMany(mappedBy = "project", fetch = FetchType.LAZY)
	private List<Employee> employee = new ArrayList<Employee>();

	public Project() {
		super();
	}

	public Project(int id, String projectName, List<Employee> employee) {
		super();
		this.id = id;
		this.projectName = projectName;
		this.employee = employee;
	}
	public Project(String projectName) {
		super();
		this.projectName = projectName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public List<Employee> getEmployee() {
		return employee;
	}

	public void setEmployee(List<Employee> employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "Project [id=" + id + ", projectName=" + projectName + ", employee=" + employee + "]";
	}
}