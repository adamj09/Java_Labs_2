package lab_10.Q2;

import java.io.*;
import java.util.Scanner;

public class FileSearcher {
    // Print number of occurences of each letter in the alphabet in the file specified
    public static void findOccurencesOfLetters(String filepath) throws FileNotFoundException {
        System.out.println("Occurences of Letters in: " + filepath + "\n Letter\tOccurences"); // Header
        for(int i = 'A'; i <= 'Z'; i++) { // Print the occurences of each letter
            System.out.println(" " + (char)i + "\t" + findCharOccurences(filepath, (char)i));
        }
    }

    // Find occurences of any given character (case insensitive) in the file specified
    public static int findCharOccurences(String filepath, char regex) throws FileNotFoundException {
        File file = new File(filepath);
        if(!file.exists()) { // Check if file exists
            throw new FileNotFoundException("Could not find specified file: " + filepath);
        }

        // Find occurences
        int occurences = 0;
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()) {
            for(char character : scanner.nextLine().toCharArray()) { // Scan each line (include whitespaces)
                if(Character.toLowerCase(character) == Character.toLowerCase(regex)) {
                    occurences++; // If char is found to be regex, add to number of occurences
                }
            }
        }

        scanner.close();
        return occurences;
    }
}
