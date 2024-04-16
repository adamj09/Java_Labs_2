package lab_9_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Q3Driver {
    public static void circleTest() {
        Scanner userInput = new Scanner(System.in);
        Circle[] circles = new Circle[2];

        for(int i = 0; i < circles.length;) {
            System.out.print("Enter the radius for circle " + (i + 1) + ": ");
            try {
                circles[i] = new Circle(userInput.nextDouble(), "White", false);
                i++;
            }
            catch(IllegalArgumentException ex) {
                System.out.println(ex);
            }
            catch(InputMismatchException ex) {
                System.out.println(ex);
            }
        }

        for(int i = 0; i < circles.length; i++) {
            System.out.println("--- Circle " + i + " Info ---\n" + circles[i].toString());
        }

        switch (circles[0].compareTo(circles[1])) {
            case 1:
                System.out.println("Circle 0 is larger than circle 1!");
                break;
            case -1:
                System.out.println("Circle 1 is larger than circle 0!");
                break;
            default:
                System.out.println("Circle 0 is the same as circle 1!");
                break;
        }
    }
}
