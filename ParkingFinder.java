import java.util.Random;
import java.util.Scanner;

import edu.cwi.parking.*;

public class ParkingFinder {
    public static void main(String[] args) {
        Scanner kbdInput = new Scanner(System.in);
        long seed;
        int timeNeededToPark, carX, carY, distanceOne, distanceTwo, distanceThree, distanceFour;
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
        System.out.println(spotOne);
        System.out.println(spotTwo);
        System.out.println(spotThree);
        System.out.println(spotFour);

        distanceOne = (Math.abs((spotOne.getLocationX() - carX)) + Math.abs((spotOne.getLocationY() - carY)));
        distanceTwo = (Math.abs((spotTwo.getLocationX() - carX)) + Math.abs((spotTwo.getLocationY() - carY)));
        distanceThree = (Math.abs((spotThree.getLocationX() - carX)) + Math.abs((spotThree.getLocationY() - carY)));
        distanceFour = (Math.abs((spotFour.getLocationX() - carX)) + Math.abs((spotFour.getLocationY() - carY)));

        System.out.println(distanceOne);
        kbdInput.close();
    }
}