package Lab_5_2.src.lab_5_2;

import java.util.ArrayList;


public class Questions {
    // Question 1
    public static Integer max(ArrayList<Integer> list) {
        // Return null if list is null or empty
        if (list.size() == 0 || list == null) {
            return null;
        }

        // Get max value
        int max = list.get(0);
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) > max) {
                max = list.get(i);
            }
        }
        return max;
    }

    // Question 2
    public static void shuffle(ArrayList<Integer> list) {
        // Skip shuffling if array cannot be shuffled
        if (list.size() == 0 || list.size() == 1 || list == null) {
            return;
        }

        for (int i = 0; i < list.size(); i++) {
            // Pick random index within list range
            int randIndex = (int) (Math.random() * list.size() - 1);
            // Swap element at i with element at randIndex
            int temp = list.get(randIndex);
            list.set(randIndex, list.get(i));
            list.set(i, temp);
        }
    }

    // Question 3
    public static double sum(ArrayList<Double> list) {
        // Skip sum if list is does not exist or has no values
        if (list.size() == 0 || list == null) {
            return 0;
        }
        // Sum elements
        double sum = 0;
        for (double number : list) {
            sum += number;
        }

        return sum;
    }

    // Question 4

    public static void removeDuplicates(ArrayList<Integer> list) {
        // Skip method if list has one element, does not exist, or has no values
        if (list.size() <= 1 || list == null) {
            return;
        }
        ArrayList<Integer> uniqueList = new ArrayList<>();

        for (Integer num : list) {
            // If the unique list does not contain the current element, add it to the unique list
            if (!uniqueList.contains(num)) {
                uniqueList.add(num);
            }
        }
        // Clear the original list and add unique elements back to it
        list.clear();
        list.addAll(uniqueList);
    }
}
