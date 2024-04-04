package lab_8_1;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String[] filepaths = {"Lab_8_1/Q2.txt", "Lab_8_1/Q2Res.txt", "Lab_8_1/Q3.txt"};

        while(true){ // Run app (with menu)
            System.out.println("--- Demos ---\n [1] Binary Converter\n [2] Random Values Test\n" +
                " [3] File Info Test\n [4] Clear All Files\n [5] Exit");
            // Get choice of demo from user
            try {
                switch (input.nextInt()) {
                    case 1:
                        BinaryConverter.binToDecTest();
                        break;
                    case 2:
                    NumberSaveSystem.randNumTest(filepaths[0], filepaths[1]);
                        break;
                    case 3:
                        FileSystem.fileTest(filepaths[2]);
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
