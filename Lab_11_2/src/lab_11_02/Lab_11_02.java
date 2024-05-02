package lab_11_02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab_11_02 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        while(true){ // Run app (with menu)
            System.out.println("--- Demos ---\n [1] Sequence Test\n [2] Display String Reversed\n " + 
                "[3] \n [4] \n [5] Exit");
            try { 
                switch (userInput.nextInt()) { // Get choice of demo from user
                    case 1: // Q1
                        SequenceTest.sequenceTest();
                        break;
                    case 2: // Q2
                        System.out.println("Enter a string to be reversed: ");
                        ReverseString.reverseDisplay(userInput.next());
                        break;
                    case 3: // Q3
                       
                        break;
                    case 4: // Q4
                        
                        break;
                    case 5: // Exit app
                        userInput.close();
                        System.exit(0);
                    default: // Invalid number
                        throw new InputMismatchException();
                }
                System.out.println(); // Add spacing between menu and demo
            }
            catch(InputMismatchException ex) { // Catch any invalid input
                System.err.println("Invalid choice. \nPlease enter an integer between 1 and 5.");
                userInput.nextLine(); // Discard input on current line
            }
        }
    }
}
