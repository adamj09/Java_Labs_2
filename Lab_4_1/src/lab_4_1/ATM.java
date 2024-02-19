package lab_4_1;

import java.util.Scanner;

public class ATM {
    private Account[] accounts = new Account[10];

    public void runAtm(){
        Scanner input = new Scanner(System.in);
        // Initialize accounts with default balance of $100.00
        for(int i = 0; i < accounts.length; i++){
            accounts[i] = new Account(i, 100);
        }

        // This loop runs the atm menu indefinitely
        while(true){
            // Get account ID from user
            int id = 0;
            do{ // Get input id and check if valid
                System.out.print("Enter your account ID: ");
                id = input.nextInt();
                if(id < 0 || id > accounts.length - 1){
                    System.out.println("\nInvalid account ID.\n");
                }
            } while(id < 0 || id > accounts.length - 1);
            // Display options for user
            System.out.println("--- Account Options ---\n 1: Check Balance\n 2: Withdraw\n 3: Deposit\n 4: Exit");

            // Get option from user
            int option = 0;
            do{
                System.out.print("Enter an option: ");
                option = input.nextInt();
                switch(option){
                    case 1: // Check Balance (prints balance, rounded to 2 decimal places)
                        System.out.printf("Current account balance: $%.2f\n", accounts[id].getBalance());
                        break;
                    case 2: // Withdraw
                        withdraw(id);
                        break;
                    case 3: // Deposit
                        deposit(id);
                        break;
                    case 4: // Exit simply allows the loop to reset, bringing the user back to the id check
                        System.out.println("Exitting...");
                        break;
                    default:
                        System.out.print("\nInvalid option.\nEnter again: ");
                }
            } while(option < 1 || option > 4);
        }
    }

    private void withdraw(int id){
        Scanner input = new Scanner(System.in);
        double sum = 0;
        do{ // Ask user to enter amount to withdraw and check if valid
            System.out.print("Enter an sum to withdraw: ");
            sum = input.nextDouble();
            if(sum <= 0){
                System.out.println("\nInvalid sum.\n");
            }
        } while(sum <= 0);
        accounts[id].withdraw(sum);
    }

    private void deposit(int id){
        Scanner input = new Scanner(System.in);
        double sum = 0;
        do{ // Ask user to enter amount to withdraw and check if valid
            System.out.print("Enter an sum to deposit: ");
            sum = input.nextDouble();
            if(sum <= 0){
                System.out.println("\nInvalid sum.\n");
            }
        } while(sum <= 0);
        accounts[id].deposit(sum);
    }
}
