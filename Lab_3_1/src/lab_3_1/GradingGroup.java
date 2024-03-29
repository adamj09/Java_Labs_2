package lab_3_1;

import java.util.Date;

public class GradingGroup {
    private Student student1, student2;
    private Date evaluationDate;
    private double labNum;

    GradingGroup(){
        this(new Student(), new Student(), new Date(), 0);
    }

    GradingGroup(Student student1, Student student2, Date evalutationDate, double labNum){
        this.student1 = student1;
        this.student2 = student2;
        this.evaluationDate = evalutationDate;
        this.labNum = labNum;
    }

    // Getters
    public Student getStudent1(){
        return student1;
    }

    public Student getStudent2(){
        return student2;
    }

    public Date getEvaluationDate(){
        return evaluationDate;
    }

    public double getLabNum(){
        return labNum;
    }

    // Setters
    public void setStudent1(Student student1){
        this.student1 = student1;
    }

    public void setStudent2(Student student2){
        this.student2 = student2;
    }

    public void setEvaluationDate(Date evaluationDate){
        this.evaluationDate = evaluationDate;
    }

    public void setLabNum(double labNum){
        this.labNum = labNum;
    }

    public String toString(){ // Return a string with class info
        return " Lab Number: " + labNum + "\n Evaluation Date: " + evaluationDate +
            "\n--- Student 1 ---\n" + student1.toString() + "\n--- Student 2 ---\n" + student2.toString(); 
    }
}