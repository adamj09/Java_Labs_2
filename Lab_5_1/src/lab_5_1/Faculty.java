package lab_5_1;

import java.util.Date;

public class Faculty extends Employee{
    // Array of time ranges, (if end and start are same, no office hours for day) 
    // Example: {{start, end} <- monday, {start, end} <- tuesday}
    private int[][] officeHours = new int[5][2]; // default 5 days in schedule, 1 block per day
    private String rank;

    public Faculty() {}

    public Faculty(String name, String address, String phoneNumber, String emailAddress, 
        String office, double salary, Date dateHired, int[][] officeHours, String rank) {
        super(name, address, phoneNumber, emailAddress, office, salary, dateHired); // invoke Employee's all-arg constructor
        // User of class can set whatever schedule they want (1st-dimension: num days in schedule, 2nd dimension: office hour block)
        setOfficeHours(officeHours);
        this.rank = rank;
    }

    // --- Getters ---
    public int[][] getOfficeHours() {
        return officeHours.clone();
    }

    public String getRank() {
        return rank;
    }

    // --- Setters ---
    public void setOfficeHours(int[][] officeHours) {
        for(int i = 0; i < officeHours.length; i++) {
            if(officeHours[i].length % 2 != 0) {
                System.out.println("Warning! Invalid office hours, open ranges cannot be set! No office hours were set as a result.");
                return;
            }
        }
        this.officeHours = officeHours.clone();
    }

    public void setRank(String rank) {
        this.rank = rank;
    }

    public String toString() { // Return Faculty member's info
        String info = "--- Faculty Member ---\n - name = " + this.getName() + 
            "\n - address = " + this.getAddress() + 
            "\n - phoneNumber = " + this.getPhoneNumber() + 
            "\n - emailAddress = " + this.getEmailAddress() +
            "\n - office = " + this.getOffice() +
            "\n - salary = $" + this.getSalary() +
            "\n - dateHired = " + this.getDateHired().toString() +
            "\n - rank = " + this.getRank() + 
            "\n - office hours = {";
        
        // Append office hours to information string
        for(int i = 0; i < officeHours.length; i++) {
            info += "\n\tday " + (i + 1) + " in schedule: { "; // Clarify which day this applies to in schedule

            for(int j = 1; j < officeHours[i].length ; j += 2) { // Increment every block
                if(officeHours[i][j] == officeHours[i][j - 1]) {
                    info += "No Office Hours"; // No office hours if pairs are equal
                    continue;
                }
                // Add office hour block, append comma if this is not last block of day
                info += (officeHours[i][j - 1] + " to " + officeHours[i][j] + (j == officeHours[i].length - 1 ? "": ", "));
            }

            info += " } "; // Closing brackets for day
        }

        return info += "\n   }"; // Append final brace to enclose office hours
    }
}
