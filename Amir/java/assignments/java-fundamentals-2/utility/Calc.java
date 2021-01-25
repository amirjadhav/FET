package utility;

public class Calc {
    double number;

    public Calc() {

    }

    public Calc(int number) {
        this.number = number;
    }

    public double findRoot() {
        return Math.sqrt(number);
    }
}
