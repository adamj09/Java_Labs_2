package lab_9_1;

import java.util.InputMismatchException;
import java.util.Scanner;

import lab_9_1.Comparison.Compare;
import lab_9_1.Shapes.Triangle;

public class Lab_9_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(true){ // Run app (with menu)
            System.out.println("--- Demos ---\n [1] Triangle Test\n [2] Compare Shapes\n "+ 
                "[3] \n [4] ");
            // Get choice of demo from user
            try {
                switch (input.nextInt()) {
                    case 1:
                        triangleTest();
                        System.out.println();
                        break;
                    case 2:
                        Compare.compareShapes();
                        System.out.println();
                        break;
                    case 3:

                        System.out.println();
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. \nPlease enter an integer between 1 and 5.");
                        break;
                }
            }
            catch(InputMismatchException ex) {
                System.out.println("Invalid choice. \nPlease enter an integer between 1 and 5.");
                input.nextLine();
                continue;
            }
        }
    }
    
    private static void triangleTest() {
        Scanner scanner = new Scanner(System.in);

        // Get user to create triangle
        Triangle triangle;
        while(true) {
            System.out.println("Enter the three sides of the triangle, its colour, and fill state respectively: ");
            try {
                triangle = new Triangle(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.next(), scanner.nextBoolean());
                break; // Good triangle, stop asking user
            }
            catch(InputMismatchException ex) { // Values not input properly
                System.out.println("Invalid input.\n Make sure the values are entered in the following order: side1 side2 side3 colour fillState");
            }
            catch(IllegalTriangleException ex) { // Invalid triangle
                System.out.println(ex);
            }
        }

        // Print triangle's properties
        System.out.printf("--- Triangle Properties ---\n - Side lengths: %.2f, %.2f, %.2f\n - Area: %.2f\n - Perimeter: %.2f\n",
            triangle.getSide1(), triangle.getSide2(), triangle.getSide3(), triangle.getArea(), triangle.getPerimeter());
    }
}
