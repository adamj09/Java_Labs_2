package lab_5_1;

import java.util.Date;

public class GeometricObject {
    private String color;
    private boolean isFilled;
    private Date dateCreated;

    public GeometricObject(){
        dateCreated = new Date();
    }

    public GeometricObject(String color, boolean isFilled) {
        this.color = color;
        this.isFilled = isFilled;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isFilled() {
        return isFilled;
    }

    public void setFilled(boolean isFilled) {
        this.isFilled = isFilled;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(Date dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String toString(){
        return "Geometric Object: color = " + color + " isFilled = " + isFilled + " dateCreated = " + dateCreated;
    }
}
