package com.cybage;

import com.cybage.model.Employee;
import com.cybage.model.RegularEmployee;
import com.cybage.model.RetiredEmployee;

public class EmployeeServieImpl implements EmployeeService {

	private Employee emp[] = new Employee[10];
	private static int count = 0;
	/// instance initializer block , it executes before constructor
//    {
//        emp[count] = new RegularEmployee("regular", "pune101", 123);
//        count ++;
//        emp[count] = new RetiredEmployee("retired", "pune102", 12345);
//        count ++;
//    }

	@Override
	public void add(String name, String address, int comp, String type) throws EmployeeException {

		if (name == null) {
			throw new EmployeeException("Cannot add employee as name is blank");
		}
		if (address == null) {
			throw new EmployeeException("Cannot add employee as address is blank");
		}
		if (comp <= 0) {
			throw new EmployeeException("Cannot add employee as comp is less than 0");
		}
		if (type.equals("REG")) {
			emp[count] = new RegularEmployee(name, address, comp);
			count++;
		} else if (type.equals("RET")) {
			emp[count] = new RetiredEmployee(name, address, comp);
			count++;
		} else {
			System.out.println("not able to add employee as type is invalid");
		}
	}

	@Override
	public void displayAll() {
		for (Employee e : emp) {
			if (e == null)
				break;
			System.out.println(e);
		}
	}

	@Override
	public void display() {
		for (Employee e : emp) {
			if (e == null)
				break;
			System.out.println("Id: " + e.getId() + " comp: " + e.getCompansation());
		}
	}

	@Override
	public void delete(int id) {
		for (int i = 0; i < emp.length; i++) {
			if (emp[i] != null) {
				if ((emp[i].getId() == id)) {
					System.out.println("Found element to delete");
					emp[i] = null;
				}
			}
		}

	}

//    @Override
//    public void update(int id, Employee emp) {
//
// 
//
//    }
}