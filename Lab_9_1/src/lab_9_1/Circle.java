package lab_9_1;

public class Circle {
    private double radius;

    Circle(double radius) throws IllegalArgumentException {
        if(radius <= 0) {
            throw new IllegalArgumentException("Radius must be greater than 0!");
        }
        this.radius = radius;
    }

    public double getArea() {
        return Math.PI * Math.pow(radius, 2);
    }
}
