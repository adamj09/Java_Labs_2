package lab_11_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class StringTests {
    // Driver for parts A and B of reversing string question
    public static void reverseTest() {
        Scanner userInput = new Scanner(System.in);

        // Get user to choose which implementation to run
        System.out.println("--- Select an Implementation to Run ---\n [1] Recursion Implementation\n [2] Loop Implementation");
        while(true) {
            try {
                switch (userInput.nextInt()) {
                    case 1:
                        System.out.println("Enter a string to be reversed: ");
                        reverseDisplayRecursive(userInput.next()); // Run recursive implementation
                        break;
                    case 2:
                        System.out.println("Enter a string to be reversed: ");
                        reverseDisplayLooped(userInput.next()); // Run loop implementation
                        break;
                    default:
                        throw new InputMismatchException();
                }
                break; // Break from loop to end test
            }
            catch(InputMismatchException ex) { // Catch invalid input
                System.out.println("Invalid choice. Enter 1 or 2.");
                userInput.nextLine();
            }
        }
    }

    // Displays a string in reverse using recursion
    public static void reverseDisplayRecursive(String string) {
        if(string.isEmpty()) // If the string is empty, stop recursion
            return;
        System.out.print(string.charAt(string.length() - 1)); // print last char
        reverseDisplayRecursive(string.substring(0, string.length() - 1)); // feed method same string with last value concatenated
    }

    // Displays a string in reverse using a loop
    public static void reverseDisplayLooped(String string) {
        for(int i = string.length() - 1; i >= 0; i--) { // Go through string backwards and print each char
            System.out.print(string.charAt(i));
        }
    }

    // Driver for parts A and B of counting chars in string question
    public static void countTest() {
        Scanner userInput = new Scanner(System.in);

        // Get user to choose which implementation to run
        System.out.println("--- Select an Implementation to Run ---\n [1] Recursion Implementation\n [2] Loop Implementation");
        while(true) {
            try {
                switch (userInput.nextInt()) {
                    case 1:
                        System.out.println("Enter a string and char to search for within that string: ");
                        System.out.println(countRecursive(userInput.next(), userInput.next().charAt(0))); // Run recursive implementation
                        break;
                    case 2:
                        System.out.println("Enter a string and char to search for within that string: ");
                        System.out.println(countLooped(userInput.next(), userInput.next().charAt(0))); // Run loop implementation
                        break;
                    default:
                        throw new InputMismatchException();
                }
                break; // Break from loop to end test
            }
            catch(InputMismatchException ex) { // Catch invalid input
                System.out.println("Invalid choice. Enter 1 or 2.");
                userInput.nextLine();
            }
        }
    }

    // Return the number of character occurences in a string using recursion
    public static int countRecursive(String string, char character) {
        int count = 0;
        if(!string.isEmpty())
            count = countRecursive(string.substring(1), character) + ((string.charAt(0) == character) ? 1 : 0);
        return count;
    }

    // Return the number of character occurences in a string using a loop
    public static int countLooped(String string, char character) {
        int count = 0;
        for(int i = 0; i < string.length(); i ++) {
            if(string.charAt(i) == character) {
                count++;
            }
        }
        return count;
    }
}
