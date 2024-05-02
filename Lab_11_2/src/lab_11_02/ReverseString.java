package lab_11_02;

public class ReverseString {
    public static void reverseDisplay(String string) {
        if(string.length() == 0)
            return;
        System.out.print(string.charAt(string.length() - 1));
        reverseDisplay(string.substring(0, string.length() - 1));
    }
}
