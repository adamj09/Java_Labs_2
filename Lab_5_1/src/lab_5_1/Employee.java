package lab_5_1;

import java.util.Date;

public class Employee extends Person {
    private String office;
    private double salary;
    private Date dateHired;

    public Employee() {}

    public Employee(String name, String address, String phoneNumber, String emailAddress, 
        String office, double salary, Date dateHired) {
        super(name, address, phoneNumber, emailAddress); // invoke Person's all-arg constructor
        this.office = office;
        this.salary = salary;
        this.dateHired = dateHired;
    }

    // --- Getters ---
    public String getOffice() {
        return this.office;
    }

    public double getSalary() {
        return this.salary;
    }

    public Date getDateHired() {
        return this.dateHired;
    }

    // --- Setters ---
    public void setOffice(String office) {
        this.office = office;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void setDateHired(Date dateHired) {
        this.dateHired = dateHired;
    }

    public String toString() { // Return Employee's info
        return "--- Employee ---\n - name = " + this.getName() + 
            "\n - address = " + this.getAddress() + 
            "\n - phoneNumber = " + this.getPhoneNumber() + 
            "\n - emailAddress = " + this.getEmailAddress() +
            "\n - office = " + office +
            "\n - salary = $" + salary +
            "\n - dateHired = " + dateHired.toString();
    }
}
