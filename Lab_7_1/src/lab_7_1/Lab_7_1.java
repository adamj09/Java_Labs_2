//package Lab_7_1.src.lab_7_1;
//
//import java.util.InputMismatchException;
//import java.util.Scanner;
//
//public class Lab_7_1 {
//    public static void main(String[] args) {
//        Scanner input = new Scanner(System.in);
//        while(true){ // Run app (with menu)
//            System.out.println("--- Demos ---\n [1] Loan Test\n [2] Triangle Test\n "+
//                "[3] Hexadecimal to Decimal Converter\n [4] Exit");
//            // Get choice of demo from user
//            try {
//                switch (input.nextInt()) {
//                    case 1:
//                        loanTest();
//                        System.out.println();
//                        break;
//                    case 2:
//                        triangleTest();
//                        System.out.println();
//                        break;
//                    case 3:
//                        System.out.println("Decimal form: " + hexToDecimalTest());
//                        System.out.println();
//                        break;
//                    case 4:
//                        System.exit(0);
//                        break;
//                    default:
//                        System.out.println("Invalid choice. \nPlease enter an integer between 1 and 5.");
//                        break;
//                }
//            }
//            catch(InputMismatchException ex) {
//                System.out.println("Invalid choice. \nPlease enter an integer between 1 and 5.");
//                input.nextLine();
//                continue;
//            }
//        }
//    }
//
//    private static void loanTest() {
//        Scanner scanner = new Scanner(System.in);
//
//        // Get user to create loan
//        Loan loan;
//        while (true) {
//            System.out.println("Enter the annual interest rate (%), duration (years), and amount ($) of the loan respectively: ");
//            try {
//                loan = new Loan(scanner.nextDouble(), scanner.nextInt(), scanner.nextDouble());
//                break; // Good loan, stop asking user
//            }
//            catch(InputMismatchException ex) { // Values not input properly
//                System.out.println("Invalid input.\nMake sure the annual interest rate and amount are decimal numbers, and the duration an integer.");
//                scanner.nextLine();
//            }
//            catch(IllegalArgumentException ex) { // Vales are less than or equal to 0
//                System.out.println("Invalid input.\nMake sure the annual interest rate, duration, and amount are greater than 0.");
//            }
//        }
//
//        System.out.printf("--- Loan Info ---\n - Amount borrowed: $%.2f\n - Total payment due: $%.2f\n - Monthly payment required: $%.2f\n" +
//            " - Annual interest rate: %.2f%%\n - Start date: %s (ends %d years from this date)\n",
//            loan.getLoanAmount(), loan.getTotalPayment(), loan.getMonthlyPayment(), loan.getAnnualInterestRate(), loan.getDate().toString(), loan.getNumYears());
//    }
//
//    private static void triangleTest() {
//        Scanner scanner = new Scanner(System.in);
//
//        // Get user to create triangle
//        Triangle triangle;
//        while(true) {
//            System.out.println("Enter the three sides of the triangle, its colour, and fill state respectively: ");
//            try {
//                triangle = new Triangle(scanner.nextDouble(), scanner.nextDouble(), scanner.nextDouble(), scanner.next(), scanner.nextBoolean());
//                break; // Good triangle, stop asking user
//            }
//            catch(InputMismatchException ex) { // Values not input properly
//                System.out.println("Invalid input.\n Make sure the values are entered in the following order: side1 side2 side3 colour fillState");
//            }
//            catch(IllegalTriangleException ex) { // Invalid triangle
//                System.out.println(ex);
//            }
//        }
//
//        // Print triangle's properties
//        System.out.printf("--- Triangle Properties ---\n - Side lengths: %.2f, %.2f, %.2f\n - Area: %.2f\n - Perimeter: %.2f\n",
//            triangle.getSide1(), triangle.getSide2(), triangle.getSide3(), triangle.getArea(), triangle.getPerimeter());
//    }
//
//    private static int hexToDecimalTest() {
//        Scanner scanner =  new Scanner(System.in);
//
//        // Get user to input hex number
//        while(true) {
//            System.out.println("Input a hexadecimal number to convert to decimal form: ");
//            try {
//                return HexToDecimal.hexToDecimal(scanner.nextLine());
//            }
//            catch(NumberFormatException ex) {
//                System.out.println(ex);
//            }
//        }
//    }
//}