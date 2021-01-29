package com.cybage.dao;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.cybage.model.Employee;

public interface EmployeeDao {
	public void add(Employee emp) throws IOException;
	public void delete();
	public void update();
	public void display() throws IOException;
}
