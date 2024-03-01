package lab_5_1;

public class Person {
    private String name, address, phoneNumber, emailAddress;

    public Person() {} // no-arg

    public Person(String name, String address, String phoneNumber, String emailAddress) { // all-arg
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
    }
    
    // --- Getters ---
    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    // --- Setters ---
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String toString() { // Return all info
        return "--- Person ---\n - name = " + name + 
            "\n - address = " + address + 
            "\n - phoneNumber = " + phoneNumber + 
            "\n - emailAddress = " + emailAddress;
    }
}
