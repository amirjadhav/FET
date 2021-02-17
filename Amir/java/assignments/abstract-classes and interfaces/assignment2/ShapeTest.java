package assignment2;

public class ShapeTest {
    public static void main(String[] args) {
        Shape[] shape = new Shape[3];

        shape[0] = new Rectangle(23, 45);
        double reactangeArea = shape[0].calculateArea();
        System.out.println("Area of Rectangle is: " + reactangeArea);

        shape[1] = new Traingle(23, 12);
        double traingleArea = shape[1].calculateArea();
        System.out.println("Area of Traingle is: " + traingleArea);

        shape[2] = new Circle(45);
        double circleArea = shape[2].calculateArea();
        System.out.println("Area of Circle is: " + circleArea);
    }

}
