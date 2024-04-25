package lab_10.Q5;

public class Circle extends GeometricObject implements Summable {
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

    // Checks this circle's radius against another's, and return true if they're the same.
    public boolean equals(Circle circle) {
        if(circle.getRadius() == radius) {
            return true;
        }
        return false;
    }

    public double sumArea() {
        return this.getArea(); // This doesn't actually return the sum, which is intended despite method name
    }
}
