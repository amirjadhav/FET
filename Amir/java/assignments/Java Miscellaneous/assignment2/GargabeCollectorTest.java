package assignment2;

public class GargabeCollectorTest {
    public static void main(String[] args) {
        Employee employee1 = new Employee(101, "Amir", "Solapur");
        Employee employee2;
        {
            employee2 = new Employee(102, "Vijay", "Solapur");
            System.out.println(employee2);
            employee2 = null;
            System.gc();

        }
        System.out.println(employee1);
        System.gc();
        // System.out.println(employee2);
        if (employee2 == null) {
            System.out.println("Explicit gc is not called..");
        }

    }

    @Override
    protected void finalize() throws Throwable {
        System.out.println("Garbage collector called");
        System.out.println("Object garbage collected : " + this);
    }
}
