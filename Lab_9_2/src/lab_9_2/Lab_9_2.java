package lab_9_2;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Lab_9_2 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        while(true){ // Run app (with menu)
            System.out.println("--- Demos ---\n [1] Colorable Test\n [2] Octogon Test \n "+ 
                "[3] Circle Test \n [4] Exit");
            try { 
                switch (userInput.nextInt()) { // Get choice of demo from user
                    case 1: // Q1
                        Q1Driver.colorableTest();
                        break;
                    case 2: // Q2
                        Q2Driver.octagonTest();
                        break;
                    case 3: // Q3
                        Q3Driver.circleTest();
                        break;
                    case 4: // Exit app
                        userInput.close();
                        System.exit(0);
                    default: // Invalid number
                        throw new InputMismatchException();
                }
                System.out.println(); // Add spacing between menu and demo
            }
            catch(InputMismatchException ex) { // Catch any invalid input
                System.err.println("Invalid choice. \nPlease enter an integer between 1 and 5.");
                userInput.nextLine(); // Clear input
            }
        }
    }
}
