import java.util.Random;
import java.util.Scanner;

import edu.cwi.parking.*;

public class ParkingFinder {
    public static void main(String[] args) {
        Scanner kbdInput = new Scanner(System.in);
        long seed;
        int timeNeededToPark, carX, carY, distanceOne, distanceTwo, distanceThree, distanceFour;
        double priceOne, priceTwo, priceThree, priceFour;
        double random = Math.random() * 99;
        double randomTwo = Math.random() * 99;
        double randomThree = Math.random() * 99;
        double randomFour = Math.random() * 99;
        double randomFive = Math.random() * 99;
        double randomSix = Math.random() * 99;
        double randomSeven = Math.random() * 99;
        double randomEight = Math.random() * 99;
        String strtOne = "1st Street";
        String strtTwo = "2nd Street";
        String strtThree = "3rd Street";
        String strtFour = "4th Street";
        

        carX = (int) (Math.random() * 99);
        carY = (int) (Math.random() * 99);
        System.out.println("The position of your vehicle is: " + "X: " + carX + " " +  "Y: " + carY);

        System.out.println("Enter a random seed number");
        seed = kbdInput.nextLong();

        System.out.println("How long do you need to park for?");
        timeNeededToPark = kbdInput.nextInt();

        ParkingSpot spotOne = new ParkingSpot(strtOne, (int) random, (int) randomTwo);
        ParkingSpot spotTwo = new ParkingSpot(strtTwo, (int) randomThree, (int) randomFour);
        ParkingSpot spotThree = new ParkingSpot(strtThree, (int) randomFive, (int) randomSix);
        ParkingSpot spotFour = new ParkingSpot(strtFour, (int) randomSeven, (int) randomEight);

        spotThree.setCostPerInterval(0.30);
        spotFour.setCostPerInterval(0.30);

        System.out.println(carX + " " + carY);
        System.out.println("");
        
        distanceOne = (Math.abs((spotOne.getLocationX() - carX)) + Math.abs((spotOne.getLocationY() - carY)));
        distanceTwo = (Math.abs((spotTwo.getLocationX() - carX)) + Math.abs((spotTwo.getLocationY() - carY)));
        distanceThree = (Math.abs((spotThree.getLocationX() - carX)) + Math.abs((spotThree.getLocationY() - carY)));
        distanceFour = (Math.abs((spotFour.getLocationX() - carX)) + Math.abs((spotFour.getLocationY() - carY)));
        
        if(timeNeededToPark % 10 != 0) {
            timeNeededToPark = (timeNeededToPark / 10) * 10 + 10; 
        }
        
        priceOne = ((timeNeededToPark / 10) * spotOne.getCostPerInterval());
        priceTwo = ((timeNeededToPark / 10) * spotTwo.getCostPerInterval());
        priceThree = ((timeNeededToPark / 10) * spotThree.getCostPerInterval());
        priceFour = ((timeNeededToPark / 10) * spotFour.getCostPerInterval());

        System.out.println(" ");
        System.out.println("Spot One: " + spotOne);
        System.out.println("    Distance: " + distanceOne);
        System.out.println("    Total Cost: " + priceOne);
        System.out.println("Spot Two: " + spotTwo);
        System.out.println("    Distance: " + distanceTwo);
        System.out.println("    Total Cost: " + priceTwo);
        System.out.println("Spot Three: " + spotThree);
        System.out.println("    Distance: " + distanceThree);
        System.out.println("    Total Cost: " + priceThree);
        System.out.println("Spot Four: " + spotFour);
        System.out.println("    Distance: " + distanceFour);
        System.out.println("    Total Cost: " + priceFour);

        kbdInput.close();
    }
}