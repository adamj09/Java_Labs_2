package lab_11_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class SumTests {
    public static void sumTest() {
        Scanner userInput = new Scanner(System.in);

        // Get user to choose which implementation to run
        System.out.println("--- Select an Implementation to Run ---\n [1] Recursion Implementation\n [2] Loop Implementation");
        while(true) {
            try {
                switch (userInput.nextInt()) {
                    case 1:
                        try{
                            System.out.print("Enter a number to find the sum of digits of: ");
                            System.out.println(sumDigitsRecursive(userInput.nextLong())); // Run recursive implementation
                        }
                        catch(InputMismatchException ex) { // Catch if number is too large
                            System.out.println("Number too large!");
                            userInput.nextLine();
                            continue;
                        }
                        break;
                    case 2:
                        try{
                            System.out.print("Enter a number to find the sum of digits of: ");
                            System.out.println(sumDigitsLooped(userInput.nextLong())); // Run loop implementation
                        }
                        catch(InputMismatchException ex) { // Catch if number is too large
                            System.out.println("Number too large!");
                            userInput.nextLine();
                            continue;
                        }
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

    // Get the sum of all digits in a number using recursion
    public static int sumDigitsRecursive(long number) {
        int result = 0;
        if(number != 0)
            result = sumDigitsRecursive(number / 10) + (int)(number % 10);
        return result;
    }

    // Get the sum of all digits in a number using a loop
    public static int sumDigitsLooped(long number) {
        int result = 0;
        while(number > 0){
            result += number % 10;
            number /= 10;
        }
        return result;
    }
}
