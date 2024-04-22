package lab_10.Q3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Q3Driver {
    public static void urlTest() {
        String url = "http://liveexample.pearsoncmg.com/data/Scores.txt";
        String content = ReadFromURL.read(url);
        
        int sum = 0, count = 0;
        Scanner input = new Scanner(content);
        while(input.hasNext()) {
            try {
                sum += input.nextInt();
                count++;
            }
            catch(InputMismatchException ex) {}
        }
        System.out.println("URL: " + url + "\nTotal of values: " + sum + " Average of values: " + sum / (double)count);
        input.close();
    }
}
