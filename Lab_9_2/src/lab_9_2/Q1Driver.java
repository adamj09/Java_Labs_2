package lab_9_2;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Q1Driver {
    public static void colorableTest() {
        Scanner userInput = new Scanner(System.in);
        GeometricObject[] shapes = new GeometricObject[5];

        for(int i = 0; i < shapes.length; i++) {
            System.out.printf("Enter the side length of square " + (i + 1) + ": ");
            try {
                shapes[i] = new Square(userInput.nextDouble());
            }
            catch(IllegalArgumentException ex) {
                System.out.println(ex);
            }
            catch(InputMismatchException ex) {
                System.out.println(ex);
            }
        }

        for(int i = 0; i < shapes.length; i++) {
            System.out.println("Shape " + (i + 1) + "'s area: " + shapes[i].getArea());
            if(shapes[i] instanceof Colorable) {
                ((Colorable)shapes[i]).howToColor();
            }
        }
    }
}
