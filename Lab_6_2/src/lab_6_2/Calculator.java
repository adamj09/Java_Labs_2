package lab_6_2;

import java.util.Scanner;
import java.util.ArrayList;

public class Calculator {
    // Store previous answer to make additional operations with
    private Double previousAnswer = null;

    public void runCalculatorApp() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Here's a basic calculator. Enter \"help\" for the list of commands and operators.");

        while(true) {
            StringBuilder input = new StringBuilder(scanner.nextLine());

            switch (input.toString().toLowerCase()) {
                case "help": // Provide list of commands and operators to user
                    displayHelp();
                    continue;
                case "c": // Clear the calculator
                    previousAnswer = null;
                    continue;
                case "e": // Exit the calculator
                    System.exit(0);
                    break;
                default: // Run an operation
                    try {
                        previousAnswer = calculate(input);
                        System.out.println(previousAnswer == null ? "": " = " + previousAnswer);
                    }
                    catch (ArithmeticException ex) {
                        System.out.println("Cannot divide by zero.");
                    }
                    break;
            }
        }
    }

    private Double calculate(StringBuilder input) {
        ArrayList<String> parsedInput = parseInput(input);
        String operator = "";
        double value1 = 0, value2 = 0;

        // Set values properly
        try {
            value1 = Double.parseDouble(parsedInput.get(0));
        }
        catch(NumberFormatException ex) {
            if(previousAnswer == null) {
                System.out.println("Invalid input. Bad formatting. Type \"help\" for more information.");
                return null;
            }
            value1 = previousAnswer;
        }

        try {
            operator = previousAnswer == null ? parsedInput.get(1): parsedInput.get(0);
            value2 = previousAnswer == null ? Double.parseDouble(parsedInput.get(2)): Double.parseDouble(parsedInput.get(1));
        }
        catch(Exception ex) {
            System.out.println("Invalid input. Bad formatting. Type \"help\" for more information.");
            return null;
        }

        switch (operator) {
            case "+":
                return value1 + value2;
            case "-":
                return value1 - value2;
            case "*":
                return value1 * value2;
            case "/":
                return divide(value1, value2);
            default:
                System.out.println("Invalid operator.");
                return null;
        }
    }

    //TODO: Handle decimal numbers
    private ArrayList<String> parseInput(StringBuilder input) {
        ArrayList<Double> digits = new ArrayList<>();
        ArrayList<String> parsed = new ArrayList<>();

        boolean operatorFound = false;
        for(int i = 0; i < input.length(); i++) {
            try {
                digits.add(Double.parseDouble(input.charAt(i) + "")); // Parse digits from input
            }
            catch(NumberFormatException ex) {
                // Add number
                if(digits.size() > 0) {
                    // Handle negatives
                    String number = i < (digits.size() + 1) ? "": (input.charAt(i - (digits.size() + 1)) == '-' ? "-" : "");

                    for(int j = 0; j < digits.size(); j++) { // Combine digits to make one number
                        number += digits.get(j).intValue() + "";
                    }

                    digits.clear();
                    parsed.add(number);
                }
                // Add operator
                else if((parsed.size() > 0 || previousAnswer != null) && !operatorFound && input.charAt(i) != ' ') { 
                    parsed.add(input.charAt(i) + ""); // Add operator
                    input.deleteCharAt(i--); // Remove operator so that they're not duplicated
                    operatorFound = true;
                }
            }

            // Add last number
            if(i == input.length() - 1) { 
                if(digits.size() > 0) {
                    // Handle negatives
                    String number =  input.charAt(i - (digits.size())) == '-' ? "-": "";

                    for(int j = 0; j < digits.size(); j++) { // Combine digits to make one number
                        number += digits.get(j).intValue() + "";
                    }

                    digits.clear();
                    parsed.add(number);
                }
            }
        }
        return parsed;
    }

    // Return quotient of two doubles. Java by default treats division of doubles by 0 as in limits,
    // which is not the intention here, which is why an exception is thrown instead of returning Infinity.
    private static double divide(double dividend, double divisor) throws ArithmeticException {
        if(divisor == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return dividend / divisor;
    }

    private static void displayHelp() {
        System.out.printf("""
        --- Commands ---
         [c] Clear
         [e] Exit
        --- Supported Operators ---
         [+] Addition
         [-]  Subtraction 
         [*] Multiplication
         [/] Division
        --- How to Use Operators ---
         Enter two values and an operator between them, separated by a space.
         Example formatting for an operation: 4 * 6
        """);
    }
}
