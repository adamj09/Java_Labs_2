package lab_1_2;

import java.util.Random;
import java.util.Date;

public class Lab_1_2 {
    public static void main(String[] args) {
        //randomDemo();
        //dateDemo();
    }

    public static void randomDemo(){
        Random random = new Random(1000);

        for(int i = 0; i < 50; i++){
            System.out.println(random.nextInt(100));
        }
    }

    public static void dateDemo(){
        Date date = new Date();

        for(long i = 10000; i <= 100000000000L; i *= 10){
            date.setTime(i);
            System.out.println(date.toString());
        }
    }
}
