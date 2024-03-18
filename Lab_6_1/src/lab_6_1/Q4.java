package lab_6_1;

import java.util.ArrayList;

public class Q4 {
    public static ArrayList<Character> toCharArray(String string) {
        ArrayList<Character> array = new ArrayList<>();
        for(int i = 0; i < string.length(); i++) {
            array.add(string.charAt(i));
        }
        return array;
    }
}
