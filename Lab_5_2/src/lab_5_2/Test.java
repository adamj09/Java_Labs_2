package lab_5_2;

import java.util.Scanner;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(true){ // Run app (with menu)
            System.out.println("--- Demos ---\n [1] Maximum Value Demo\n [2] Shuffle Values Demo\n "+ 
                "[3] Sum Values Demo\n [4] Remove Duplicate Values Demo\n [5] exit");
            
            // Get choice of demo from user
            int choice = input.nextInt();
            if (choice > 5 || choice < 1){
                System.out.println("Invalid choice: " + choice + "\nPlease choose a value between 1 and 5.");
                continue;
            }

            switch (choice) {
                case 1:
                    maxTest();
                    break;
                case 2:
                    shuffleTest();
                    break;
                case 3:
                    sumTest();
                    break;
                case 4:
                    removeDuplicatesTest();
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
    }

    public static void maxTest() { // Get numbers from user then find and display max of input numbers
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter some numbers to find the max value, input ends with 0: ");
        ArrayList<Integer> numbers = new ArrayList<>();
        int value;
        do {
            value = scanner.nextInt();
            numbers.add(value);
        } while(value != 0);

        System.out.println("Max value: " + Questions.max(numbers));
    }

    public static void shuffleTest() { // Get numbers from user then shuffle and display shuffled numbers
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ten numbers: ");
        for(int i = 0; i < 10; i++) {
            int number = scanner.nextInt();
            numbers.add(number);
        }

        Questions.shuffle(numbers);
        
        System.out.print("Shuffled numbers: ");
        for(int i : numbers) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    public static void sumTest() { // Get numbers from user then sum and display that sum
        ArrayList<Double> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter five numbers: ");
        for(int i = 0; i < 5; i++) {
            double number = scanner.nextDouble();
            numbers.add(number);
        }
        System.out.println("Sum of the numbers: " + Questions.sum(numbers));
    }

    public static void removeDuplicatesTest(){ // Get numbers from user, remove duplicate values, then display unique values
        ArrayList<Integer> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter ten numbers: ");
        for(int i = 0; i < 10; i++) {
            int number = scanner.nextInt();
            numbers.add(number);
        }

        Questions.removeDuplicates(numbers);
        
        System.out.print("Unique numbers: ");
        for(int i : numbers) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}
