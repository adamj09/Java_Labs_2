package lab_10.Q5;

public class Q5Driver {
    public static void summableTest() {
        // Create some shapes
        GeometricObject[] objects = { // Create some test shapes
            new Circle(5, "White", false),
            new Circle(10, "White", false),
            new Rectangle(16, 14, "White", false),
            new Rectangle(8, 9, "White", false),
            new Triangle(15, 10, 10, "White", false),
            new Triangle(15, 8, 10, "White", false)
        };

        // Display each shape's area and total area
        for(int i = 0; i < objects.length; i++) {
            System.out.printf("Shape %d's area: %.2f\n", (i + 1), objects[i].getArea());
        }
        System.out.printf("Total Area of the shapes: %.2f", sumAreas(objects));
    }

    // This function sums shapes' areas
    public static double sumAreas(GeometricObject[] objects) {
        double totalArea = 0;
        for(int i = 0; i < objects.length; i++) {
            totalArea += ((Summable)objects[i]).sumArea(); // add up areas
        }
        return totalArea;
    }
}
