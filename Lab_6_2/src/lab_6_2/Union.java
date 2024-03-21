package lab_6_2;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Union {
    // Test for the two below methods
    public static void runUnion(){
        // Get arrays of integers from user
        ArrayList<Integer> array1 = new ArrayList<>();
        fillIntegerArray(array1, 5, "Enter five integers for array 1: ");
        ArrayList<Integer> array2 = new ArrayList<>();
        fillIntegerArray(array2, 5, "Enter five integers for array 2: ");

        // Display Original Arrays
        System.out.print("Array 1: ");
        for(int value : array1) {
            System.out.print(value + " ");
        }
        System.out.print("\nArray 2: ");
        for(int value : array2) {
            System.out.print(value + " ");
        }

        // Create and display unioned array
        ArrayList<Integer> unioned = union(array1, array2);
        System.out.print("\nUnioned array: ");
        for(int value : unioned) {
            System.out.print(value + " ");
        }
        System.out.println(); // Spacing
    }

    // Return new array that is two concatenated arrays
    public static ArrayList<Integer> union(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> union = new ArrayList<>();
        union.addAll(list1);
        union.addAll(list2);
        return union;
    }

    // Fill an array of integers with user input
    public static void fillIntegerArray(ArrayList<Integer> array, int size, String prompt) {
        Scanner input = new Scanner(System.in);

        int clearCount = 0;
        while(array.size() < size) { // Redo process until the array is filled
            System.out.println(prompt);

            for (;clearCount > 0; clearCount--) {
                input.next(); // Empty input stream before inputting array 
            }

            while(array.size() < size) { // Attempt to fill array
                try {
                    array.add(input.nextInt()); // Add value to array
                }
                catch(InputMismatchException ex) {
                    System.out.println("Invalid input. Enter integers only.");
                    clearCount = size - array.size(); // Number of values needed to clear from input stream to empty it
                    array.clear(); // Clear the array of any previous input
                    break;
                }
            }
        }
    }
}
