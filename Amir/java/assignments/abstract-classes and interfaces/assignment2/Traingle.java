package assignment2;

public class Traingle extends Shape {
    double dBase, dHeight;

    @Override
    protected double calculateArea() {
        return dBase * dHeight * 0.5;
    }

    public Traingle(double dBase, double dHeight) {
        this.dBase = dBase;
        this.dHeight = dHeight;
    }

    public double getdBase() {
        return dBase;
    }

    public void setdBase(double dBase) {
        this.dBase = dBase;
    }

    public double getdHeight() {
        return dHeight;
    }

    public void setdHeight(double dHeight) {
        this.dHeight = dHeight;
    }

    @Override
    public String toString() {
        return "Traingle [dBase=" + dBase + ", dHeight=" + dHeight + "]";
    }

    public Traingle() {
        dBase = dHeight = 0;
    }
}
