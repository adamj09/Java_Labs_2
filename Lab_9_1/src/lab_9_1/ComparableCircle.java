package lab_9_1;

public class ComparableCircle extends Circle implements Comparable {
    ComparableCircle(double radius) {
        super(radius);
    }
    
    public int compareTo(Object object) {
        if(object instanceof ComparableCircle || object instanceof ComparableRectangle) {
            // return 0;
        }
        throw new IllegalArgumentException();
    }
}
