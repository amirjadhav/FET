package com.cybage;

import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Employee {
	private int id;
    @Size(min = 3, max = 20)
	private String firstName;
    @Size(min = 3, max = 20)
    private String lastName;
    @Pattern(regexp=".+@.+\\.[a-z]+")
    private String email;
	public Employee() {
		super();
 	}
	public Employee(int id, String firstName, String lastName, String email) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + "]";
	}
	
}
