package lab_9_1;

public class IllegalTriangleException extends Exception {
    private double side1, side2, side3;

    public IllegalTriangleException(double side1, double side2, double side3, String message) {
        super(message);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    // --- Getters ---
    public double getSide1() {
        return this.side1;
    }

    public double getSide2() {
        return this.side2;
    }

    public double getSide3() {
        return this.side3;
    }
}
