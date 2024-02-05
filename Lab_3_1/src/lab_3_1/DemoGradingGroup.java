package lab_3_1;

import java.util.Date;
import java.util.Scanner;

public class DemoGradingGroup {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        GradingGroup[] gradingGroups = new GradingGroup[2];
        Student[] students = new Student[4];

        // Create Students
        for(int i = 0; i < gradingGroups.length; i++){
            String[] commentsReceived = new String[2];
            double[] scoresReceived = new double[2];

            // Create Students
            for(int j = 0; j < 2; j++){
                System.out.println("Enter the following information about student " + (j + 1) + " from group " + (i + 1) +
                    ":\n- Latest Received Score\n- Latest Comments Received\n- Student ID\n- First Name\n- Last Name");
                
                scoresReceived[j] = input.nextDouble();
                commentsReceived[j] = input.next();

                students[j + i] = new Student(input.nextInt(), input.next(), input.next(), 
                    scoresReceived[j], 0, commentsReceived[j], "");
            }

            // Set provided scores for students
            students[i].setLatestProvidedScore(scoresReceived[1]);
            students[i + 1].setLatestProvidedScore(scoresReceived[0]);
            students[i].setLatestCommentsProvided(commentsReceived[1]);
            students[i + 1].setLatestCommentsProvided(commentsReceived[0]);

            // Create grading groups
            if(i == 0){
                System.out.println("Enter the lab number for group " + (i + 1));
                gradingGroups[i] = new GradingGroup();
                gradingGroups[i].student1 = students[0];
                gradingGroups[i].student2 = students[1];
                gradingGroups[i].evaluationDate = new Date();
                gradingGroups[i].labNum = input.nextInt();
            }
            else {
                System.out.println("Enter the lab number for group " + (i + 1));
                gradingGroups[i] = new GradingGroup(students[2], students[3], new Date(), input.nextDouble());
            }
            System.out.printf("--- Grading Group %d ---\n", i + 1);
            System.out.println(gradingGroups[i].toString()); // print info about grading groups
        }

        
    }
}
