package lab_9_2;

public class Q2Driver {
    public static void octagonTest() {
        // Create a new octagon and display its properties
        Octagon octagon = new Octagon(5);
        System.out.printf("Octagon Properties:\n - Side length: %.2f\n - Area: %.2f\n - Perimeter: %.2f\n",
            octagon.getSide(), octagon.getArea(), octagon.getPerimeter());

        //Clone the octagon object
        Octagon octagonClone = (Octagon)octagon.clone();
        System.out.printf("Octagon cloned!\n Cloned Octagon Properties:\n - Side length: %.2f\n - Area: %.2f\n - Perimeter: %.2f\n",
            octagonClone.getSide(), octagonClone.getArea(), octagonClone.getPerimeter());

        //Compare the two objects
        switch (octagon.compareTo(octagonClone)) {
            case 1:
                System.out.println("The first octagon is larger than the second!");
                break;
            case -1:
                System.out.println("The second octagon is larger than the first!");
                break;
            default:
                System.out.println("Both octagons are the same!");
                break;
        }
    }
}
