package lab_7_2;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Lab_7_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while(true){ // Run app (with menu)
            System.out.println("--- Demos ---\n [1] Random Integers\n [2] Random Doubles\n [3] Animal Names\n [4] Exit");
            // Get choice of demo from user
            try {
                switch (input.nextInt()) {
                    case 1:
                        Q1();
                        break;
                    case 2:
                        Q2();
                        break;
                    case 3:
                        Q3();
                        break;
                    case 4:
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

    private static void Q1() {
        String content = "";
        for(int i = 0; i < 10; i++) {
            content += (int)(Math.random() * 100 + 1) + " ";
        }

        ArrayList<Double> values = readNumbersFromFile(overwriteFile("Lab_7_2/Q1.txt", content));
        
        int sum = 0;
        for(double num : values) {
            sum += num;
        }

        System.out.println("Sum of random integers: " + sum);
    }

    private static void Q2() {
        String content = "";
        for(int i = 0; i < 15; i++) {
            content += (Math.random() * 100 + 1) + " ";
        }

        ArrayList<Double> values = readNumbersFromFile(overwriteFile("Lab_7_2/Q2.txt", content));

        double max = values.get(0), min = values.get(0);
        for(double num : values) {
            if(num > max) {
                max = num;
            }
            else if(num < min) {
                min = num;
            }
        }

        System.out.println("Max of random doubles: " + max + "\nMin of random doubles: " + min);
    }

    private static void Q3() {
        // Initial setup
        ArrayList<String> names = readStringsFromFile(overwriteFile("Lab_7_2/Q3.txt", "jaguar tiger dog elephant iguana crane piranha cat opossum bear"));
        
        Scanner userInput = new Scanner(System.in);
        System.out.println("Enter the name of some animals to add to the list. Type \"exit\" to quit."); // Prompt user
        while(true) {
            String newName = userInput.next().toLowerCase();

            if(newName.equals("exit")) { // Exit loop
                return;
            }

            if(names.contains(newName)) { // If item is found, do nothing
                System.out.println("Success: \"" + newName + "\" was found!");
                continue;
            }

            // Item was not found, add to array list
            System.out.println("\"" + newName + "\" was not found! Adding it to the list...");
            names.add(newName); // Add to array list
            
            // Convert array list to string
            String content = "";
            for(String name : names) {
                content += name + " ";
            }

            // Overwrite file with updated content
            overwriteFile("Lab_7_2/Q3.txt", content);
        }
    }

    // Gather individual words from a text file into an array list
    private static ArrayList<String> readStringsFromFile(File file) {
        ArrayList<String> content = new ArrayList<>();

        try(Scanner scanner = new Scanner(file)) {
            while(scanner.hasNext()) {
                content.add(scanner.next());
            }
        }
        catch(FileNotFoundException ex) {
            System.out.println(ex);
            return null;
        }
        return content;
    }

    // Gather numbers from a text file into an array list
    private static ArrayList<Double> readNumbersFromFile(File file) {
        ArrayList<Double> content = new ArrayList<>();

        try(Scanner scanner = new Scanner(file)) {
            while(scanner.hasNext()) {
                try { // Add number
                    content.add(scanner.nextDouble());
                }
                catch(InputMismatchException ex){
                    scanner.next(); // If it's not a number, skip it
                }
            }
        }
        catch(FileNotFoundException ex) {
            System.out.println(ex);
            return null;
        }
        return content;
    }

    // Overwrites file with given content, or creates new file if file does not exist
    private static File overwriteFile(String filepath, String content) {
        File file = new File(filepath);
        
        try(PrintWriter writer = new PrintWriter(file)) {
            writer.print(content);
        }
        catch(FileNotFoundException ex) {
            System.out.println("Failed to overwrite file.");
            return null;
        }
        return file;
    }
}
