package lab_9_2;

import java.util.Scanner;

public class Square extends GeometricObject implements Colorable {
    private double sideLength;
    
    Square() {
        this.sideLength = 0;
    }

    Square(double sideLength) throws IllegalArgumentException {
        if(sideLength < 0) {
            throw new IllegalArgumentException("Invalid");
        }
        this.sideLength = sideLength;
    }

    public double getSideLength() {
        return sideLength;
    }

    public void setSideLength(double sideLength) {
        this.sideLength = sideLength;
    }

    public double getArea() {
        return sideLength * sideLength;
    }

    public double getPerimeter() {
        return sideLength * 4;
    }

    public void howToColor() {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Colour all four sides with this color: ");
        this.setColor(userInput.nextLine());
    }
}
