package assignment3;

public class PrintanleTest {
    public static void main(String[] args) {
        Printable p[] = new Printable[2];
        p[0] = new Animal();
        p[1] = new Shapes();
        Utility utility = new Utility();
        utility.printAll(p);
    }
}
