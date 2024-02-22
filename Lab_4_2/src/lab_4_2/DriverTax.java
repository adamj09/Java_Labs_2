package lab_4_2;

import java.util.Scanner;

public class DriverTax {
    private static final int[][] brackets2001 = { // Set default brackets to 2001 brackets
        {
            27050,
            65550,
            136750,
            297350,
            297351
        },
        {
            45200,
            109250,
            166500,
            297350,
            297351
        },
        {
            22600,
            54625,
            83250,
            148675,
            148676
        },
        {
            36250,
            93650,
            151650,
            297350,
            297351
        },
    };

    private static final int[][] brackets2009 = { // Set default brackets to 2001 brackets
        {
            8350,
            33950,
            82250,
            171550,
            372950,
            372951
        },
        {
            16700,
            67900,
            137050,
            208850,
            372950,
            372951
        },
        {
            8350,
            33950,
            68525,
            104425,
            186475,
            186476
        },
        {
            11950,
            45500,
            117450,
            190200,
            372950,
            372951
        },
    };

    private static final double[] rates2001 = {
        15,
        27.5,
        30.5,
        35.5,
        39.1
    };

    private static final double[] rates2009 = {
        10,
        15,
        25,
        28,
        33,
        35
    };

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Tax tax = new Tax();

        int choice;
        while(true){
            // Get choice from user
            System.out.println("--- Choose an option ---\n1 - Display increment for 2001 tax brackets" +
                    "\n2 - Display increment for 2009 tax brackets\n3 - User input\n4 - Quit");
            choice = input.nextInt();

            switch (choice) {
                case 1: // 2001 tax brackets
                    // Print tax for each filing status for income between $50,000 and $60,000, with increments of $1,000
                    tax.setBrackets(brackets2001);
                    tax.setRates(rates2001);
                    for (int j = 0; j < 4; j++) { // cycle through filing statuses
                        // Header with filing status
                        System.out.printf("--- Filing status: %s (2001) ---\n", tax.getFilingStatusesAsStrings()[j]);

                        // Print income and associated tax owed
                        for (int i = 50000; i <= 60000; i += 1000) {
                            tax.setTaxableIncome(i);
                            System.out.printf("Tax on $%d is $%.2f\n", i, tax.getTax());
                        }
                        System.out.println(); // spacing
                    }
                    break;
                case 2: // 2009 tax brackets
                    tax.setBrackets(brackets2009);
                    tax.setRates(rates2009);
                    for (int j = 0; j < 4; j++) { // cycle through filing statuses
                        // Header with filing status
                        System.out.printf("--- Filing status: %s (2009) ---\n", tax.getFilingStatusesAsStrings()[j]);
                        // Print income and associated tax owed
                        for (int i = 50000; i <= 60000; i += 1000) {
                            tax.setTaxableIncome(i);
                            System.out.printf("Tax on $%d is $%.2f\n", i, tax.getTax());
                        }
                        System.out.println(); // spacing
                    }
                    break;
                case 3: // User input
                    // Get filing status from user
                    int taxYear;
                    do {
                        System.out.println("Enter the tax year (2001 and 2009 supported): ");
                        taxYear = input.nextInt();
                        if(taxYear != 2001 && taxYear != 2009){
                            System.out.println("Invalid tax year. Please enter 2001 or 2009.");
                        }
                    } while(taxYear != 2001 && taxYear != 2009);

                    switch(taxYear){
                        case 2001:
                                tax.setBrackets(brackets2001);
                                tax.setRates(rates2001);
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
                                System.out.println("Tax Year: 2001, Filing Status: " + 
                                    tax.getFilingStatusesAsStrings()[tax.getFilingStatus()]); // header
                            break;
                        case 2009:
                                System.out.println("--- Tax Year: 2009 ---"); // header
                                tax.setBrackets(brackets2009);
                                tax.setRates(rates2009);
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
                                System.out.println("Tax Year: 2009, Filing Status: " + 
                                    tax.getFilingStatusesAsStrings()[tax.getFilingStatus()]); // header
                            break;
                    }
                    
                    // Display tax rate and taxed income
                    System.out.printf("Tax is %.2f%% ($%.2f)\n", tax.getTaxRate(), tax.getTax());
                    break;
                case 4: // Exit program
                    System.out.println("Exiting...");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
                    break;
            }
        }   
    }

  /* private static double getInputFromUser(String promptMessage, String errorMessage, double[] validInputs){
        Scanner input = new Scanner(System.in);
        double value;
        boolean isValid = false;
        do {
            System.out.println(promptMessage);
            value = input.nextDouble();

            for(int i = 0; i < validInputs.length i++){

            }
            if (tax.getTaxableIncome() < 0) {
                System.out.println(errorMessage);
            }
        } while (tax.getTaxableIncome() < 0);
    }*/
}