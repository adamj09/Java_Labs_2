package lab_3_2;

import java.util.Scanner;
import java.util.Date;

public class DemoCheckingAccount {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        CheckingAccount[] checkingAccounts = new CheckingAccount[2];


        // Build checking accounts with different constructors (filled with user-provided info)
        for(int i = 0; i < checkingAccounts.length; i++){
            System.out.printf("--- Enter the Following Information About Account %d In Order ---" +
                "\n- Account Number\n- Last Name\n- First Name\n- Balance\n- Monthly Fee\n- Minimum Balance\n", i + 1); // prompt user to enter info
            
            if(i == 0){ // no-arg constructor
                checkingAccounts[i] = new CheckingAccount();
                checkingAccounts[i].setAccountNum(input.nextInt());
                checkingAccounts[i].setLastName(input.next());
                checkingAccounts[i].setFirstName(input.next());
                checkingAccounts[i].setBalance(input.nextDouble());
                checkingAccounts[i].setMonthlyFee(input.nextDouble());
                checkingAccounts[i].setMinBalance(input.nextDouble());
            }
            else { // all arg constructor
                checkingAccounts[i] = new CheckingAccount(input.nextInt(), input.next(), input.next(), input.nextDouble(), input.nextDouble(), input.nextDouble(), new Date());
            }
            System.out.println("--- Account " + (i + 1) + " ---\n" + checkingAccounts[i].toString()); // display account info after creation
        }

        // test deposite method
        checkingAccounts[0].deposit(1000.0);
        checkingAccounts[1].deposit(1500.0);

        // test withdraw method
        checkingAccounts[0].withdraw(100.0);
        checkingAccounts[1].withdraw(245.55);

        for(int i = 0; i < checkingAccounts.length; i++){
            System.out.println("--- Account " + (i + 1) + " ---\n" + checkingAccounts[i].toString());
        }
    }
}
