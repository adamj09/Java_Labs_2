package lab_11;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab_11 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        while(true){ // Run app (with menu)
            System.out.println("--- Demos ---\n [1] Stack Test \n [2] Linked List Test \n " + 
                "[3] Priority Queue Test \n [5] Exit");
            try { 
                switch (userInput.nextInt()) { // Get choice of demo from user
                    case 1: // Q1
                        genericStackTest();
                        break;
                    case 2: // Q1
                        
                        break;
                    case 3: // Q2
 
                        break;
                    case 4: // Q3
                        
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
                userInput.nextLine(); // Clear input
            }
        }
    }

    public static void genericStackTest() {
        SportsCar[] sportsCars = { // Objects to be added to stack
            new SportsCar("LaFerrari", "Ferrari", "Red"),
            new SportsCar("Hurican", "Lamborghini", "Black"),
            new SportsCar("911", "Porsche", "Blue")
        };

        // Create Stack
        GenericStack<SportsCar> sportsCarStack = new GenericStack<>();
        for(SportsCar car : sportsCars) {
            sportsCarStack.push(car);
        }

        // Test Search
        SportsCar goofyCar = new SportsCar("Goofymobile", "Goofy", "blue");
        System.out.println("Position of " + sportsCars[1].toString() + ": " + sportsCarStack.search(sportsCars[1]));
        System.out.println("Position of " + goofyCar.toString() + ": " + sportsCarStack.search(goofyCar) + " (should be -1)");

        // Test Peek
        System.out.println("SportsCar at top of stack: " + sportsCarStack.peek());

        // Test Pop
        System.out.println("\n--- All SportsCars ---");
        while(!sportsCarStack.isEmpty()) {
            System.out.println(sportsCarStack.pop().toString());
        }
    }
}
