class Employee {
    int id;
    String name;
    int sal;

    public Employee() {
    }

    public Employee(int id, String name, int sal) {
        this.id = id;
        this.name = name;
        this.sal = sal;
    }

    public int getId() {
        return this.id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getSal() {
        return this.sal;
    }

    public void setSal(int sal) {
        this.sal = sal;
    }

    @Override
    public String toString() {
        return "{" + " id='" + getId() + "'" + ", name='" + getName() + "'" + ", sal='" + getSal() + "'" + "}";
    }

}

public class SetterGetterTest {
    public static void main(String[] args) {
        Employee employee = new Employee();
        employee.setName("Amir");
        employee.setId(101);
        employee.setSal(230000);
        System.out.println(employee.getName());
        System.out.println(employee.getId());
        System.out.println(employee.getSal());
    }
}
