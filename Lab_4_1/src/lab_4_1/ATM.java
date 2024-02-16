package lab_4_1;

import java.util.Scanner;

public class ATM {
    public static void atmSimulation(){
        Scanner input = new Scanner(System.in);

        Account[] accounts = new Account[10];
        for(int i = 0; i < accounts.length; i++){
            accounts[i] = new Account(i, 100);
        }

        // Get account ID from user
        int id = 0;
        do{
            System.out.print("Enter your account ID: ");
            id = input.nextInt();
            if(id < 0 || id > accounts.length){
                System.out.println("\nInvalid Account ID.\n");
            }
        } while(id < 0 || id > accounts.length);

        System.out.println("--- Account Options ---\n 1: Check Balance\n 2: Withdraw\n 3: Deposit\n 4: Exit"); // header
        
        // Get option from user
        int option = 0;
        do{
            option = input.nextInt();
            switch(option){
                case 1:
                    System.out.println(accounts[option].getBalance()); // Check Balance
                    break;
                case 2:
                    System.out.print("Enter an amount to withdraw: ");
                    break;
                case 3:

                    break;
                case 4:
                    System.out.println("Exitting..."); // Exit ATM
                    break;
                default:
                    System.out.print("\nInvalid Option.\nEnter Again: ");
            }
        } while(option < 1 || option > 4);
    }
}
