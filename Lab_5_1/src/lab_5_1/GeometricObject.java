package lab_5_1;

import java.util.Date;

public class GeometricObject {
    private String color;
    private boolean isFilled;
    private Date dateCreated;

    public GeometricObject() {
        dateCreated = new Date();
    }

    public GeometricObject(String color, boolean isFilled) {
        this.color = color;
        this.isFilled = isFilled;
    }

    // --- Getters ---
    public String getColor() {
        return color;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    // --- Setters ---
    public void setColor(String color) {
        this.color = color;
    }

    public void setFilled(boolean isFilled) {
        this.isFilled = isFilled;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String toString() { // print attributes of GeometricObject
        return "Geometric Object: color = " + color + " isFilled = " + isFilled + " dateCreated = " + dateCreated;
    }
}
