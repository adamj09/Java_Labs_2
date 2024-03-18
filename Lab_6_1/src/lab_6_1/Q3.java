package lab_6_1;

import java.util.ArrayList;

public class Q3 {
    public static ArrayList<Integer> union(ArrayList<Integer> list1, ArrayList<Integer> list2) {
        ArrayList<Integer> union = new ArrayList<>();
        union.addAll(list1);
        union.addAll(list2);
        return union;
    }
}
