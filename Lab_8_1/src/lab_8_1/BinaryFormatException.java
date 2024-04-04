package lab_8_1;

public class BinaryFormatException extends Exception{
    String faultyString;

    BinaryFormatException(String faultyString) {
        super("Invalid binary string: " + faultyString);
        this.faultyString = faultyString;
    }
}
