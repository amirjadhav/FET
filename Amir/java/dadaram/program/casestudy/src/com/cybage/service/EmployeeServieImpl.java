package com.cybage.service;

import java.io.IOException;

import com.cybage.dao.EmployeeDao;
import com.cybage.dao.EmployeeDaoImpl;
import com.cybage.exception.EmployeeException;
import com.cybage.model.Employee;
import com.cybage.model.RegularEmployee;
import com.cybage.model.RetiredEmployee;

public class EmployeeServieImpl implements EmployeeService{

	private Employee emp[] = new Employee[10];
	private static int count = 0;
	
	EmployeeDao empDao = new EmployeeDaoImpl();
	
	private int generateId() {
		return (int) (Math.round(Math.random()*100000));
	}
	

	@Override
	public void add(String name, String address, int comp, String type) throws EmployeeException, IOException{

		if(name == null) {
			throw new EmployeeException("Cannot add employee as name is blank");
		}
		if(address == null){
			throw new EmployeeException("Cannot add employee as address is blank");
		}	
		if(comp <= 0) {
			throw new EmployeeException("Cannot add employee as comp is less than 0");
		}
		
		if(type.equals("REG")) {
			empDao.add(new RegularEmployee(generateId() , name, address, comp));
		}else if(type.equals("RET")){
			empDao.add(new RetiredEmployee( generateId(),  name, address, comp));
		}else {
			System.out.println("not able to add employee as type is invalid");
		}
	}

	@Override
	public void displayAll() throws EmployeeException, IOException{
		empDao.display();
	}

	@Override
	public void displayComp() {
		
		for(Employee e : emp) {
			if(e == null) break;
			System.out.println("Id: " + e.getId() +" comp: " + e.getCompensation());
		}
	}

	@Override
	public void delete(int id) {

	}

	@Override
	public void update(int id, Employee emp) {

	}
}