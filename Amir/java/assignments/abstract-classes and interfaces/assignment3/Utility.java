package assignment3;

public class Utility {
    public void printAll(Printable p[]) {
        for (int i = 0; i < p.length; i++) {
            p[i].print();
        }
    }
}
