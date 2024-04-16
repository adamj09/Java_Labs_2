package lab_9_2;
import java.lang.Cloneable;

import java.util.Scanner;

public class Q2Driver implements Cloneable{
    public static void octagonTest() {
        Scanner userInput = new Scanner(System.in);

        Octagon octagon = new Octagon(5);
        //CLone the octagon object
        Octagon octagonClone = (Octagon)octagon.clone();
        //Compare the two objects
        System.out.println(octagon.compareTo(octagonClone));
    }
}
