package lab_10.Q5;

public class Q5Driver {
    public static void summableTest() {
        // Create some shapes
        GeometricObject[] objects = { 
            new Circle(5, "White", false),
            new Circle(10, "White", false),
            new Rectangle(16, 14, "White", false),
            new Rectangle(8, 9, "White", false),
            new Triangle(15, 10, 10, "White", false),
            new Triangle(15, 8, 10, "White", false)
        };

        // Display total area
        for(int i = 0; i < objects.length; i++) {
            System.out.println("Shape " + (i + 1) + " area: " + objects[i].getArea());
        }
        System.out.println("Total Area of the shapes: " + sumAreas(objects));
    }

    public static double sumAreas(GeometricObject[] objects) {
        double totalArea = 0;
        for(int i = 0; i < objects.length; i++) {
            totalArea += ((Summable)objects[i]).sumArea();
        }
        return totalArea;
    }
}
