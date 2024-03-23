package lab_6_2;

import java.util.Scanner;
import java.util.ArrayList;

public class Calculator {
    // Store previous answer to make additional operations with
    private static Double previousAnswer = null;

    public static void runCalculatorApp() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Here's a basic calculator. Enter \"help\" for the list of commands and operators.");

        while(true) {
            String input = scanner.nextLine();

            switch (input.toString().toLowerCase()) {
                case "help": // Provide list of commands and operators to user
                    displayHelp();
                    break;
                case "c": // Clear the previous answer
                    previousAnswer = null;
                    break;
                case "e": // Exit the calculator
                    System.exit(0);
                    break;
                default: // Run an operation
                    try {
                        Double answer = calculate(input);
                        if(answer > Double.MAX_VALUE) {
                            System.out.println("Error: overflow.");
                        }
                        else {
                            previousAnswer = answer;
                            System.out.printf(" = %.10f\n", previousAnswer);
                        }
                    }
                    catch (Exception ex){}
                    break;
            }
        }
    }

    private static Double calculate(String input) throws NullPointerException {
        ArrayList<String> parsedInput = new ArrayList<>();
        try {
            parsedInput = parseInput(input);
        }
        catch (NumberFormatException ex) {
            System.out.println("Error: invalid input. Bad formatting. Type \"help\" for more information.");
            throw new NullPointerException();
        }
        // Make sure there were no parsing errors

        String operator = "";
        double value1 = 0, value2 = 0;

        // Set values accordingly
        if(parsedInput.size() > 2) {
            previousAnswer = null;
            value1 = Double.parseDouble(parsedInput.get(0));
            value2 = Double.parseDouble(parsedInput.get(1));
            operator = parsedInput.get(2);
        }
        else if(previousAnswer != null) {
            value1 = previousAnswer;
            value2 = Double.parseDouble(parsedInput.get(0));
            operator = parsedInput.get(1);
        }
        else {
            System.out.println("Error: invalid input. Bad formatting. Type \"help\" for more information.");
            throw new NullPointerException();
        }

        // Return result of operation
        switch (operator) {
            case "+":
                return value1 + value2;
            case "-":
                return value1 - value2;
            case "*":
                return value1 * value2;
            case "/":
                try {
                    return divide(value1, value2);
                }
                catch(ArithmeticException ex) {
                    System.out.println("Error: cannot divide by zero.");
                }
            default:
                System.out.println("Error: invalid operator.");
                throw new NullPointerException();
        }
    }

    private static ArrayList<String> parseInput(String input) throws NumberFormatException {
        ArrayList<String> inputArray = new ArrayList<>();

        // Split input into array for easier parsing
        for(int i = 0; i < input.length(); i++) {
            if(input.charAt(i) == ' ') {
                continue;
            }
            inputArray.add(input.charAt(i) + "");
        }

        // Make sure array actually contains an operator
        boolean containsOperator = false;
        for(int i = 0; i < inputArray.size() - 1; i++) {
            if(!isNumber(inputArray.get(i)) && inputArray.get(i) != ".") {
                containsOperator = true;
            }
        }
        // If no operator is found, or if an operator is found at the end of input, return null
        if(!containsOperator || !isNumber(inputArray.get(inputArray.size() - 1))) {
            throw new NumberFormatException();
        }

        String digits = "0"; // Store digits
        ArrayList<String> parsed = new ArrayList<>(); // Store fully parsed numbers

        // Parse numbers
        for(int i = 0; i < inputArray.size(); i++) {
            if(inputArray.get(i).equals(".") && digits.contains(".")) { // Number contains two decimals, abort.
                throw new NumberFormatException();
            }
            else if(isNumber(inputArray.get(i)) || inputArray.get(i).equals(".")) { // Add digit or decimal
                digits += inputArray.get(i);
            }
            else if(digits.length() > 1) { // Add first number (once a non-numerical value is encountered)
                parsed.add(digits);
                digits = "0"; // Add leading zero for input that starts with a decimal
            }

            if(digits.length() > 0 && i == inputArray.size() - 1) { // Add last number
                parsed.add(digits);
                digits = "0";
            }
        }

        // Add negatives to parsed numbers
        for(int i = 0; i < inputArray.size(); i++) {
            try {
                if((inputArray.get(i).equals("-") && i != inputArray.size() - 1) 
                    && (isNumber(inputArray.get(i + 1)) && !isNumber(inputArray.get(i - 1)))){
                    parsed.set(parsed.size() - 1, "-" + parsed.get(parsed.size() - 1));
                    inputArray.set(i, "0");
                }
            }
            catch (IndexOutOfBoundsException ex) {
                if(i == 0 && parsed.size() > 1) {
                    digits = "-" + digits;
                    inputArray.set(i, "0");
                }
            }
        }

        // Find Operator, if multiple operators are found, return null
        boolean operatorFound = false;
        for(int i = 0; i < inputArray.size(); i++) {
            if(!isNumber(inputArray.get(i)) && !inputArray.get(i).equals(".")){
                if(operatorFound == true) {
                    throw new NumberFormatException("Error: invalid input. Bad formatting. Type \"help\" for more information.");
                }
                parsed.add(inputArray.get(i));
                operatorFound = true;
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

    private static boolean isNumber(String string) {
        try {
            Double.parseDouble(string);
            return true;
        }
        catch (NumberFormatException ex) {
            return false;
        }
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
         Example formatting for an operation: .4 * -6.2
         Example formatting for an operation made to the previous answer: + 5
        """);
    }
}
