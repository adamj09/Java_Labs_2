package lab_8_2;

import java.io.*;
import java.util.Scanner;

public class FileSystem {
    public static void removeFromFileTest(String filepath) throws FileNotFoundException {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter a name to be removed: ");
        String removeName = userInput.next();

        File sourceFile = new File(filepath);

        PrintWriter output = new PrintWriter(sourceFile);
        output.print("Jack\nJohn\nJeremy\nJeff\nJebediah\nJohn\nJebediah\nJohn\nJeremy\nJeff");
        output.close();

        StringBuilder stringBuilder = new StringBuilder();

        try(Scanner input = new Scanner(sourceFile)) {
            while(input.hasNextLine()) {
                String s1 = input.nextLine();
                if(s1.equals(removeName)) {
                    
                }
            }
        }
        catch(FileNotFoundException ex) {
            System.err.println(ex);
        }
    }
}