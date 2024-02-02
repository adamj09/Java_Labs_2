package lab_2_2;

import java.util.Scanner;

public class DemoTownHouse {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TownHouse[] houseArray = new TownHouse[3];
        Address[] addresses = new Address[3];

        // Set up addresses for each house
        for (int i = 0; i < houseArray.length; i++) {
            System.out.println("Enter the address of house #" + (i + 1) + " (civic number, street, city, postal code, province/state, country): ");
            addresses[i] = new Address(input.nextInt(), input.next(), input.next(), input.next(), input.next(), input.next());
        }

        // Tell user what to input and in what order
        System.out.println("Enter the following information in order about house #1: \n- Color\n- Bed Count\n- Washroom Count\n- Floor Count\n- Construction Year\n- Is it a waterfront property?\n- Daily Rent\n- Discount Rate");
        // Create house #1 using no-arg constructor
        houseArray[0] = new TownHouse();
        houseArray[0].setAddress(addresses[0]);
        houseArray[0].setColor(input.next());
        houseArray[0].setBedCount(input.nextInt());
        houseArray[0].setWashroomCount(input.nextInt());
        houseArray[0].setFloorCount(input.nextInt());
        houseArray[0].setConstructionYear(input.nextInt());
        houseArray[0].setIsWaterFront(input.nextBoolean());
        houseArray[0].setDailyRent(input.nextDouble());
        houseArray[0].setDiscountRate(input.nextDouble());

        // Tell user what to input and in what order
        System.out.println("Enter the following information in order about house #2: \n- Color\n- Bed Count\n- Washroom Count\n- Floor Count\n- Construction Year\n- Is it a waterfront property?\n- Daily Rent\n- Discount Rate");
        // Create house #2 using the constructor that takes only first 4 variables as arguments
        houseArray[1] = new TownHouse(
            addresses[1],
            input.next(), // color
            input.nextInt(), // bed count
            input.nextInt() // washroom count
        );
        houseArray[1].setFloorCount(input.nextInt());
        houseArray[1].setConstructionYear(input.nextInt());
        houseArray[1].setIsWaterFront(input.nextBoolean());
        houseArray[1].setDailyRent(input.nextDouble());
        houseArray[1].setDiscountRate(input.nextDouble());

        // Tell user what to input and in what order
        System.out.println("Enter the following information in order about house #3: \n- Color\n- Bed Count\n- Washroom Count\n- Floor Count\n- Construction Year\n- Is it a waterfront property?\n- Daily Rent\n- Discount Rate");
        // Create house #3 using the constructor that takes all variables as arguments
        houseArray[2] = new TownHouse(
            addresses[2],
            input.next(), // color
            input.nextInt(), // bed count
            input.nextInt(), // washroom count
            input.nextInt(), // floor count
            input.nextInt(), // constrution year
            input.nextBoolean(), // isWaterFront
            input.nextDouble(), // daily rent
            input.nextDouble()); // discount rate

        // Print all information about each house
        for (int i = 0; i < houseArray.length; i++) {
            System.out.println("--- House #" + (i + 1) + " ---\n" + houseArray[i].toString());
        }
        
        int cheapestHouse = 0;
        for(int i = 0; i < houseArray.length; i++){
            for(int j = i; j < houseArray.length; j++){
                if(houseArray[j].calcRent() < houseArray[i].calcRent()){
                    cheapestHouse = j;
                }
            }
        }

        System.out.println("The cheapest house is house #" + (cheapestHouse + 1));
    }
}
