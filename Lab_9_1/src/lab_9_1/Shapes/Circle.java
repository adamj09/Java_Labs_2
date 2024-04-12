package lab_9_1.Shapes;

public class Circle extends GeometricObject {
    private double radius;

    public Circle(double radius, String colour, boolean filled) {
        super(colour, filled); // Fill generic info
        setRadius(radius);
    }

    // --- Getters ---
    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }

    public double getPerimeter() {
        return Math.PI * 2 * radius;
    }

    public double getRadius() {
        return radius;
    }

    // --- Setter ---
    public void setRadius(double radius) throws IllegalArgumentException {
        if(radius <= 0) { // Check for valid radius
            throw new IllegalArgumentException("Radius of Circle must be greater than 0!");
        }
        this.radius = radius; // Set radius if valid
    }

    public String toString() {
        return "circle of {radius = " + radius + ", area = " + getArea() + ", perimeter = " + getPerimeter() + "}";
    }
}
