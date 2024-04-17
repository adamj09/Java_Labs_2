package lab_9_2;
import java.lang.Cloneable;
public class Octagon extends GeometricObject implements Cloneable, Comparable<Octagon> {
    private double side;

    Octagon() { // Default octagon
        this.side = 0;
    }

    Octagon(double side) throws IllegalArgumentException { // Create octagon with specified side length
        if(side < 0) {
            throw new IllegalArgumentException("Invalid side length.");
        }
        this.side = side;
    }

    public double getSide() {
        return side;
    }

    public void setSide(double side) {
        this.side = side;
    }

    public double getArea() {
        return (2 + 4 / Math.sqrt(2)) * side * side;
    }

    public double getPerimeter() {
        return 8 * side;
    }

    @Override
    public int compareTo(Octagon other) {
        if(getSide() < other.getSide()) { 
            return -1; // If this object's area is lesser, return -1
        }
        else if (getSide() > other.getSide()) {
            return 1; // If this object's area is greater, return 1
        }
        return 0; // If the areas are the same, return 0
    }

    @Override
    public Object clone() { // Return a copy of the octagon
        return new Octagon(side);
    }
}
