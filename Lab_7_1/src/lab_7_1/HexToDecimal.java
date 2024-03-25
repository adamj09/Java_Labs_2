package lab_7_1;

public class HexToDecimal {
    public static int hexToDecimal(String hex) {
        int decimalValue = 0;
        for(int i = 0; i < hex.length(); i++) {
            decimalValue = decimalValue * 16 + hexCharToDecimal(Character.toUpperCase(hex.charAt(i)));
        }
        return decimalValue;
    }

    private static int hexCharToDecimal(char ch) throws NumberFormatException  {
        if(ch >= 'A' && ch <= 'F') {
            return 10 + ch - 'A';
        }
        else if(ch >= '0' && ch <= '9') {
            return ch - '0';
        }
        else {
            throw new NumberFormatException();
        }
    }
}
