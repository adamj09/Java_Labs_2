package lab_8_1;

import java.io.*;
import java.util.Scanner;

public class Lab_8_1 {
    public static void main(String[] args) {
        double[] minMax1 = saveNumbers("Lab_8_1/Q2.txt", generateRandomValues(10, 10, 5));
        saveNumbers("Lab_8_1/Q2Res.txt", minMax1);
    }

    public static double[] saveNumbers(String filepath, double[] randomNumbers) {
        String content = "";
        for(int i = 0; i < randomNumbers.length; i++) {
            content += (int)randomNumbers[i] + " ";
        }

        try {
            writeToFile(filepath, content);

            String[] stringValues = readFile(filepath).split(" ");
            double[] values = new double[stringValues.length];
            for(int i = 0; i < values.length; i++) {
                values[i] = Integer.parseInt(stringValues[i]);
            }
            System.out.println("Max: " + (int)minMax(values)[1] + " Min: " + (int)minMax(values)[0]);
            return minMax(values);
        }
        catch(IOException ex) {
            System.out.println("Failed to write or read to file.");
        }
        catch(NumberFormatException ex) {
            System.out.println("Failed to read integers from file.");
        }
        return null;
    }

    public static void writeToFile(String filepath, String content) throws IOException {
        FileWriter file = new FileWriter("Lab_8_1/Q2.txt");
        file.append(content);
        file.close();
    }

    public static String readFile(String filepath) throws IOException {
        FileReader reader = new FileReader(filepath);
            
        String content = "";
        int i;
        while((i = reader.read()) != -1) {
            content += (char)i;
        }
        reader.close();
        return content;
    }

    public static double[] minMax(double[] values) {
        double[] minMax = { values[0], values[0] };
        for(double num : values) {
            if(num > minMax[1]) {
                minMax[1] = num;
            }
            else if(num < minMax[0]) {
                minMax[0] = num;
            }
        }
        return minMax;
    }

    public static double[] generateRandomValues(double range, double offset, int numValues) {
        double[] values = new double[numValues];
        for(int i = 0; i < values.length; i++) {
            values[i] = Math.random() * range + offset;
        }
        return values;
    }
}
