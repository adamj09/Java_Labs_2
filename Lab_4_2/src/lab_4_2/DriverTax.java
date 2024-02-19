package lab_4_2;

import java.util.Scanner;

public class DriverTax {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Tax tax = new Tax();
        int filingStatus;
        double taxableIncome;
        double[] rates = new double[5];
        int[][] brackets = new int[4][5];
        System.out.println(
                "Enter the filing status\n0 - Single Filer\n1 - Married Jointly or Qualifying Widow(er)\n2 - Married Separately\n3 - Head of Household");
        filingStatus = input.nextInt();
        tax.setFilingStatus(filingStatus);
        System.out.println("Enter the tax brackets for the filing status");
        for (int i = 0; i < brackets.length; i++) {
            for (int j = 0; j < brackets[i].length; j++) {
                brackets[i][j] = input.nextInt();
            }
        }
        tax.setBrackets(brackets);
        System.out.println("Enter the tax rates for the filing status");
        for (int i = 0; i < rates.length; i++) {
            rates[i] = input.nextDouble();
        }
        tax.setRates(rates);
        System.out.println("Enter the taxable income");
        taxableIncome = input.nextDouble();
        tax.setTaxableIncome(taxableIncome);
        System.out.println("Tax is " + tax.getTax());
    }
}
