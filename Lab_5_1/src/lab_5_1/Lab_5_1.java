package lab_5_1;

import java.util.Scanner;

public class Lab_5_1 {
    public static void main(String[] args) {
        triangleDemo();
    }

    private static void triangleDemo(){
        Triangle triangle = new Triangle();

        Scanner scanner = new Scanner(System.in);
        // Get length of each side from user
        for (int i = 0; i < 3; i++) {
            System.out.println("Enter length of side " + (i + 1) + " of the triangle" );
            if (i == 0){
                triangle.setSide1(inputDoubleGreaterThanZero());
            }
            else if (i == 1){
                triangle.setSide2(inputDoubleGreaterThanZero());
            }
            else{
                triangle.setSide3(inputDoubleGreaterThanZero());
            }
        }

        // Get triangle's colour
        System.out.println("Colour: ");
        triangle.setColor(scanner.next());

        // Get triangle's fill state
        System.out.println("Filled: ");
        triangle.setFilled(scanner.nextBoolean());

        // Print triangle's attributes
        System.out.println("--- Triangle Info ---");
        System.out.printf("%s\nArea: %.2f\nPerimeter: %.2f\nColor: %s\nFilled: %b\nDate Created: %s\n", 
            triangle.toString(), triangle.getArea(), triangle.getPerimeter(), triangle.getColor(), triangle.isFilled(), triangle.getDateCreated().toString());
    }

    private static double inputDoubleGreaterThanZero(){ // gets input from user that will always be greater than 0
        Scanner scanner = new Scanner(System.in);
        double num = 0;
        do{
            num = scanner.nextDouble();
            if(num <= 0){
                System.out.println("Invalid input! Number must be greater than 0!");
            }
        } while(num <= 0);
        return num;
    }

    private static void polymorphismDemo(){

    }
}
