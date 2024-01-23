package lab_1_2;

import java.util.Date;

public class Account {
    private int id = 0;
    private double balance = 0, annualInterestRate = 0; // in percent
    private Date dateCreated;

    Account(){
        dateCreated = new Date(System.currentTimeMillis());
    }

    Account(int id, double balance){
        if(id < 0){
            System.out.println("Warning: given ID is less than 0, forcing positive value.");
        }
        if(balance < 0){
            System.out.println("Warning: given balance is less than 0, forcing positive value.");
        }
        this.id = Math.abs(id);
        this.balance = Math.abs(balance);
    }

    public int getId(){
        return id;
    }

    public double getBalance(){
        return balance;
    }

    public double getAnnualInterestRate(){
        return annualInterestRate;
    }

    public Date getDateCreated(){
        return dateCreated;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setBalance(double balance){
        this.balance = balance;
    }

    public void setAnnualInterestRate(double annualInterestRate){
        this.annualInterestRate = annualInterestRate;
    }

    public double getMonthlyInterest(){
        return 0.0;
    }

    public void withdraw(double amount){

    }

    public void deposit(double amount){

    }
}
