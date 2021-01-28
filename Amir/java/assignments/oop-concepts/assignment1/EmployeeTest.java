package assignment1;

public class EmployeeTest {
    public static void main(String[] args) {
        System.out.println("Employee Test");
        SalesManager salesManager = new SalesManager("Amir",101,12000,500,3400);
        int total_Compansation = salesManager.calculateSalary();
        System.out.println(total_Compansation);
    }
}
