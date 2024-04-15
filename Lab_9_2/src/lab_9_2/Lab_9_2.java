package lab_9_2;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Lab_9_2 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        while(true){ // Run app (with menu)
            System.out.println("--- Demos ---\n [1] Colorable Test\n [2] Octogon Test \n "+ 
                "[3] Circle Test \n [4] Exit");
            // Get choice of demo from user
            try {
                switch (userInput.nextInt()) {
                    case 1:
                        Q1Driver.colorableTest();
                        System.out.println();
                        break;
                    case 2:
                        
                        System.out.println();
                        break;
                    case 3:
                        Q3Driver.circleTest();
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
}
