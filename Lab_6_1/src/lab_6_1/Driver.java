package lab_6_1;

import java.util.Scanner;
import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(true){ // Run app (with menu)
            System.out.println("--- Demos ---\n [1] Largest Rows and Columns\n [2] Sort\n "+ 
                "[3] Union Arrays\n [4] To Character Array\n [5] Exit");
            
            // Get choice of demo from user
            int choice = input.nextInt();
            if (choice > 5 || choice < 1){
                System.out.println("Invalid choice: " + choice + "\nPlease choose a value between 1 and 5.");
                continue;
            }

            switch (choice) {
                case 1:
                    largestRowsAndColumnsTest();
                    System.out.println();
                    break;
                case 2:
                    sortTest();
                    System.out.println();
                    break;
                case 3:
                    unionTest();
                    System.out.println();
                    break;
                case 4:
                    toCharacterArrayTest();
                    System.out.println();
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
    }

    public static void largestRowsAndColumnsTest() {
        Scanner input = new Scanner(System.in);
        // Get the matrix's side length from the user
        int sideLength = 0;
        do {
            System.out.println("Enter the square matrix's side length: ");
            sideLength = input.nextInt();
            if(sideLength <= 0) {
                System.out.println("Invalid side length: must be greater than 0!");
            }
        } while(sideLength <= 0);

        // Create and print matrix
        int[][] matrix = Q1.randomSquareMatrix(sideLength);
        Q1.printMatrix(matrix);

        // Get largest rows and columns and print them
        ArrayList<Integer> largestRows = Q1.largestRows(matrix);
        ArrayList<Integer> largestColumns = Q1.largestColumns(matrix);

        System.out.print("Largest rows: ");
        for(int i = 0; i < largestRows.size(); i++) {
            System.out.print(largestRows.get(i) + " ");
        }

        System.out.print("Largest columns: ");
        for(int i = 0; i < largestColumns.size(); i++) {
            System.out.print(largestColumns.get(i) + " ");
        }
    }

    public static void sortTest() {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> array = new ArrayList<>();

        // Get digits from user
        System.out.println("Enter a five integers to sort: ");
        for(int i = 0; i < 5; i++) {
            array.add(input.nextInt());
        }

        // Sort and display sorted digits
        Q2.sort(array);
        System.out.println("Sorted array: ");
        for(int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i) + " ");
        }
    }

    public static void unionTest() {
        Scanner input = new Scanner(System.in);

        // Get arrays of integers from user
        System.out.println("Enter five integers for array 1: ");
        ArrayList<Integer> array1 = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            array1.add(input.nextInt());
        }

        System.out.println("Enter five integers for array 2: ");
        ArrayList<Integer> array2 = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            array2.add(input.nextInt());
        }

        // Create and display unioned array
        ArrayList<Integer> unioned = Q3.union(array1, array2);
        System.out.print("Unioned array: ");
        for(int i = 0; i < unioned.size(); i++) {
            System.out.print(unioned.get(i) + " ");
        }
    }

    public static void toCharacterArrayTest() {
        Scanner input = new Scanner(System.in);
        // Get string from user
        System.out.println("Enter a string to convert to a Character array: ");
        ArrayList<Character> array = Q4.toCharacterArray(input.next());
        // Display the string as separate characters from array
        for(int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i) + " ");
        }
    }
}
