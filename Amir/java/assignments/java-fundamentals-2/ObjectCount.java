// Create an array of Employees & display nos. of Employee objects created.

class Employees {
    static int count = 0;
    {
        count++;
    }

    Employees() {
        System.out.println("Employee Object created" + count);
    }
}

public class ObjectCount {
    public static void main(String[] args) {
        Employees[] oE = new Employees[10];
        for (int i = 0; i < 10; i++) {
            oE[i] = new Employees();
        }
        System.out.println(Employees.count + " object created");
    }
}
