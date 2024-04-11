package lab_9_1;

public class ComparableCircle extends Circle implements Comparable {
    ComparableCircle(double radius) {
        super(radius);
    }
    
    public int compareTo(Object object) {
        if(object instanceof GeometricObject) {
            
        }
        throw new IllegalArgumentException();
    }
}
