package lab_8_2;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Lab_8_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] filepaths = {"Lab_8_2/names.txt", "Lab_8_2/newNames.txt", "Lab_8_2/original.txt", "Lab_8_2/replaced.txt"};

        while(true){ // Run app (with menu)
            System.out.println("--- Demos ---\n [1] Fraction Creator\n [2] Remove from File Test\n" +
                " [3] Replace Text in File Test\n [4] Clear All Files\n [5] Exit");
            // Get choice of demo from user
            try {
                switch (input.nextInt()) {
                    case 1:
                        Fraction.fractionTest();
                        break;
                    case 2:
                        try {
                            FileSystem.removeFromFileTest(filepaths[0], filepaths[1]); // Save new list with removed content into new file
                            FileSystem.writeToFile(filepaths[0], FileSystem.readFile(filepaths[1]), false); // Update old file with new file's content
                            System.out.println("Content removed!");
                        }
                        catch(IOException ex) {
                            System.out.println(ex);
                        }
                        break;
                    case 3:
                        try {
                            FileSystem.replaceInFileTest(filepaths[2], filepaths[3]); // Save new list with replaced content into new file
                            FileSystem.writeToFile(filepaths[2], FileSystem.readFile(filepaths[3]), false); // Update old file with new file's content
                            System.out.println("Content replaced!");
                        }
                        catch(IOException ex) {
                            System.out.println(ex);
                        }
                        break;
                    case 4: // Clear all files for further testing
                        try {
                            for(String path : filepaths) {
                                FileSystem.writeToFile(path, "", false);
                            }
                            System.out.println("All files cleared!");
                        }
                        catch(IOException ex) {
                            System.out.println(ex);
                        }
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
}
