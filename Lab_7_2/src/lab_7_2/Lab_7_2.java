package lab_7_2;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Lab_7_2 {
    public static void main(String[] args) {
        Q1();
    }

    private static ArrayList<Integer> readIntsFromFile(File file) {
        Scanner scanner;

        try {
            scanner = new Scanner(file);
        }
        catch(FileNotFoundException ex) {
            System.out.println(ex);
            return null;
        }
        ArrayList<Integer> content = new ArrayList<>();

        while(scanner.hasNext()) {
            try {
                content.add(scanner.nextInt());
            }
            catch(InputMismatchException ex){
                scanner.next();
            }
        }
        scanner.close();
        return content;
    }

    private static File overwriteFile(String filepath, String content) {
        File file = new File(filepath);
        
        try {
            PrintWriter writer = new PrintWriter(file);
            writer.print(content);
            writer.close();  
        }
        catch(FileNotFoundException ex) {
            System.out.println("Failed to overwrite file.");
            return null;
        }
        return file;
    }

    // --- Q1 ---
    private static void Q1() {
        ArrayList<Integer> content = readIntsFromFile(saveRandNumbers(100, 1, 10, "Q1.txt"));
        
        int sum = 0;
        for(int i = 0; i < content.size(); i++) {
            sum += content.get(i);
        }

        System.out.println("Sum of random integers: " + sum);
    }

    private static File saveRandNumbers(int high, int offset, int numValues, String filepath) {
        int[] numbers = genRandIntegers(high, offset, numValues);
        String content = "";

        for(int number : numbers) {
            content += number + " ";
        }

        return overwriteFile(filepath, content);
    }

    private static int[] genRandIntegers(int high, int offset, int numValues) {
        int[] values = new int[numValues];
        for(int i = 0; i < numValues; i++) {
            values[i] = (int)((Math.random() * high) + offset);
        }
        return values;
    }

    // --- Q2 ---
    // private static int[] genRandDoubles(double high, double offset, int numValues) {
    //     double[] values = new double[numValues];
    //     for(int i = 0; i < numValues; i++) {
    //         values[i] = (int)((Math.random() * high) + offset);
    //     }
    //     return values;
    // }
}
