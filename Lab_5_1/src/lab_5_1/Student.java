package lab_5_1;

public class Student extends Person {
    public static final int FRESHMAN = 0, SOPHOMORE = 1, JUNIOR = 2, SENIOR = 3;
    private int status = FRESHMAN;

    public Student() {} // no-arg

    public Student(String name, String address, String phoneNumber, String emailAddress, int status) { // all-arg
        super(name, address, phoneNumber, emailAddress);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String toString() { // return Student's info
        String[] statuses = { "Freshman", "Sophomore", "Junior", "Senior"};
        return "--- Student ---\n - name = " + this.getName() + 
            "\n - address = " + this.getAddress() + 
            "\n - phoneNumber = " + this.getPhoneNumber() + 
            "\n - emailAddress = " + this.getEmailAddress() +
            "\n - status = " + statuses[status];
    }
}
