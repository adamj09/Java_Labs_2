package lab_6_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {
    public static void runCalculatorApp() {
        Scanner input = new Scanner(System.in);
        while(true) {
            double num1 = 1, num2 = 1;
            String operator = "";
            while(true) {
                try {
                    num1 = input.nextDouble();
                    operator = input.next();
                    num2 = input.nextDouble();
                    break;
                }
                catch (InputMismatchException ex) {
                    System.out.println("Invalid formatting. Format should be: [double] [operator] [double].");
                    input.nextLine();
                }
            }
            
            switch (operator) {
                case "+":
                    System.out.println(" = " + (num1 + num2));
                    break;
                case "-":
                    System.out.println(" = " + (num1 - num2));
                    break;
                case "*":
                    System.out.println(" = " + (num1 * num2));
                    break;
                case "/":
                    try {
                        System.out.println(" = " + divide(num1, num2));
                    }
                    catch (ArithmeticException ex) {
                        System.out.println("Cannot divide by zero.");
                    }
                    break;
                default:
                    System.out.println("Invalid operator.");
                    break;
            }
            System.out.println("Calculation complete. Enter \"exit\" to exit.");
            if(input.next().toLowerCase() == "exit") {
                System.exit(0);
            }
        }
    }

    public static double divide(double dividend, double divisor) throws ArithmeticException {
        if(divisor == 0) {
            throw new ArithmeticException("Cannot divide by zero.");
        }
        return dividend / divisor;
    }
}
