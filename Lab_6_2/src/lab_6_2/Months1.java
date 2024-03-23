package lab_6_2;

import java.util.Scanner;

public class Months1 {
    public static void monthDemo1() {
        Scanner scanner = new Scanner(System.in);

        // List of months and corresponding days
        String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        // Get numbers from user until number is an integer between 1 and 12, if so, display month and days in that month
        System.out.println("Enter an integer between 1 and 12: ");
        while(true) {
            try {
                int input = scanner.nextInt();
                System.out.println("Month: " + months[input - 1] + "\nDays in month: " + daysInMonth[input - 1]);
                break;
            }
            catch(ArrayIndexOutOfBoundsException ex) { // Number is not between 1 and 12
                System.out.println("Invalid input. Must be an integer between 1 and 12.");
            }
        }
    }
}
