package lab_8_2;

import java.io.*;
import java.util.Scanner;

public class FileSystem {
    public static void removeFromFileTest(String oldFilepath, String updatedFilepath) throws IOException {
        // Write some example content to file
        File oldFile = new File(oldFilepath);
        PrintWriter oldPrintWriter = new PrintWriter(oldFile);
        oldPrintWriter.print("Jack\nJohn\nJeremy\nJeff\nJebediah\nJohn\nJebediah\nJohn\nJeremy\nJeff");
        oldPrintWriter.close();

        // Ask user to input content to remove (case-sensitive)
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter content to be removed: ");
        String removed = userInput.nextLine();

        // Read into file and add to stringBuilder all content that is to be kept
        try(Scanner input = new Scanner(oldFile)) {
            StringBuilder stringBuilder = new StringBuilder();
            while(input.hasNextLine()) {
                String s1 = input.nextLine();
                if(!s1.equals(removed)) {
                    stringBuilder.append(s1 + "\n");
                }
            }
            writeToFile(updatedFilepath, stringBuilder.toString(), false); // Write kept content to file
        }
        catch(FileNotFoundException ex) {
            System.err.println(ex);
        }
    }

    public static void replaceInFileTest(String oldFilepath, String updatedFilepath) throws IOException {
        // Write some example content to file
        File oldFile = new File(oldFilepath);
        PrintWriter oldPrintWriter = new PrintWriter(oldFile);
        oldPrintWriter.print("Jack\nJohn\nJeremy\nJeff\nJebediah\nJohn\nJebediah\nJohn\nJeremy\nJeff");
        oldPrintWriter.close();

        // Ask user to input content to remove (case-insensitive)
        Scanner userInput = new Scanner(System.in);
        System.out.println("Find: ");
        String replaced = userInput.nextLine();
        System.out.println("Replace with: ");
        String replacing = userInput.nextLine();

        // Read into file and add to stringBuilder all content that is to be kept
        try(Scanner input = new Scanner(oldFile)) {
            StringBuilder stringBuilder = new StringBuilder();
            while(input.hasNextLine()) {
                String s1 = input.nextLine();
                if(s1.toLowerCase().equals(replaced.toLowerCase())) { 
                    stringBuilder.append(replacing + "\n");
                }
                else {
                    stringBuilder.append(s1 + "\n");
                }
            }
            writeToFile(updatedFilepath, stringBuilder.toString(), false); // Write kept content to file
        }
        catch(FileNotFoundException ex) {
            System.err.println(ex);
        }
    }

    public static void writeToFile(String filepath, String content, boolean append) throws IOException {
        FileWriter file = new FileWriter(filepath, append);
        file.append(content);
        file.close();
    }

    public static String readFile(String filepath) throws IOException {
        FileReader reader = new FileReader(filepath);
        
        String content = "";
        for(int i; (i = reader.read()) != -1;) {
            content += (char)i;
        }
        reader.close();
        return content;
    }
}