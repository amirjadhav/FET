package com.cybage.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.cybage.model.Employee;

public class EmployeeDaoImpl implements EmployeeDao {
	
	FileWriter writer = null;
	FileReader reader = null;
	
	@Override
	public void add(Employee emp) throws IOException{	
		writer = new FileWriter("db.txt", true);
		writer.write(emp.toString());
		writer.close();
	}

	@Override			//you are trying modify definition of this method 
						//useful to developer
	public void delete() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void display() throws IOException {
		reader = new FileReader("db.txt");
		int data;
		while((data = reader.read()) != -1) {
			System.out.print((char)data);
		}
		reader.close();
	}

}
