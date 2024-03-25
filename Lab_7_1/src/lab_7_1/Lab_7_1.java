package lab_7_1;

import java.util.Scanner;

public class Lab_7_1 {
    public static void main(String[] args) {
        System.out.println(hexToDecimalTest());
    }

    private static int hexToDecimalTest() {
        Scanner scanner =  new Scanner(System.in);
        while(true) {
            System.out.println("Input a hexadecimal number to convert to decimal: ");
            try {
                return HexToDecimal.hexToDecimal(scanner.nextLine());
            }
            catch(NumberFormatException ex) {
                System.out.println(ex);
            }
        }
    }
}
