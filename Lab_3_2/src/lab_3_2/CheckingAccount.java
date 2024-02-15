package lab_3_2;

import java.util.Date;

public class CheckingAccount {
    private int accountNum = 0;
    private String lastName = "lastName", firstName = "firstName";
    private double balance = 0, monthlyFee = 0, minBalance = 10;
    private Date dateCreated = new Date(); // sets date created to current time by default

    CheckingAccount() {} // default constructor

    CheckingAccount(int accountNum, String lastName, String firstName, double balance, 
        double monthlyFee, double minBalance, Date dateCreated) {
        // lets user know that input ID is invalid (and therefore will forcefully be changed to become valid)
        if (accountNum < 0) {
            System.out.println("Warning: given ID is less than 0, forcing positive value.");
        }
        this.accountNum = Math.abs(accountNum);
        this.balance = balance;
        this.lastName = lastName;
        this.firstName = firstName;
        this.balance = balance;
        this.monthlyFee = monthlyFee;
        this.minBalance = minBalance;
        this.dateCreated = dateCreated;
    }

    // Getters
    public int getAccountNum() {
        return accountNum;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public double getBalance() {
        return balance;
    }

    public double getMonthlyFee() {
        return monthlyFee;
    }

    public double getMinBalance(){
        return minBalance;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    // Setters
    public void setAccountNum(int accountNum) {
        this.accountNum = accountNum;
    }

    public void setLastName(String lastname) {
        this.lastName = lastname;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setMonthlyFee(double monthlyFee) {
        this.monthlyFee = monthlyFee;
    }

    public void setMinBalance(double minBalance) {
        this.minBalance = minBalance;
    }

    public void withdraw(double amount) {
        balance -= amount;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void applyMonthlyFee(){
        balance -= monthlyFee; // applying the monthly fee just reduces the balance by that fee
    }

    public String toString(){
        return "Account Number: " + accountNum + "\nLast Name: " + lastName + "\nFirst Name: " + firstName + "\nBalance: $" + balance + 
            "\nMonthly Fee: $" + monthlyFee + "\nMinimum Balance: " + minBalance + "\nDate Created: " + dateCreated.toString();
    }
}

