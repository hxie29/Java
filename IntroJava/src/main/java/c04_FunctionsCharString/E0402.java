package c04_FunctionsCharString;

import java.util.Scanner;

public class E0402 {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);

        // enter two points on earth;
        System.out.println("Enter point 1 (latitude and longitude) in degrees: ");
        double x1 = Math.toRadians(input.nextDouble());
        double y1 = Math.toRadians(input.nextDouble());
        System.out.println("Enter point 2 (latitude and longitude) in degrees: ");
        double x2 = Math.toRadians(input.nextDouble());
        double y2 = Math.toRadians(input.nextDouble());

        final double RADEARTH = 6371.01;

        double d = RADEARTH * Math.acos( (Math.sin(x1) * Math.sin(x2) + Math.cos(x1) * Math.cos(x2) * Math.cos(y1 - y2)) );
        System.out.println("The distance between the two points is " + (int)(d * 100)/100.0 + " km.");
        input.close();
    }    
}
