package com.cybage;

public interface EmployeeService {
	void display();
	void add(String name, String address, int comp, String type) throws EmployeeException;
	void displayAll();
	void delete(int id);
}
