package lab_5_1;

import java.util.Date;

public class Staff extends Employee{
    String title;

    public Staff() {} // no-arg

    public Staff(String name, String address, String phoneNumber, String emailAddress,
        String office, double salary, Date dateHired, String title) { // all-arg
        super(name, address, phoneNumber, emailAddress, office, salary, dateHired); // invoke employee's all-arg constructor
        this.title = title;
    }

    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String toString(){ // return staff member's name
        return "--- Employee ---\n - name = " + this.getName() + 
            "\n - address = " + this.getAddress() + 
            "\n - phoneNumber = " + this.getPhoneNumber() + 
            "\n - emailAddress = " + this.getEmailAddress() +
            "\n - office = " + this.getOffice() +
            "\n - salary = $" + this.getSalary() +
            "\n - dateHired = " + this.getDateHired().toString() +
            "\n - title = " + title;
    }
}
