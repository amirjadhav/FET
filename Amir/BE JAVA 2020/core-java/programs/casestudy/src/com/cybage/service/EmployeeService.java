package com.cybage.service;

import java.io.IOException;
import com.cybage.exception.EmployeeException;

public interface EmployeeService {
	public abstract void add(String name, String address, int comp, String type) throws EmployeeException, Exception;
	public abstract void displayAll() throws EmployeeException, IOException, Exception;
	public abstract void displayComp();
	public abstract void displayWithId(int i) throws Exception;
	public abstract void delete(int id)throws Exception;
	public abstract void update(int id, String name, String address, int compansation, String type) throws EmployeeException, Exception;
}
