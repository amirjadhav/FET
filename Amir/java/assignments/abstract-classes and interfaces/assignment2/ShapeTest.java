package assignment2;

public class ShapeTest {
    public static void main(String[] args) {
        Shape shape[] = new Shape[3];

        shape[0] = new Rectangle(23, 45);
        double ReactangeArea = shape[0].calculateArea();
        System.out.println("Area of Rectangle is: " + ReactangeArea);

        shape[1] = new Traingle(23, 12);
        double TraingleArea = shape[1].calculateArea();
        System.out.println("Area of Traingle is: " + TraingleArea);

        shape[2] = new Circle(45);
        double CircleArea = shape[2].calculateArea();
        System.out.println("Area of Circle is: " + CircleArea);
    }

}
