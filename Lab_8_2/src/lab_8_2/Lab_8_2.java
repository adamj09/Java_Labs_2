package lab_8_2;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab_8_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] filepaths = {"Lab_8_1/Q2.txt", "Lab_8_1/Q2Res.txt", "Lab_8_1/Q3.txt"};

        while(true){ // Run app (with menu)
            System.out.println("--- Demos ---\n [1] Fraction Creator\n [2] Remove from File Test\n" +
                " [3] File Info Test\n [4] Clear All Files\n [5] Exit");
            // Get choice of demo from user
            try {
                switch (input.nextInt()) {
                    case 1:
                        fractionTest();
                        break;
                    case 2:
                        try {
                            FileSystem.removeFromFileTest("Lab_8_2/names.txt");
                        }
                        catch(FileNotFoundException ex) {
                            System.out.println(ex);
                        }
                        break;
                    case 3:

                        break;
                    case 4: // Clear all files for further testing
                        // try {
                        //     for(String path : filepaths) {
                        //         FileSystem.writeToFile(path, "", false);
                        //     }
                        //     System.out.println("All files cleared!");
                        // }
                        // catch(IOException ex) {
                        //     System.out.println(ex);
                        // }
                        break;
                    case 5:
                        input.close();
                        System.exit(0);
                        break;
                    default:
                        throw new InputMismatchException();
                }
            }
            catch(InputMismatchException ex) {
                System.out.println("Invalid choice. \nPlease enter an integer between 1 and 5.");
                input.nextLine();
            }
            System.out.println();
        }
    }

    private static void fractionTest() {
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("Enter an integer for the numerator and denominator respectively: ");
            try {
                Fraction fraction = new Fraction(input.nextInt(), input.nextInt());
                System.out.println("Fraction is: " + fraction.getNumerator() + " / " + fraction.getDenominator());
                break;
            }
            catch(NullDenominatorException ex) {
                System.err.println(ex);
            }
        }
    }
}
