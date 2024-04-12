package lab_9_1.Comparison;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

import lab_9_1.Shapes.GeometricObject;

public class CompareShapes {
    public static void compareShapes() {
        Scanner userInput = new Scanner(System.in);

        // Note: This whole method is overly complicated. 
        // Should instead just implement compareTo method
        // in the GeometricObject class then make two GeometricObjects to simplify. 
        // However, lab instructions require the compareTo implementation method 
        // to be in ComparableCircle and ComparableRectangle classes.
        ArrayList<ComparableCircle> circles = new ArrayList<>();
        ArrayList<ComparableRectangle> rectangles = new ArrayList<>();

        // Create shapes
        while(true) {
            try{
                System.out.println("Enter the names of two shapes to compare, separated by a space (ex: circle rectangle): ");
                String[] shapeNames = {userInput.next(), userInput.next()};

                for(int i = 0; i < shapeNames.length; i++) {
                    if(shapeNames[i].toLowerCase().equals("circle")) { // If circle is demanded, create it
                        System.out.println("Enter a radius to create a circle: ");
                        circles.add(new ComparableCircle(userInput.nextDouble(), null, false));
                    }
                    else if(shapeNames[i].toLowerCase().equals("rectangle")) { // If rectangle if demanded, create it
                        System.out.println("Enter two side lengths to create a rectangle: ");
                        rectangles.add(new ComparableRectangle(userInput.nextDouble(), userInput.nextDouble(), "White", false));
                    }
                    else { // Throw error if a circle or rectangle is not input as shape name
                        throw new IllegalArgumentException("Invalid shape name: " + shapeNames[i]);
                    }
                }
                break;
            }
            catch(IllegalArgumentException ex) {
                System.out.println(ex);
            }
            catch(InputMismatchException ex) {
                System.err.println(ex);
            }
        }
        // See note above for the cause of this over-engineered crap, better than making a method for each combo though.
        System.out.println("--- Comparison Results ---");
        ArrayList<GeometricObject> comparedShapes = new ArrayList<>();
        int result;
        if(rectangles.size() == 0) { // If there are no rectangles being compared
            result = circles.get(0).compareTo(circles.get(1));
            comparedShapes.add(circles.get(0));
            comparedShapes.add(circles.get(1));
        }
        else if(circles.size() == 0) { // If there are no circles being compared
            result = rectangles.get(0).compareTo(rectangles.get(1));
            comparedShapes.add(rectangles.get(0));
            comparedShapes.add(rectangles.get(1));
        }
        else { // If a circle and rectangle are being compared
            result = circles.get(0).compareTo(rectangles.get(0));
            comparedShapes.add(circles.get(0));
            comparedShapes.add(rectangles.get(0));
        }
        // Print final results
        if(result == 0) {
            System.out.println("These shapes have the same area!");
            return;
        }
        System.out.printf("%s has a %s area than %s\n", 
            comparedShapes.get(0).toString(), result == 1 ? "greater" : "lesser", comparedShapes.get(1).toString());
    }
}
