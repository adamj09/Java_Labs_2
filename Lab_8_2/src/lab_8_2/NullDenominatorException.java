package lab_8_2;

public class NullDenominatorException extends Exception {

    NullDenominatorException(int numerator, int denominator) {
        super("Invalid fraction: " + numerator + " / " + denominator);
    }
}
