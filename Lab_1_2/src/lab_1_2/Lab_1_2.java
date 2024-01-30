package lab_1_2;

import java.util.Random;
import java.util.Scanner;
import java.util.Date;

public class Lab_1_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Menu to run demos from
        do { // Outer loop lets users run multiple demos in one session
            int selection;
            do { // Inner loop takes in user input and selects a demo to run based on that
                System.out.println("Select a demo to run from the list below:\n Random Number Demo [0]\n Date Demo[1]\n Account Demo[2]");
                selection = input.nextInt();
                System.out.println(); // Spacing between menu and output of demo

                switch (selection) {
                    case 0:
                        randomDemo();
                        break;
                    case 1:
                        dateDemo();
                        break;
                    case 2:
                        accountDemo();
                        break;
                    default:
                        System.out.println("Invalid selection, please choose a demo from 0 to 2");
                        break;
                }
            } while(selection < 0 || selection > 2);
        System.out.println("\nDemo complete. Type \"end\" to exit the program, or enter any other character to run another demo.");
        } while(!input.next().equalsIgnoreCase("end"));
    }

    public static void randomDemo(){
        Random random = new Random(1000);

        for(int i = 0; i < 50; i++){
            System.out.println(random.nextInt(100));
        }
    }

    public static void dateDemo(){
        Date date = new Date();

        for(long i = 10000; i <= 100000000000L; i *= 10){
            date.setTime(i);
            System.out.println(date.toString());
        }
    }

    public static void accountDemo(){
        Account account = new Account(1122, 20000); // create new account object
        // test methods for account
        account.setAnnualInterestRate(4.5);
        account.withdraw(2500);
        account.deposit(3000);
        // print account information
        System.out.printf("--- Account Details ---\n Balance: $%.2f\n Monthly Interest: $%.2f\n Account Creation Date: %s\n"
        , account.getBalance(), account.getMonthlyInterest(), account.getDateCreated().toString());
    }
}
