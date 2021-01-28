/*
Write a program to create a class named EmployeeDetails and display a menu similar to the
following menu:
--------------Menu--------------
1. Enter Data
2. Display Data
3. Exit
Choose the option
Thereafter, invoke the respective method according to the given menu input. The methods
will contain appropriate message, such as the displayData()
method will contain the message, displayData method is invoked
*/

package assignment3;

import java.util.Scanner;

public class EmployeeDetails {

    public static void main(String[] args) {
        int ch = 0;
        Employee employee = new Employee();
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("************** Menu **************");
            System.out.println("1. Enter Data\n2. Display Data\3. Exit\n4. Enter your choice");
            ch = sc.nextInt();

            switch (ch) {
                case 1:
                    employee.addData(101, "Amir", 12000);
                    break;
                case 2:
                    employee.display();
                    break;
                case 3:

                    break;
                default:
                    break;
            }

        } while (ch != 3);
        sc.close();
    }
}
