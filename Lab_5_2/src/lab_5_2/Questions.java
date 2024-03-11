package lab_5_2;

import java.util.ArrayList;

public class Questions {
    // Question 1
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

    // Question 2
    public static void shuffle(ArrayList<Integer> list) {
        // Skip shuffling if array cannot be shuffled
        if(list.size() == 0 || list.size() == 1 || list == null) {
            return;
        }

        for(int i = 0; i < list.size(); i++){
            int randIndex = (int)(Math.random() * list.size() - 1);
            int temp = list.get(randIndex);
            list.set(randIndex, list.get(i));
            list.set(i, temp);
        }
    }

    // Question 3
    public static double sum(ArrayList<Double> list){
        if(list.size() == 0 || list == null) {
            return 0;
        }

        double sum = 0;
        for(double number : list) {
            sum += number;
        }

        return sum;
    }

    // Question 4
    public static void removeDuplicates(ArrayList<Integer> list) {
        if(list.size() == 0 || list.size() == 1 || list == null) {
            return;
        }
        
        for(int i = 0; i < list.size(); i++) {
            for(int j = 0; j < list.size(); j++){
                if(list.get(i) == list.get(j)) {
                    list.remove(j);
                }
            }
        }
    }
}
