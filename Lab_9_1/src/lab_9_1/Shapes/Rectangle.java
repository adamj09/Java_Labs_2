package lab_9_1.Shapes;

public class Rectangle extends GeometricObject {
    private double side1, side2;

    public Rectangle(double side1, double side2, String colour, boolean filled) {
        super(colour, filled); // Set generic info
        setSide1(side1);
        setSide2(side2);
    }

    // --- Getters ---
    public double getArea() {
        return side1 * side2;
    }

    public double getPerimeter() {
        return (side1 * 2) + (side2 * 2);
    }

    public double getSide1() {
        return side1;
    }

    public double getSide2() {
        return side2;
    }

    // --- Setters ---
    public void setSide1(double side1) throws IllegalArgumentException {
        if(side1 <= 0) { // If side length is negative or 0, invalid rectangle
            throw new IllegalArgumentException("side1 of Rectangle must be greater than 0!");
        }
        this.side1 = side1;
    }

    public void setSide2(double side2) throws IllegalArgumentException {
        if(side2 <= 0) { // If side length is negative or 0, invalid rectangle
            throw new IllegalArgumentException("side2 of Rectangle must be greater than 0!");
        }
        this.side2 = side2;
    }

    public String toString() {
        return "rectangle of {dimensions = " + side1 + " by " + side2 + ", area = " + getArea() + ", perimeter = " + getPerimeter() + "}";
    }
}
