package assignment3;

public class Employee {
    int id;
    String name;
    int salary;

    public Employee() {
        id = 0;
        name = "";
        salary = 0;
    }

    public void addData(int id, String name, int salary) {
        System.out.println("Add data method is called");
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void display() {
        System.out.println("Display data method is called..\n Employee [id=" + id + ", name=" + name + ", salary=" + salary + "]");
    }

}
