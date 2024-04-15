package src.lab_9_2;

public class Circle extends GeometricObject implements Comparable<GeometricObject> {
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

    public int compareTo(GeometricObject other) {
        double thisArea = this.getArea(), otherArea = other.getArea();
        if(thisArea < otherArea) { 
            return -1; // If this object's area is lesser, return -1
        }
        else if (thisArea > otherArea) {
            return 1; // If this object's area is greater, return 1
        }
        return 0; // If the areas are the same, return 0
    }

    public boolean equals(Circle circle) {
        if(circle.getRadius() == radius) {
            return true;
        }
        return false;
    }
}
