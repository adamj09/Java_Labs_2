package lab_6_2;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab_6_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(true){ // Run app (with menu)
            System.out.println("--- Demos ---\n [1] Calculator App\n [2] Union Two Arrays\n "+ 
                "[3] Displays Months Version 1\n [4] Display Months Version 2\n [5] Exit");
            
            // Get choice of demo from user
            int choice = 0;
            try {
                choice = input.nextInt();
            }
            catch(InputMismatchException ex) {
                System.out.println("Invalid choice. \nPlease enter an integer between 1 and 5.");
                input.nextLine();
                continue;
            }
 
            if (choice > 5 || choice < 1){
                System.out.println("Invalid choice: " + choice + "\nPlease enter an integer between 1 and 5.");
                continue;
            }

            switch (choice) {
                case 1:
                    Calculator.runCalculatorApp();
                    System.out.println();
                    break;
                case 2:
                    Union.runUnion();
                    System.out.println();
                    break;
                case 3:
                    Months1.monthDemo1();
                    System.out.println();
                    break;
                case 4:
                    Months2.monthDemo2();
                    System.out.println();
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
    }
}
