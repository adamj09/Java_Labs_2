package lab_8_1;

import java.util.Scanner;

public class BinaryConverter {
    public static void binToDecTest() {
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("Enter a binary value: ");
            try {
                System.out.println("Decimal value: " + binToDec(input.nextLine()));
                break;
            }
            catch(BinaryFormatException ex) { 
                System.out.println(ex);
            }
        }
    }

    public static Integer binToDec(String binaryString) throws BinaryFormatException {
        int decNum = 0;
        for(int i = 0; i < binaryString.length(); i++) {
            try {
                int num = Integer.parseInt(binaryString.charAt((binaryString.length() - 1) - i) + "");
                if(num != 0 && num != 1) {
                    throw new BinaryFormatException(binaryString);
                }
                decNum += (num * Math.pow(2, i));
            }
            catch(NumberFormatException ex) {
                throw new BinaryFormatException(binaryString);
            }
        }
        return decNum;
    }
}
