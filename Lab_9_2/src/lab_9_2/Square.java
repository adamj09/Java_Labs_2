package lab_9_2;

import java.util.Scanner;

public class Square extends GeometricObject implements Colorable {
    private double sideLength;
    
    Square() { // Default square
        this.sideLength = 0;
    }

    Square(double sideLength) throws IllegalArgumentException { // Create new square with specified side length
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

    public void howToColor() { // Set square's colour based on user input
        Scanner userInput = new Scanner(System.in);
        System.out.println("Color all four sides with this color: ");
        this.setColor(userInput.nextLine());
    }

    public String toString() { // Return all square info
        return "Square with:\n sidelength: " + sideLength + "\n area: " + getArea() + 
            "\n perimeter: " + getPerimeter() + "\n color: " + this.getColor() + "\n filled: " + this.isFilled();
    }

}
