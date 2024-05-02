package lab_11_02;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SequenceTest {
    public static void sequenceTest() {
        Scanner userInput = new Scanner(System.in);

        System.out.println("--- Select an Implementation to Run ---\n [1] Recursion Implementation\n [2] Loop Implementation");
        while(true) {
            try {
                switch (userInput.nextInt()) {
                    case 1:
                        recursiveTest();
                        break;
                    case 2:
                        loopTest();
                        break;
                    default:
                        throw new InputMismatchException();
                }
                break;
            }
            catch(InputMismatchException ex) {
                System.out.println("Invalid choice. Enter 1 or 2.");
            }
        }
    }

    // --- Part A ---
    public static void recursiveTest() {
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("--- Select an Option to Run ---\n [1] Display Entire Sequence\n [2] Display One Value");
        while(true) {
            try {
                switch (userInput.nextInt()) {
                    case 1:
                        System.out.print("Enter the length of the sequence: ");
                        displaySequenceRecursive(userInput.nextInt());
                        break;
                    case 2:
                        System.out.print("Enter the index of the desired value: ");
                        displayValueRecursive(userInput.nextInt());
                        break;
                    default:
                        throw new InputMismatchException();
                }
                break;
            }
            catch(InputMismatchException ex) {
                System.out.println("Invalid choice. Enter 1 or 2.");
            }
        }
    }

    public static void displaySequenceRecursive(int n) {
        System.out.println("Sequence up until n = " + n);
        for(int i = 0; i < n; i++) {
            System.out.println(SequenceTest.sequenceRecursive(i) + " ");
        }
    }

    public static void displayValueRecursive(int n) {
        System.out.println("Value in sequence at n = " + n + ": " + sequenceRecursive(n));
    }

    public static int sequenceRecursive(int n) {
        if(n < 3)
            return n;
        return sequenceRecursive(n - 3) + sequenceRecursive(n - 2) + sequenceRecursive(n - 1);
    }

    // --- Part B ---
    public static void loopTest() {
        Scanner userInput = new Scanner(System.in);
        
        System.out.println("--- Select an Option to Run ---\n [1] Display Entire Sequence\n [2] Display One Value");
        while(true) {
            try {
                switch (userInput.nextInt()) {
                    case 1:
                        System.out.print("Enter the length of the sequence: ");
                        displaySequenceLoop(userInput.nextInt());
                        break;
                    case 2:
                        System.out.print("Enter the index of the desired value: ");
                        displayValueLoop(userInput.nextInt());
                        break;
                    default:
                        throw new InputMismatchException();
                }
                break;
            }
            catch(InputMismatchException ex) {
                System.out.println("Invalid choice. Enter 1 or 2.");
            }
        }
    }

    public static void displaySequenceLoop(int n) {
        System.out.println("Sequence up until n = " + n);
        for(int i = 0; i < n; i++) {
            System.out.println(SequenceTest.sequenceLoop(i) + " ");
        }
    }

    public static void displayValueLoop(int n) {
        System.out.println("Value in sequence at n = " + n + ": " + sequenceLoop(n));
    }

    public static int sequenceLoop(int n) {
        if(n < 3) {
            return n;
        }

        int x = 0, y = 1, z = 2, result = x + y + z;

        for(int i = 3; i < n; i++) {
            x = y;
            y = z;
            z = result;
            result = x + y + z;
        }
        return result; 
    }
}
