package lab_10.Q1;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class AdditionQuiz implements Calculable {
    private int num1, num2, min, max;
    private ArrayList<Integer> previousAnswers = new ArrayList<>();

    public AdditionQuiz(int min, int max) {
        setRange(min, max);
    }

    // Set a range of possible values given in quiz (exclusive)
    public void setRange(int min, int max) throws IllegalArgumentException {
        if(min > max) {
            throw new IllegalArgumentException("high cannot be lesser than low.");
        }
        this.min = min;
        this.max = max;
    }

    private void setValues() {
        Random rand = new Random();
        this.num1 = rand.nextInt(max - min) + min;
        this.num2 = rand.nextInt(max - min) + min;
    }

    public void run() {
        Scanner input = new Scanner(System.in);
        System.out.println("Welcome to a basic addition quiz! Enter integers as your answers. Type \"exit\" to quit.");
        while(true) {
            setValues();
            while(true) {
                System.out.println("What is " + num1 + " + " + num2 + "?");
                String answer = input.next();
                if(answer.equals((int)getResult() + "")) { // Correct answer, go to next question
                    System.out.println("Correct!"); 
                    break;
                }
                else if(answer.toLowerCase().equals("exit")) { // Exit the quiz
                    System.out.println("Exiting...");
                    return;
                }

                try {
                    if(previousAnswers.contains(Integer.parseInt(answer))) { // Check if answer already entered to notify user
                        System.out.println("Incorrect. You've already entered " + answer);
                        continue; // Try this question again
                    }
                }
                catch(NumberFormatException ex) { // Notify user decimal values are not accepted
                    System.out.println("Enter an integer as your answer!");
                    continue;
                }
                // Add previous (incorrect) answer to list and notify user it's incorrect
                previousAnswers.add(Integer.parseInt(answer)); 
                System.out.println("Incorrect. Please try again.");
            }
        }
    }

    public double getResult() {
        return num1 + num2;
    }
}
