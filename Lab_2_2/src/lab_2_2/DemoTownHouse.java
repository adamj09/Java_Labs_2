package lab_2_2;

import java.util.Scanner;

public class DemoTownHouse {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        TownHouse[] houseArray = new TownHouse[3];

        // 1st Constructor
        houseArray[0] = new TownHouse();
        houseArray[0].setAddress(new Address(input.nextInt(), input.next(), input.next(), input.next(), input.next(), input.next()));
        input.next();
        houseArray[0].setBedCount(input.nextInt());
        houseArray[0].setColor(input.next());
        houseArray[0].setConstructionYear(input.nextInt());
        houseArray[0].setDailyRent(input.nextDouble());
        houseArray[0].setDiscountRate(input.nextDouble());

        // 2nd Constructor
        houseArray[1] = new TownHouse(
            new Address(input.nextInt(), input.next(), input.next(), input.next(), input.next(), input.next()),
            input.next(),
            input.nextInt(),
            input.nextInt()
        );
        input.next();

        houseArray[1].setFloorCount(input.nextInt());
        houseArray[1].setConstructionYear(input.nextInt());
        houseArray[1].setIsWaterFront(input.nextBoolean());
        houseArray[1].setDailyRent(input.nextDouble());
        houseArray[1].setDiscountRate(input.nextDouble());

        // 3rd Constructor
        houseArray[2] = new TownHouse(
            new Address(input.nextInt(), input.next(), input.next(), input.next(), input.next(), input.next()),
            input.next(),
            input.nextInt(),
            input.nextInt(),
            input.nextInt(),
            input.nextInt(),
            input.nextBoolean(),
            input.nextDouble(),
            input.nextDouble()
        );

        for(TownHouse townHouse : houseArray){
            System.out.println(townHouse.toString());
        }
    }
}
