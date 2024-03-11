package lab_5_2;

import java.util.ArrayList;

public class Lab_5_2 {
    public static void main(String[] args) {

    }

    public static Integer max(ArrayList<Integer> list) {
        // Return null if list is null or empty
        if(list.size() == 0 || list == null) {
            return null;
        }

        // Get max value
        int max = list.get(0);
        for(int i = 0; i < list.size(); i++) {
            if(list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;
    }
}
