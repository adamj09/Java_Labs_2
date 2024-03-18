import java.util.Scanner;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(true){ // Run app (with menu)
            System.out.println("--- Demos ---\n [1] Most 1s\n [2] Sort Array list\n "+
                    "[3] Combining two lists\n [4] Arraylist to character\n [5] exit");

            // Get choice of demo from user
            int choice = input.nextInt();
            if (choice > 5 || choice < 1){
                System.out.println("Invalid choice: " + choice + "\nPlease choose a value between 1 and 5.");
                continue;
            }

            switch (choice) {
                case 1:
                    most1sTest();
                    break;
                case 2:
                    arraySortingTest();
                    break;
                case 3:
                    combiningTwoArraysTest();
                    break;
                case 4:
                    stringToCharArrayTest();
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
    }

    public static void most1sTest() { // Get numbers from user then find and display max of input numbers

    }

    public static void arraySortingTest() { // Get numbers from user then shuffle and display shuffled numbers
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter 5 numbers");
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = 0; i < 5; i++) {
            numbers.add(scanner.nextInt());
        }
        Lab_6_1_Questions.sort(numbers);
        for (Integer number : numbers) {
            System.out.print(number + " ");

        }
        System.out.println();
    }

    public static void combiningTwoArraysTest() { // Get numbers from user then sum and display that sum

    }

    public static void stringToCharArrayTest(){ // Get numbers from user, remove duplicate values, then display unique values

    }
}