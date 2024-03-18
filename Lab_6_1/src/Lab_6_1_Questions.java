import java.util.ArrayList;


public class Lab_6_1_Questions {

    public static void sort(ArrayList<Integer> list) {
        for (int i = 0; i < list.size() - 1; i++){
            for (int j = i + 1; j < list.size(); j++) {
                if (list.get(i) > list.get(j)){
                    int temp = list.get(i);
                    list.set(i, list.get(j));
                    list.set(j, temp);
                }
            }
        }

    }
}
