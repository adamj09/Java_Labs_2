package lab_6_1;

import java.util.Scanner;
import java.util.ArrayList;

public class Driver {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        while(true){ // Run app (with menu)
            System.out.println("--- Demos ---\n [1] Maximum Value Demo\n [2] Shuffle Values Demo\n "+ 
                "[3] Sum Values Demo\n [4] To Character Array\n [5] exit");
            
            // Get choice of demo from user
            int choice = input.nextInt();
            if (choice > 5 || choice < 1){
                System.out.println("Invalid choice: " + choice + "\nPlease choose a value between 1 and 5.");
                continue;
            }

            switch (choice) {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    toCharacterArrayTest();
                    break;
                default:
                    System.exit(0);
                    break;
            }
        }
    }

    public static void toCharacterArrayTest() {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a string to convert to a Character array: ");
        ArrayList<Character> array = Q4.toCharacterArray(input.next());
        for(int i = 0; i < array.size(); i++) {
            System.out.print(array.get(i) + " ");
        }
    }
}
