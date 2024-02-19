package lab_4_2;

import java.util.Scanner;

public class DriverTax {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Tax tax = new Tax();
        int filingStatus;
        double taxableIncome;

        System.out.println("Choose an option:");
        System.out.println("1 - Display with increment");
        System.out.println("2 - User input");
        System.out.println("3 - Quit");

        int choice = input.nextInt();

        switch (choice) {
            case 1:
                // Disp2lay with increment logic here
                break;
            case 2:
                System.out.println(
                        "Enter the filing status\n0 - Single Filer\n1 - Married Jointly or Qualifying Widow(er)\n2 - Married Separately\n3 - Head of Household");
                filingStatus = input.nextInt();
                tax.setFilingStatus(filingStatus);
                System.out.println("Enter the taxable income");
                taxableIncome = input.nextDouble();
                tax.setTaxableIncome(taxableIncome);
                System.out.println("Tax is " + tax.getTax());
                break;
            case 3:
                System.out.println("Exiting...");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                break;
        }
    }
}