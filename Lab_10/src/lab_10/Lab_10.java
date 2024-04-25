package lab_10;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;

import lab_10.Q1.AdditionQuiz;
import lab_10.Q1.MultiplicationQuiz;
import lab_10.Q2.FileSearcher;
import lab_10.Q3.Q3Driver;
import lab_10.Q4.BookKeeper;
import lab_10.Q5.Q5Driver;

public class Lab_10 {
    public static void main(String[] args) {
        Scanner userInput = new Scanner(System.in);
        while(true){ // Run app (with menu)
            System.out.println("--- Demos ---\n [1] Addition Quiz \n [2] Multiplication Quiz \n " + 
                "[3] Occurences of Letters Finder \n [4] URL Read Test \n [5] Book Keeper \n " +
                "[6] Summable Test \n [7] Exit");
            try { 
                switch (userInput.nextInt()) { // Get choice of demo from user
                    case 1: // Q1
                        new AdditionQuiz(-50, 50).run();
                        break;
                    case 2: // Q1
                        new MultiplicationQuiz(-12, 12).run();
                        break;
                    case 3: // Q2
                        try {
                            FileSearcher.findOccurencesOfLetters("Lab_10/someText.txt");
                        }
                        catch(FileNotFoundException ex) {
                            System.out.println(ex);
                        }
                        break;
                    case 4: // Q3
                        Q3Driver.urlTest();
                        break;
                    case 5: // Q4
                        BookKeeper.bookKeep();
                        break;
                    case 6: // Q5
                        Q5Driver.summableTest();
                        break;
                    case 7: // Exit app
                        userInput.close();
                        System.exit(0);
                    default: // Invalid number
                        throw new InputMismatchException();
                }
                System.out.println(); // Add spacing between menu and demo
            }
            catch(InputMismatchException ex) { // Catch any invalid input
                System.err.println("Invalid choice. \nPlease enter an integer between 1 and 5.");
                userInput.nextLine(); // Clear input
            }
        }
    }
}
