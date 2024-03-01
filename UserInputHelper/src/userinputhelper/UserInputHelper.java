package userinputhelper;

import java.util.Scanner;

/* A simple helper class designed to reduce clutter in driver classes that take in user
input from the terminal. Currently there are only a few basic methods that may be
altered in the future as seen fit. Generic types for these methods were not used as this 
was not yet introduced in the course this class is used for, but are probably preferable 
over the current implementation. On that same note, this should also be a proper library,
and should have error handling, but those topics have also not yet been introduced. */
public class UserInputHelper {
    // Get a double from user within a specified range (inclusive)
    public static double getUserInput(String prompt, String error, double startInclusive, double endInclusive) {
        Scanner scanner = new Scanner(System.in);
        double num;
        do{
            System.out.println(prompt);
            num = scanner.nextDouble();
            if(num < startInclusive || num > endInclusive){
                System.out.println(error);
            }
        } while(num < startInclusive || num > endInclusive);
        return num;
    }

    // Get a double from user that is greater than or less than a critical value
    public static double getUserInput(String prompt, String error, double criticalValue, boolean isMinInclusive) { 
        Scanner scanner = new Scanner(System.in);
        double num;
        do{
            System.out.println(prompt);
            num = scanner.nextDouble();
            if(isMinInclusive ? num <= criticalValue : num >= criticalValue){
                System.out.println(error);
            }
        } while(isMinInclusive ? num <= criticalValue : num >= criticalValue);

        return num;
    }

    // Get an integer from user within a specified range (inclusive)
    public static int getUserInput(String prompt, String error, int startInclusive, int endInclusive) {
        Scanner scanner = new Scanner(System.in);
        int num;
        do{
            System.out.println(prompt);
            num = scanner.nextInt();
            if(num < startInclusive || num > endInclusive){
                System.out.println(error);
            }
        } while(num < startInclusive || num > endInclusive);
        return num;
    }

    // Get an integer from user that is greater than or less than a critical value (inclusive)
    public static int getUserInput(String prompt, String error, int criticalValue, boolean isMinInclusive) {
        Scanner scanner = new Scanner(System.in);
        int num;
        do{
            System.out.println(prompt);
            num = scanner.nextInt();
            if(isMinInclusive ? num <= criticalValue : num >= criticalValue){
                System.out.println(error);
            }
        } while(isMinInclusive ? num <= criticalValue : num >= criticalValue);

        return num;
    }
}
