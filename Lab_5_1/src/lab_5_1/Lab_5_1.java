package lab_5_1;

import java.util.Date;
import java.util.Scanner;
import userinputhelper.UserInputHelper;

public class Lab_5_1 {
    public static void main(String[] args) {
        while(true){ // Run app (with menu)
            System.out.println("--- Demos ---\n [1] Triangle Demo\n [2] Polymorphism Demo");
            int choice = UserInputHelper.getUserInput("Enter a demo to run, 3 to exit: ", "Invalid input.", 1, 3);
            switch (choice) {
                case 1:
                    triangleDemo();
                    break;
                case 2:
                    polymorphismDemo();
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
    }

    private static void triangleDemo() {
        Scanner scanner = new Scanner(System.in);

        // Get length of each side from user
        double[] sides = new double[3];
        for (int i = 0; i < sides.length; i++) {
            sides[i] = UserInputHelper.getUserInput("Enter length of side " + (i + 1) + " of the triangle", 
                "Side length must be greater than 0!", 0, true);
        }

        System.out.println("Enter the triangle's colour and fill state: "); // remaining attributes
        Triangle triangle = new Triangle(sides[0], sides[1], sides[2], scanner.next(), scanner.nextBoolean()); // create triangle

        // Print triangle's attributes
        System.out.printf("--- Triangle Info ---\n%s\nArea: %.2f\nPerimeter: %.2f\nColor: %s\nFilled: %b\nDate Created: %s\n", 
            triangle.toString(), triangle.getArea(), triangle.getPerimeter(), triangle.getColor(), triangle.isFilled(), triangle.getDateCreated().toString());
    }

    private static void polymorphismDemo() {
        // Create new test person
        Person person = new Person(
            "Adam Johnston", 
            "308 Negra Arroyo Lane, Albuquerque, New Mexico, United States",
            "1 202-456-1111", 
            "djt@gmail.com"
        );

        Student student = new Student(
            "Christopher Laberge",
            "2689 Chemin de Chambly, Longueuil, Quebec, Canada",
            "450 647-3587",
            "realJoeBiden@gmail.com",
            Student.SENIOR
        );

        Employee employee = new Employee(
            "Matthew Cheung",
            "1999 Boulevard Roland-Therrien, Longueuil, Quebec, Canada",
            "448 352-2333",
            "o.sammybinnyladdy@gmail.com",
            "E-649",
            1000000,
            new Date()
        );

        Faculty faculty = new Faculty(
            "Joe Schlon",
            "1228 Boulevard Cure-Poirer Ouest, Longueuil, Quebec, Canada",
            "450 679-6860",
            "schJoe@hotmail.com",
            "E-456",
            98900,
            new Date(),
            new int[][] {{1200, 1300}, {1000, 1100, 1500, 1600}, {0, 0}}, // daily office hours from 12pm to 1pm
            "CEO"
        );

        Staff staff = new Staff(
            "Micheal Ox",
            "7410 Boulevard Taschereau, Brossard, Quebec, Canada",
            "450 923-8067",
            "mox@outlook.com",
            "E-623",
            98901.25,
            new Date(),
            "Chief Money Maker"
        );

        System.out.printf("%s\n%s\n%s\n%s\n%s\n", 
            person.toString(), student.toString(), employee.toString(), faculty.toString(), staff.toString());
    }
}
