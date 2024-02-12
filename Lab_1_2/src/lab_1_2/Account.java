package lab_1_2;

import java.util.Date;

public class Account {
    private int id = 0;
    private double balance = 0, annualInterestRate = 0; // in percent
    private Date dateCreated = new Date(); // sets date created to current time by default

    Account() {} // default constructor

    Account(int id, double balance) {
        // lets user know that input ID is invalid (and therefore will forcefully be changed to become valid)
        if (id < 0) {
            System.out.println("Warning: given ID is less than 0, forcing positive value.");
        }
        this.id = Math.abs(id);
        this.balance = balance;
    }

    public int getId() {
        return id;
    }

    public double getBalance() {
        return balance;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public void setAnnualInterestRate(double annualInterestRate) {
        this.annualInterestRate = annualInterestRate;
    }

    public double getMonthlyInterest(){
        return ((annualInterestRate / 12) / 100) * balance;
    }

    public void withdraw(double amount){
        balance -= amount;
    }

    public void deposit(double amount){
        balance += amount;
    }
}
