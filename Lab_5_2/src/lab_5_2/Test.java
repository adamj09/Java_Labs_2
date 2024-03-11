package lab_5_2;

import java.util.Scanner;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) {

    }

    public static void maxTest() {

    }

    public static void sumTest() {
        ArrayList<Double> numbers = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter five numbers: ");
        for(int i = 0; i < 5; i++) {
            double number = scanner.nextDouble();
            numbers.add(number);
        }
        System.out.println("Sum of the numbers: " + Questions.sum(numbers));
    }
}
