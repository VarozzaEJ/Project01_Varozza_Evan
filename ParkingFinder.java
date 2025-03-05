import java.util.Random;
import java.util.Scanner;

import edu.cwi.parking.*;

public class ParkingFinder {
    public static void main(String[] args) {
        Scanner kbdInput = new Scanner(System.in);
        long seed;
        int timeNeededToPark, carX, carY;

        // ParkingSpot Spot1 = new ParkingSpot("1'st Street", 50, 75);
        // System.out.print(Spot1);

        carX = (int) (Math.random() * 99);
        carY = (int) (Math.random() * 99);
        System.out.println("The position of your vehicle is: " + "X: " + carX + " " +  "Y: " + carY);

        System.out.println("Enter a random seed number");
        seed = kbdInput.nextLong();

        System.out.println("How long do you need to park for?");
        timeNeededToPark = kbdInput.nextInt();

        kbdInput.close();
    }
}