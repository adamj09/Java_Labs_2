package lab_7_1;

import java.util.Date;

public class Loan {
    private double annualInterestRate = 2.5; // in percent
    private int numYears = 1;
    private double loanAmount = 1000;
    private Date date = new Date();

    Loan() {} // Default loan

    Loan(double annualInterestRate, int numYears, double loanAmount) throws IllegalArgumentException { // Custom Loan
        if(annualInterestRate <= 0 || numYears <= 0 || loanAmount <= 0) {
            throw new IllegalArgumentException("Loan amount, number of years, and annual interest rate must be greater than 0!");
        }
        this.annualInterestRate = annualInterestRate;
        this.numYears = numYears;
        this.loanAmount = loanAmount;
        date = new Date();
    }

    // --- Getters ---
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public int getNumYears() {
        return numYears;
    }

    public double getLoanAmount() {
        return loanAmount;
    }

    public Date getDate() {
        return date;
    }

    // --- Setters ---
    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public void setNumYears(int numYears) {
        this.numYears = numYears;
    }

    public void setLoanAmount(double loanAmount) {
        this.loanAmount = loanAmount;
    }

    // Divide total payment required by number of months payment is made over to get monthly payment due
    public double getMonthlyPayment() {
        return getTotalPayment() / (numYears * 12);
    }

    // Use compound interest formula to get total payment required at end of loan period
    public double getTotalPayment() {
        return loanAmount * Math.pow(1 + (annualInterestRate / 100), numYears); 
    }
}
