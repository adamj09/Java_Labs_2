package lab_5_1;

import java.util.Date;
import java.util.Scanner;

public class Lab_5_1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while(true){ // Run app (with menu)

            System.out.println("--- Demos ---\n [1] Triangle Demo\n [2] Polymorphism Demo\n [3] exit");
            // Get choice of demo from user
            //
            //
            // int choice = UserInputHelper.getUserInput("Enter a demo to run, 3 to exit: ", "Invalid input.", 1, 3);
            int choice = input.nextInt();
            if (choice > 3 || choice < 1){
                System.out.println("Invalid choice: " + choice);
                continue;
            }
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
            System.out.println("Enter length of side " + (i + 1) + " of the triangle" );
            double sidelength = scanner.nextDouble();
            if (sidelength <= 0){
            System.out.println("Sidelength must be greater than 0");
            i--;
            continue;
            }
            sides[i] = sidelength;
        }
        if (isValidTriangle(sides[0], sides[1], sides[2]) == false){
            System.out.println("Invalid triangle");
            triangleDemo();

        }
        else {
            System.out.println("Enter the triangle's colour and fill state: "); // remaining attributes
            Triangle triangle = new Triangle(sides[0], sides[1], sides[2], scanner.next(), scanner.nextBoolean()); // create triangle

            // Print triangle's attributes
            System.out.printf("--- Triangle Info ---\n%s\nArea: %.2f\nPerimeter: %.2f\nColor: %s\nFilled: %b\nDate Created: %s\n",
                    triangle.toString(), triangle.getArea(), triangle.getPerimeter(), triangle.getColor(), triangle.isFilled(), triangle.getDateCreated().toString());
        }
    }

    private static void polymorphismDemo() {
        // Create new test person
        Person person = new Person(
            "Adam Johnston", 
            "308 Negra Arroyo Lane, Albuquerque, New Mexico, United States",
            "1 202-456-1111", 
            "djt@gmail.com"
        );
        // Create new test person
        Student student = new Student(
            "Christopher Laberge",
            "2689 Chemin de Chambly, Longueuil, Quebec, Canada",
            "450 647-3587",
            "realJoeBiden@gmail.com",
            Student.SENIOR
        );
        // Create new test person
        Employee employee = new Employee(
            "Matthew Cheung",
            "1999 Boulevard Roland-Therrien, Longueuil, Quebec, Canada",
            "448 352-2333",
            "o.sammybinnyladdy@gmail.com",
            "E-649",
            1000000,
            new Date()
        );
        // Create new test person
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
        // Create new test person
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
        // Print all test objects' toString methods
        System.out.printf("%s\n%s\n%s\n%s\n%s\n", 
            person.toString(), student.toString(), employee.toString(), faculty.toString(), staff.toString());
    }

    public static boolean isValidTriangle(double side1, double side2, double side3) {
        return side1 + side2 > side3 && side1 + side3 > side2 && side2 + side3 > side1;
    }
}
