package lab_9_1.Comparison;

import lab_9_1.Shapes.GeometricObject;
import lab_9_1.Shapes.Rectangle;

public class ComparableRectangle extends Rectangle implements Comparable<GeometricObject>{
    protected ComparableRectangle(double side1, double side2, String colour, boolean filled) {
        super(side1, side2, colour, filled);
    }

    public int compareTo(GeometricObject other) {
        double thisArea = this.getArea(), otherArea = other.getArea();
        if(thisArea < otherArea) {
            return -1; // If this object's area is lesser, return -1
        }
        else if (thisArea > otherArea) {
            return 1; // If this object's area is greater, return 1
        }
        else {
            return 0; // If the areas are the same, return 0
        }
    }
}
