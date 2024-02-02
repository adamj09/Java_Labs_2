package lab_2_2;

public class TownHouse {
    private Address address;

    private String color;
    private int bedCount, washroomCount, floorCount, constructionYear;
    boolean isWaterFront;
    double dailyRent, discountRate; // discount rate is in percent

    // No-arg constructor: creates empty TownHouse object
    TownHouse(){
        address = new Address();
    }

    // Constructor taking only first 4 variables
    TownHouse(Address address, String color, int bedCount, int washroomCount){
        this.address = address;
        this.color = color;
        this.bedCount = bedCount;
        this.washroomCount = washroomCount;
    }

    // Constructor taking all variables
    TownHouse(Address address, String color, int bedCount, int washroomCount, int floorCount, 
        int constructionYear, boolean isWaterFront, double dailyRent, double discountRate){
        this(address, color, bedCount, washroomCount);
        this.floorCount = floorCount;
        this.constructionYear = constructionYear;
        this.isWaterFront = isWaterFront;
        this.dailyRent = dailyRent;
        this.discountRate = discountRate;
    }

    // --- Getters ---
    public Address getAddress(){
        return address;
    }

    public String getColor(){
        return color;
    }

    public int getBedCount(){
        return bedCount;
    }

    public int getWashroomCount(){
        return washroomCount;
    }

    public int getFloorCount(){
        return floorCount;
    }

    public int getConstructionYear(){
        return constructionYear;
    }

    public boolean getIsWaterFront(){
        return isWaterFront;
    }

    public double getDailyRent(){
        return dailyRent;
    }

    public double getDiscountRate(){
        return discountRate;
    }

    // --- Setters ----
    public void setAddress(Address address){
        this.address = address;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setBedCount(int bedCount){
        this.bedCount = bedCount;
    }

    public void setWashroomCount(int washroomCount){
        this.washroomCount = washroomCount;
    }

    public void setFloorCount(int floorCount){
        this.floorCount = floorCount;
    }

    public void setConstructionYear(int constructionYear){
        this.constructionYear = constructionYear;
    }

    public void setIsWaterFront(boolean isWaterFront){
        this.isWaterFront = isWaterFront;
    }

    public void setDailyRent(double dailyRent){
        this.dailyRent = dailyRent;
    }
    
    public void setDiscountRate(double discountRate){
        this.discountRate = discountRate;
    }

    // --- Other Functions ---
    public double calcRent(){
        return dailyRent - (dailyRent * (discountRate / 100)); // total rent taking into account discount rate
    }

    public String toString(){ // put all information about TownHouse into one readable string
        return address.toString() + "\n- Color: " + color + "\n- Bed count: " + bedCount + "\n- Washroom count: " + washroomCount + 
            "\n- Floor count: " + floorCount + "\n- Construction year: " + constructionYear + "\n- Is water front?: " + isWaterFront +
            "\n- Daily rent: $" + dailyRent + "\n- Discount rate: " + discountRate + "%\n- Rent including discount: $" + calcRent();
    }
}

class Address {
    public int civicNum;
    public String street, city, postalCode, province, country;

    Address(){}

    Address(int civicNum, String street, String city, String postalCode, String province, String country){
        this.civicNum = civicNum;
        this.street = street;
        this.city = city;
        this.postalCode = postalCode;
        this.province = province;
        this.country = country;
    }

    public String toString(){ // put all information about Address into one readable string
        return "Address: " + civicNum + " " + street + ", " + city + ", " + postalCode + ", " + province + ", " + country;
    }
}

