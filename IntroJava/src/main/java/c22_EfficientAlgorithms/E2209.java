/*(Geometry: gift-wrapping algorithm for finding a convex hull) Section 22.10.1
introduced the gift-wrapping algorithm for finding a convex hull for a set of
points. Assume Java’s coordinate system is used for the points. Implement the
algorithm using the following method:

* Return the points that form a convex hull
public static ArrayList<Point2D> getConvexHull(double[][] s)
		Point2D is defined in Section 9.6.3.

Write a test program that prompts the user to enter the set size and the points,
and displays the points that form a convex hull. Here is a sample run:

How many points are in the set? 6
Enter 6 points: 1 2.4 2.5 2 1.5 34.5 5.5 6 6 2.4 5.5 9
The convex hull is
(1.5, 34.5) (5.5, 9.0) (6.0, 2.4) (2.5, 2.0) (1.0, 2.4)
*/
package c22_EfficientAlgorithms;

import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class E2209 {
    public static void main(String[] args) {
        System.out.println("How many points are in the set? ");
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        double[][] s = new double[n][2];

        System.out.println("Enter " + n + " points:");
        for (int i = 0; i < n; i++) {
            s[i][0] = input.nextDouble();
            s[i][1] = input.nextDouble();
        }
        ArrayList<Point2D> hullPoints = getConvexHull(s);
        System.out.println("The convex hull is : ");
        for (Point2D point: hullPoints) {
            System.out.print("(" + point.getX() + ", " + point.getY() + ") ");
        }
    }

    public static ArrayList<Point2D> getConvexHull (double[][] s) {
        // turn double[][] into points, then sort on X then Y
        Point2D[] points = new Point2D[s.length];
        for (int i = 0; i < s.length; i++) {
            points[i] = new Point2D(s[i][0], s[i][1]);
        }
        Arrays.sort(points, new Point2DComparatorY());

        // Create an empty list to store convex points, Add the rightmost lowest point to arraylist
        ArrayList<Point2D> hullPoints = new ArrayList<>();
        Point2D p0 = points[points.length - 1];
        hullPoints.add(p0);
        int index = 0;
        // goal reached if p1 is at final point of list
        while (index != points.length -1) {
            Point2D p1 = points[index];
            // if the point is already added, skip the point go to the next!
            if (!hullPoints.contains(p1)){
                // check if all points in the lis are on the left side of line p0_px
                boolean rightPoint = true;
                for (Point2D p2 : points) {
                    if (!atLeft(p0, p1, p2)) {
                        rightPoint = false;
                        break;
                    }
                }
                if (rightPoint) {
                    hullPoints.add(p1);
                    p0 = p1;
                    index = -1;
                }
            }

            index++;
        }

        return hullPoints;
    }

    private static boolean atLeft (Point2D p0, Point2D p1, Point2D p2) {
        return (p1.getX() - p0.getX()) * (p2.getY() - p0.getY()) - (p2.getX() - p0.getX()) * (p1.getY() - p0.getY()) <= 0;
    }
}
