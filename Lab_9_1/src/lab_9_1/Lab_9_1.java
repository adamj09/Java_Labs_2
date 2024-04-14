package lab_9_1;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

import lab_9_1.Comparison.CompareShapes;
import lab_9_1.Shapes.Triangle;

public class Lab_9_1 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        while(true){ // Run app (with menu)
            System.out.println("--- Demos ---\n [1] Triangle Test\n [2] Average Test \n "+ 
                "[3] Compare Shapes\n [4] Exit");
            // Get choice of demo from user
            try {
                switch (userInput.nextInt()) {
                    case 1:
                        triangleTest();
                        System.out.println();
                        break;
                    case 2:
                        averageTest();
                        System.out.println();
                        break;
                    case 3:
                        CompareShapes.compareShapes();
                        System.out.println();
                        break;
                    case 4:
                        System.exit(0);
                        break;
                    default:
                        System.err.println("Invalid choice. \nPlease enter an integer between 1 and 5.");
                        break;
                }
            }
            catch(InputMismatchException ex) {
                System.err.println("Invalid choice. \nPlease enter an integer between 1 and 5.");
                userInput.nextLine();
                continue;
            }
        }
    }
    
    private static void triangleTest() {
        Scanner userInput = new Scanner(System.in);

        // Get user to create triangle
        Triangle triangle;
        while(true) {
            System.out.println("Enter the three sides of the triangle, its colour, and fill state respectively: ");
            try {
                triangle = new Triangle(userInput.nextDouble(), userInput.nextDouble(), userInput.nextDouble(), userInput.next(), userInput.nextBoolean());
                break; // Good triangle, stop asking user
            }
            catch(InputMismatchException ex) { // Values not input properly
                System.err.println("Invalid input.\n Make sure the values are entered in the following order: side1 side2 side3 colour fillState");
            }
            catch(IllegalTriangleException ex) { // Invalid triangle
                System.err.println(ex);
            }
        }

        // Print triangle's properties
        System.out.printf("--- Triangle Properties ---\n - Side lengths: %.2f, %.2f, %.2f\n - Area: %.2f\n - Perimeter: %.2f\n",
            triangle.getSide1(), triangle.getSide2(), triangle.getSide3(), triangle.getArea(), triangle.getPerimeter());
    }

    private static void averageTest() {
        Scanner userInput = new Scanner(System.in);

        // Create list of values to average
        ArrayList<Integer> values = new ArrayList<>();
        System.out.println("Enter some integers to average, input ends at the first non-integer value entered.");
        while(true) {
            try {
                values.add(userInput.nextInt());
            }
            catch(InputMismatchException ex) { // End input at non-integer value
                break;
            }
        }
        try {
            average(values);
        }
        catch(IllegalArgumentException ex) {
            System.err.println(ex);
        }
    }

    private static void average(ArrayList<Integer> list) throws IllegalArgumentException {
        if(list.isEmpty() || list == null) {
            throw new IllegalArgumentException("Cannot find average for empty list!");
        }

        double sum = 0;
        for(Integer num : list) {
            sum += num;
        }
        System.out.printf("Average of the list %s is %.2f", list.toString(), sum / list.size());
    }
}
