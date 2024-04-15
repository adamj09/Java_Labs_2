package src.lab_9_2;
import java.lang.Cloneable;

import java.util.Scanner;
import java.util.InputMismatchException;

public class Q2Driver implements Cloneable{
    private static void colorableTest() {
        //and Cloneable. Write a test program that creates an Octagon object with side
//value 5 and displays its area and perimeter. Create a new object using the clone
//method, and compare the two objects using the compareTo method.
        Scanner userInput = new Scanner(System.in);
        Octagon octagon = new Octagon(5);
        //CLone the octagon object
        Octagon octagonClone = (Octagon)octagon.clone();
        //Compare the two objects
        System.out.println(octagon.compareTo(octagonClone));




    }
}
