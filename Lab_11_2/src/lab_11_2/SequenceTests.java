package lab_11_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SequenceTests {
    // Driver for both parts 
    public static void sequenceTest() {
        Scanner userInput = new Scanner(System.in);

        // Get user to choose which implementation to run
        System.out.println("--- Select an Implementation to Run ---\n [1] Recursion Implementation\n [2] Loop Implementation");
        while(true) {
            try {
                switch (userInput.nextInt()) {
                    case 1:
                        recursiveTest(); // Run recursive implementation
                        break;
                    case 2:
                        loopTest(); // Run loop implementation
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

    // User input for recursive version
    public static void recursiveTest() {
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("--- Select an Option to Run ---\n [1] Display Entire Sequence\n [2] Display One Value");
        while(true) {
            int n = 0;
            try {
                switch (userInput.nextInt()) {
                    case 1: // Print entire sequence up to n-th value to terminal
                        System.out.print("Enter the length of the sequence: ");
                        n = userInput.nextInt();
                        System.out.println("Sequence up until n = " + n);
                        for(int i = 0; i < n; i++) {
                            System.out.println(SequenceTests.sequenceRecursive(i) + " ");
                        }
                        break;
                    case 2: // Print particular n-th value
                        System.out.print("Enter the index of the desired value: ");
                        n = userInput.nextInt();
                        System.out.println("Value in sequence at n = " + n + ": " + sequenceRecursive(n));
                        break;
                    default:
                        throw new InputMismatchException();
                }
                break;
            }
            catch(InputMismatchException ex) { // Catch invalid input
                System.out.println("Invalid choice. Enter 1 or 2.");
                userInput.nextLine();
            }
        }
    }

    // User input for loop version
    public static void loopTest() {
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("--- Select an Option to Run ---\n [1] Display Entire Sequence\n [2] Display One Value");
        while(true) {
            int n = 0;
            try {
                switch (userInput.nextInt()) {
                    case 1: // Print entire sequence up to n-th value to terminal
                        System.out.print("Enter the length of the sequence: ");
                        n = userInput.nextInt();
                        System.out.println("Sequence up until n = " + n);
                        for(int i = 0; i < n; i++) {
                            System.out.println(SequenceTests.sequenceLooped(i) + " ");
                        }
                        break;
                    case 2: // Print particular n-th value
                        System.out.print("Enter the index of the desired value: ");
                        n = userInput.nextInt();
                        System.out.println("Value in sequence at n = " + n + ": " + sequenceLooped(n));
                        break;
                    default:
                        throw new InputMismatchException();
                }
                break;
            }
            catch(InputMismatchException ex) { // Catch invalid input
                System.out.println("Invalid choice. Enter 1 or 2.");
                userInput.nextLine();
            }
        }
    }

    // The methods below create a sequence of integers with base 
    // values of 0, 1, and 2 up to the n-th value.
    // Successive numbers are the result of the sum of the previous 3 numbers.
    // To give a clearer idea, these would be the first few values: 0, 1, 2, 3, 6, 11, 20,...

    // This method is the version done with recursion. This is a very slow way
    // of doing this, because triple recursion means an exponential increase in function calls.
    // This slowdown is very noticeable even at small values of n, like 35.
    // Note that this method breaks at large values of n due to overflow.
    public static long sequenceRecursive(int n) { // long is used as values grow exponentially
        if(n < 3)
            return n;
        return sequenceRecursive(n - 3) + sequenceRecursive(n - 2) + sequenceRecursive(n - 1);
    }

    // This method is the version implmented with a loop, which is much faster
    // than the recursive implementation above. Note that this method breaks at large values of n
    // due to overflow.
    public static long sequenceLooped(int n) {
        if(n < 3)
            return n;

        long x = 0, y = 1, z = 2, result = x + y + z;

        for(int i = 3; i < n; i++) {
            x = y;
            y = z;
            z = result;
            result = x + y + z;
        }
        return result; 
    }
}
