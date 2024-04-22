package lab_10;

import java.util.Scanner;
import java.util.InputMismatchException;

import lab_10.Q3.Q3Driver;
import lab_10.Q5.Q5Driver;

public class Lab_10 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        while(true){ // Run app (with menu)
            System.out.println("--- Demos ---\n [1] \n [2] \n "+ 
                "[3] URL Read Test \n [4] \n [5] Summable Test \n [6] Exit");
            try { 
                switch (userInput.nextInt()) { // Get choice of demo from user
                    case 1: // Q1
                        
                        break;
                    case 2: // Q2
                        
                        break;
                    case 3: // Q3
                        Q3Driver.urlTest();
                        break;
                    case 4: // Q4

                        break;
                    case 5: // Q5
                        Q5Driver.summableTest();
                        break;
                    case 6: // Exit app
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
