package assignment2;

public class Rectangle extends Shape {
    double dLength, dWidth;

    @Override
    protected double calculateArea() {
        return dLength * dWidth;
    }

    public Rectangle(double dLength, double dWidth) {
        this.dLength = dLength;
        this.dWidth = dWidth;
    }

    public double getdLength() {
        return dLength;
    }

    public void setdLength(double dLength) {
        this.dLength = dLength;
    }

    public double getdWidth() {
        return dWidth;
    }

    public void setdWidth(double dWidth) {
        this.dWidth = dWidth;
    }

    @Override
    public String toString() {
        return "Rectangle [dLength=" + dLength + ", dWidth=" + dWidth + "]";
    }

    public Rectangle() {
        dLength = dWidth = 0;
    }
}
