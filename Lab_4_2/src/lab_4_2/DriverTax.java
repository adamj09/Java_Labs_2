package lab_4_2;

import java.util.Scanner;

public class DriverTax {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Tax tax = new Tax();

        int choice;
        while(true){
            // Get choice from user
            System.out.println("--- Choose an option ---\n1 - Display with increment" +
                    "\n2 - User input\n3 - Quit");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    // Print tax for each filing status for income between $50,000 and $60,000, with increments of $1,000
                    for (int j = 0; j < 4; j++) {
                        // Header with filing status
                        System.out.printf("--- Filing status: %s ---\n", 
                            tax.getFilingStatusesAsStrings()[j]);
                        // Print income and associated tax owed
                        for (int i = 50000; i <= 60000; i += 1000) {
                            tax.setTaxableIncome(i);
                            System.out.printf("Tax on $%d is $%.2f\n", i, tax.getTax());
                        }
                        System.out.println(); // spacing
                    }
                    break;
                case 2: // User input
                    // Get filing status from user
                    do {
                        System.out.println("--- Enter the Filing Status ---\n0 - Single Filer\n"
                                + "1 - Married Jointly or Qualifying Widow(er)\n2 - Married Separately\n3 - Head of Household");
                        tax.setFilingStatus(input.nextInt());
                        if (tax.getFilingStatus() < 0 || tax.getFilingStatus() > 3) {
                            System.out.println("Invalid filing status. Please enter 0, 1, 2 or 3.");
                        }
                    } while (tax.getFilingStatus() < 0 || tax.getFilingStatus() > 3);

                    // Get taxable income from user
                    do {
                        System.out.println("Enter the taxable income: ");
                        tax.setTaxableIncome(input.nextDouble());
                        if (tax.getTaxableIncome() < 0) {
                            System.out.println("Income cannot be negative.");
                        }
                    } while (tax.getTaxableIncome() < 0);

                    // Display tax rate and taxed income
                    System.out.printf("Tax is %.2f%% ($%.2f)\n", tax.getTaxRate(), tax.getTax());
                    break;
                case 3: // Exit program
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                    break;
            }
        }   
    }
}