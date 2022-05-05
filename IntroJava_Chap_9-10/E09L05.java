/* You can create a Point2D object for a point with the specified x- and y-coordinates, use
the distance method to compute the distance from this point to another point, and use the
toString() method to return a string representation of the point. Listing 9.5 gives an example
of using this class. */

import java.util.Random;
import java.util.Scanner;
import java.awt.geom.Point2D;
public class E09L05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Enter point 1's x, y coordinates:");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        System.out.println("Enter point 2's x, y coordinates:");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();

        Point2D p1 = new Point2D.Double(x1, y1);
        Point2D p2 = new Point2D.Double(x2, y2);

        System.out.println("point 1 is " + p1.toString());
        System.out.println("point 2 is " + p2.toString());
        System.out.println("The distance between point 1 and 2 is " + p1.distance(p2));

/* You have used Math.random() to obtain a random double value between 0.0 and 1.0
(excluding 1.0). Another way to generate random numbers is to use the java.util.Random
class, as shown in Figure 9.11, which can generate a random int, long, double, float, and
boolean value. */
        Random generator1 = new Random();
        System.out.println("From generator 1 (seed is current time):");
        for (int i =0; i < 10; i++) {
            System.out.println(generator1.nextInt(1000) + " ");
        }

        Random generator2 = new Random(3);
        System.out.println("From generator 2 (seed 3):");
        for (int i =0; i < 10; i++) {
            System.out.println(generator2.nextInt(1000) + " ");
        }

        Random generator3 = new Random(3);
        System.out.println("From generator 3 (seed 3):");
        for (int i =0; i < 10; i++) {
            System.out.println(generator3.nextInt(1000) + " ");
        }
    }
}
