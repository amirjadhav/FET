package com.cybage;

import java.util.Scanner;

import com.cybage.service.EmployeeService;
import com.cybage.service.EmployeeServieImpl;

public class UI {
	public static void main(String[] args) {
		String name, address, type;
		int compansation;

		System.out.println("Employee Management System...");
		Scanner sc = new Scanner(System.in);

		EmployeeService empService = new EmployeeServieImpl();

		try {
			int choice, id;
			do {
				System.out.println("*********************** MENU ***********************");
				System.out.println(
						"1.Insert\n2.Display\n3.Display with ID\n4.Delete\n5.Update\n6.Exit\nEnter your Choice");
				choice = sc.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter name");
					name = sc.next();
					System.out.println("Enter Address");
					address = sc.next();
					System.out.println("Enter compansation");
					compansation = sc.nextInt();
					System.out.println("Enter Type ['REG' or 'RET']");
					type = sc.next();

					// add one regular employee
					empService.add(name, address, compansation, type);
					break;

				case 2:
					empService.displayAll();
					break;

				case 3:
					System.out.println("Enter ID to display Record");
					id = sc.nextInt();
					empService.displayWithId(id);
					break;

				case 4:
					System.out.println("Enter ID to delete Record");
					id = sc.nextInt();
					empService.delete(id);
					break;

				case 5:
					System.out.println("Enter ID to update data:");
					id = sc.nextInt();
					System.out.println("Enter name");
					name = sc.next();
					System.out.println("Enter Address");
					address = sc.next();
					System.out.println("Enter compansation");
					compansation = sc.nextInt();
					System.out.println("Enter Type ['REG' or 'RET']");
					type = sc.next();

					// add one regular employee
					empService.update(id, name, address, compansation, type);
					break;

				case 6:
					System.out.println("Exited..");
					System.exit(0);
					break;

				default:
					System.err.println("Please enter correct choice");
					break;
				}
			} while (choice != 6);
		} catch (Exception ee) {
			System.err.println(ee.getLocalizedMessage());
		}
		sc.close();

	}
}