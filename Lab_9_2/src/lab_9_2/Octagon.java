package lab_9_2;
import java.lang.Cloneable;
public class Octagon extends GeometricObject implements Cloneable, Comparable<Octagon> {
    private double side;

    Octagon() {
        this.side = 0;
    }

    Octagon(double side) throws IllegalArgumentException {
        if(side < 0) {
            throw new IllegalArgumentException("Invalid");
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
        return (2 + 4/side*side);
    }

    public double getPerimeter() {
        return 8*side;
    }

    @Override
    public int compareTo(Octagon o) {
        return 0;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        }
        catch(CloneNotSupportedException e) {
             new Exception("Clone not supported");
        }
        return null;
    }
}
