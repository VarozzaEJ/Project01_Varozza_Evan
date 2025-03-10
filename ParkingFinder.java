import java.text.NumberFormat;
import java.util.Random;
import java.util.Scanner;

import edu.cwi.parking.*;

public class ParkingFinder {
    public static void main(String[] args) {
        Scanner kbdInput = new Scanner(System.in);
        long seed;
        int timeNeededToPark, distanceOne, distanceTwo, carX, carY, distanceThree, distanceFour, closestSpotDistance;
        double priceOne, priceTwo, priceThree, priceFour;
        String strtOne = "1st Street";
        String strtTwo = "2nd Street";
        String strtThree = "3rd Street";
        String strtFour = "4th Street";
        NumberFormat fmt = NumberFormat.getCurrencyInstance();
        
        System.out.println("Enter a random seed number");
        seed = kbdInput.nextLong();

        Random rand = new Random(seed);
        
        carX = rand.nextInt(100);
        carY = rand.nextInt(100);

        System.out.println("How long (minutes) do you need to park for?");
        timeNeededToPark = kbdInput.nextInt();
        System.out.println();
        System.out.println("The position of your vehicle is: " + "X: " + carX + " " +  "Y: " + carY);

        ParkingSpot spotOne = new ParkingSpot(strtOne,  rand.nextInt(100), rand.nextInt(100));
        ParkingSpot spotTwo = new ParkingSpot(strtTwo, rand.nextInt(100), rand.nextInt(100));
        ParkingSpot spotThree = new ParkingSpot(strtThree, rand.nextInt(100), rand.nextInt(100));
        ParkingSpot spotFour = new ParkingSpot(strtFour, rand.nextInt(100), rand.nextInt(100));
        ParkingSpot closestSpot;
        
        spotThree.setCostPerInterval(0.30);
        spotFour.setCostPerInterval(0.30);
        
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
        
        System.out.println();
        System.out.println("Spot One: " + spotOne);
        System.out.println("    Distance: " + distanceOne);
        System.out.println("    Total Cost: " + fmt.format(priceOne));
        System.out.println();
        System.out.println("Spot Two: " + spotTwo);
        System.out.println("    Distance: " + distanceTwo);
        System.out.println("    Total Cost: " + fmt.format(priceTwo));
        System.out.println();
        System.out.println("Spot Three: " + spotThree);
        System.out.println("    Distance: " + distanceThree);
        System.out.println("    Total Cost: " + fmt.format(priceThree));
        System.out.println();
        System.out.println("Spot Four: " + spotFour);
        System.out.println("    Distance: " + distanceFour);
        System.out.println("    Total Cost: " + fmt.format(priceFour));
        System.out.println();
        System.out.println();
        closestSpotDistance = 0;
        closestSpot = new ParkingSpot("", 1, 1);
        if(distanceOne < distanceTwo && distanceOne < distanceThree && distanceOne < distanceFour){
            closestSpotDistance = distanceOne;
            closestSpot = spotOne;
        }
        if(distanceTwo < distanceOne && distanceTwo < distanceThree && distanceTwo < distanceFour){
            closestSpotDistance = distanceTwo;
            closestSpot = spotTwo;
        }
        if(distanceThree < distanceTwo && distanceThree < distanceOne && distanceThree < distanceFour){
            closestSpotDistance = distanceThree;
            closestSpot = spotThree;
        }
        if(distanceFour < distanceOne && distanceFour < distanceThree && distanceFour < distanceTwo){
            closestSpotDistance = distanceFour;
            closestSpot = spotFour;
        }
        
        System.out.println("Distance to Closest Spot: " + closestSpotDistance);
        System.out.println("Closest Spot: " + closestSpot);

        kbdInput.close();
    }
}