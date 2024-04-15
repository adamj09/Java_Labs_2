package src.lab_9_2;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Q1Driver {
    public static void colorableTest() {
        Scanner userInput = new Scanner(System.in);
        GeometricObject[] shapes = new GeometricObject[5];

        for(int i = 0; i < shapes.length;) {
            System.out.printf("Enter the side length of square " + (i + 1) + ": ");
            try {
                shapes[i] = new Square(userInput.nextDouble());
                i++;
            }
            catch(IllegalArgumentException ex) {
                System.out.println(ex);
            }
            catch(InputMismatchException ex) {
                System.out.println(ex);
            }
        }

        for(int i = 0; i < shapes.length; i++) {
            if(shapes[i] instanceof Colorable) {
                System.out.print("Shape " + (i + 1) + ": ");
                ((Colorable)shapes[i]).howToColor();
            }
        }

        for(int i = 0; i < shapes.length; i++) {
            System.out.println("--- Shape " + (i + 1) + " Info ---");
            if(shapes[i] instanceof Square) {
                System.out.println(((Square)shapes[i]).toString());
            }
        }
    }
}
