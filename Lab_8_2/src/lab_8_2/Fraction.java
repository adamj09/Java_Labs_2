package lab_8_2;

import java.util.Scanner;

public class Fraction {
    private final int NUMERATOR, DENOMINATOR;

    public static void fractionTest() {
        Scanner input = new Scanner(System.in);
        while(true) {
            System.out.println("Enter an integer for the numerator and denominator respectively: ");
            try {
                Fraction fraction = new Fraction(input.nextInt(), input.nextInt());
                System.out.println("Fraction is: " + fraction.getNumerator() + " / " + fraction.getDenominator());
                break;
            }
            catch(NullDenominatorException ex) {
                System.err.println(ex);
            }
        }
    }

    Fraction(int numerator, int denominator) throws NullDenominatorException {
        if(denominator == 0) {
            throw new NullDenominatorException(numerator, denominator);
        }
        NUMERATOR = numerator;
        DENOMINATOR = denominator;
    }

    public int getNumerator() {
        return NUMERATOR;
    }

    public int getDenominator() {
        return DENOMINATOR;
    }
}
