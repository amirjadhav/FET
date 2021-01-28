/*
Assignment # 1
Create a class hierarchy: Employee
Manager
SalesManager
Override calculateSalary() method. Manager will have allowance field &
SalesManager will have commission field.
*/

package assignment1;

public class Employee {
    String name;
    int id;
    int salary;

    public Employee() {
        name = "";
        id = salary = 0;
    }

    public Employee(String name, int id, int salary) {
        this.name = name;
        this.id = id;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    int calculateSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]";
    }

}