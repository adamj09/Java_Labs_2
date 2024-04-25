package lab_10.Q2;

import java.io.*;
import java.util.Scanner;

public class FileSearcher {

    public static void findOccurencesOfLetters(String filepath) throws FileNotFoundException {
        System.out.println("Occurences of Letters in: " + filepath + "\n Letter\tOccurences");
        for(int i = 'A'; i <= 'Z'; i++) {
            System.out.println(" " + (char)i + "\t" + findCharOccurences(filepath, (char)i));
        }
    }

    public static int findCharOccurences(String filepath, char searchedChar) throws FileNotFoundException {
        File file = new File(filepath);
        if(!file.exists()) {
            throw new FileNotFoundException("Could not find specified file: " + filepath);
        }

        int occurences = 0;
        Scanner scanner = new Scanner(file);
        while(scanner.hasNextLine()) {
            for(char character : scanner.nextLine().toCharArray()) {
                if(Character.toLowerCase(character) == Character.toLowerCase(searchedChar)) {
                    occurences++;
                }
            }
        }

        scanner.close();
        return occurences;
    }
}
