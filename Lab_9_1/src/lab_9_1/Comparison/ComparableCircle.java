package lab_9_1.Comparison;

import lab_9_1.Shapes.Circle;
import lab_9_1.Shapes.GeometricObject;

public class ComparableCircle extends Circle implements Comparable<GeometricObject> {
    protected ComparableCircle(double radius, String colour, boolean filled) {
        super(radius, colour, filled);
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
