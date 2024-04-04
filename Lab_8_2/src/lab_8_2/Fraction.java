package lab_8_2;

public class Fraction {
    private final int NUMERATOR, DENOMINATOR;

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
