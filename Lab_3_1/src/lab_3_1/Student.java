package lab_3_1;

public class Student {
    private int id;
    private double latestSelfScore, latestProvidedScore;
    private String firstName, lastName, latestCommentsReceived, latestCommentsProvided;

    Student(){}

    Student(int id, String firstName, String lastName, double latestSelfScore, double latestProvidedScore, 
    String latestCommentsReceived, String latestCommentsProvided){
        this.id = id;
        this.latestSelfScore = latestSelfScore;
        this.latestProvidedScore = latestProvidedScore;
        this.firstName = firstName;
        this.lastName = lastName;
        this.latestCommentsReceived = latestCommentsReceived;
        this.latestCommentsProvided = latestCommentsProvided;
    }

    public int getId(){
        return id;
    }

    public double getLatestSelfScore(){
        return latestSelfScore;
    }

    public double getLatestProvidedScore(){
        return latestProvidedScore;
    }

    public String getFirstName(){
        return firstName;
    }

    public String getLastName(){
        return lastName;
    }

    public String getLastestCommentsReceived(){
        return latestCommentsReceived;
    }

    public String getLatestCommentsProvided() {
        return latestCommentsProvided;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setLatestSelfScore(double latestSelfScore){
        this.latestSelfScore = latestSelfScore;
    }

    public void setLatestProvidedScore(double latestProvidedScore){
        this.latestProvidedScore = latestProvidedScore;
    }

    public void setFirstName(String firstName){
        this.firstName = firstName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public void setLatestCommentsReceived(String latestCommentsReceived){
        this.latestCommentsReceived = latestCommentsReceived;
    }

    public void setLatestCommentsProvided(String latestCommentsProvided){
        this.latestCommentsProvided = latestCommentsProvided;
    }

    public String toString(){
        return " Student ID: " + id + "\n Name: " + firstName + " " + lastName + "\n Latest Self-given Score: " + 
            latestSelfScore + "\n Latest Provided Score: " + latestProvidedScore + "\n Latest Comments Received: " + latestCommentsReceived +
            "\n Latest Comments Provided: " + latestCommentsProvided;
    }
}
