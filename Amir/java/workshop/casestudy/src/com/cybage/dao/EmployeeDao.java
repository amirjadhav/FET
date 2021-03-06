package com.cybage.dao;

import java.io.IOException;

import com.cybage.model.Employee;

public interface EmployeeDao {
	public void add(Employee emp,String type) throws Exception;
	public void delete(int id) throws Exception;
	public void update(int id, Employee emp);
	public void display() throws Exception;
	public void displayWithId(int id) throws Exception;
	void update();
}
