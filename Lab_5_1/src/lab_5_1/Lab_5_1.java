package lab_5_1;

import java.util.Scanner;

public class Lab_5_1 {
    public static void main(String[] args) {

        Triangle triangle = new Triangle();


        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <4; i++) {
            System.out.println("Enter length of side " + i + " of the triangle" );
            if (i == 0){
                 triangle.setSide1(scanner.nextDouble());
            }
            else if (i == 1){
                triangle.setSide2(scanner.nextDouble());

            }
            else{
                triangle.setSide3(scanner.nextDouble());

            }
        }
        System.out.println("Colour: ");
        triangle.setColor(scanner.next());

        System.out.println("Filled: ");
        triangle.setFilled(scanner.nextBoolean());


        System.out.println(triangle.toString());
        System.out.println("Area: " + triangle.getArea());
        System.out.println("Perimeter: " + triangle.getPerimeter());
        System.out.println("Color: " + triangle.getColor());
        System.out.println("Filled: " + triangle.isFilled());
        System.out.println("Date Created: " + triangle.getDateCreated());



    }
}
