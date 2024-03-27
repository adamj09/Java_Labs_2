package lab_7_1;

public class Triangle extends GeometricObject{
    private double side1 = 1, side2 = 1, side3 = 1;

    public Triangle() {} // no-arg

    public Triangle(double side1, double side2, double side3, String color, boolean filled) throws IllegalTriangleException { // all-arg + args for parent
        super(color, filled);

        if(side1 + side2 <= side3 || side1 + side3 <= side2 || side2 + side3 <= side1) {
            throw new IllegalTriangleException(side1, side2, side3, 
                "Invalid triangle. The sum of any two sides must be greater than the third side.");
        }

        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // --- Getters ---
    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    public double getSide3() {
        return side3;
    }

    // --- Setters ---
    public void setSide1(double side1) {
        this.side1 = side1;
    }

    public void setSide2(double side2) {
        this.side2 = side2;
    }

    public void setSide3(double side3) {
        this.side3 = side3;
    }

    public double getArea() {
        // Get area using formula for area of a triangle using 3 sides
        double semiPerimeter = getPerimeter() / 2;
        return Math.sqrt(semiPerimeter * (semiPerimeter - side1) * (semiPerimeter - side2) * (semiPerimeter - side3));
    }

    public double getPerimeter() {
        return side1 + side2 + side3; // sum of sides
    }

    public String toString() {
        return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3; // string containing attributes of triangle
    }
}
