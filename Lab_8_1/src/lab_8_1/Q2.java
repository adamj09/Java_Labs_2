package lab_8_1;

import java.io.IOException;

public class Q2 {
    public static void randNumTest() {
        String valuesPath = "Lab_8_1/Q2.txt", extremesPath = "Lab_8_1/Q2Res.txt";
        try {
            // First 5 random numbers
            saveInts(valuesPath, genRandInts(10, 10, 5));
            int[] oldMinMax = minMaxFromFile(valuesPath);

            // Print and save extremes
            System.out.println("Old Max: " + (int)oldMinMax[1] + " Old Min: " + (int)oldMinMax[0]);
            saveInts(extremesPath, oldMinMax);

            // Append next five random numbers to list
            saveInts(valuesPath, genRandInts(10, 20, 5));
            
            // Print and save extremes again
            int[] newMinMax = minMaxFromFile(valuesPath);
            System.out.println("New Max: " + (int)newMinMax[1] + " New Min: " + (int)newMinMax[0]);
            saveInts(extremesPath, newMinMax);
        }
        catch(IOException ex) {
            System.out.println(ex);
        }
    }

    private static void saveInts(String filepath, int[] numbers) {
        String content = "";
        for(int i = 0; i < numbers.length; i++) {
            content += numbers[i] + " ";
        }

        try {
            Main.writeToFile(filepath, content);
        }
        catch(IOException ex) {
            System.out.println("Failed to write to file.");
        }
    }

    private static int[] minMaxFromFile(String filepath) throws IOException {
        // Parse values from file
        String[] stringValues = Main.readFile(filepath).split(" ");
        int[] values = new int[stringValues.length];
        for(int i = 0; i < values.length; i++) {
            values[i] = Integer.parseInt(stringValues[i]);
        }
        // Get min and max from file
        int[] minMax = { values[0], values[0] };
        for(int num : values) {
            if(num > minMax[1]) {
                minMax[1] = num;
            }
            else if(num < minMax[0]) {
                minMax[0] = num;
            }
        }
        return minMax;
    }

    private static int[] genRandInts(int range, int offset, int numValues) {
        int[] values = new int[numValues];
        for(int i = 0; i < values.length; i++) {
            values[i] = (int)(Math.random() * range + offset);
        }
        return values;
    }
}
