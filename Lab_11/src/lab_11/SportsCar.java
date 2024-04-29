package lab_11;

public class SportsCar {
    String model, make, colour;

    SportsCar(String model, String make, String colour) {
        this.model = model;
        this.make = make;
        this.colour = colour;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public String toString() {
        return "Sports Car: {" + model + ", " + make + ", " + colour + "}";
    }
}
