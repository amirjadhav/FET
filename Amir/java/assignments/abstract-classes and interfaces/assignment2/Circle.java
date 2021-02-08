package assignment2;

public class Circle extends Shape {
    double dRadius;

    @Override
    protected double calculateArea() {
        return Math.PI * Math.pow(dRadius, 2);
    }

    public Circle() {
    }

    public Circle(final double dRadius) {
        this.dRadius = dRadius;
    }

    public double getdRadius() {
        return dRadius;
    }

    public void setdRadius(final double dRadius) {
        this.dRadius = dRadius;
    }

    @Override
    public String toString() {
        return "Circle [dRadius=" + dRadius + "]";
    }

}
