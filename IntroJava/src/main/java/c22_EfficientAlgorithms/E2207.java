/* Closest pair of points: Section 22.8 introduced an algorithm for finding the
closest pair of points using a divide-and-conquer approach. Implement the
algorithm to meet the following requirements:
■■ Define a class named Pair with the data fields p1 and p2 to represent
two points and a method named getDistance() that returns the distance
between the two points.
■■ Implement the following methods:
/** Return the distance of the closest pair of points
public static Pair getClosestPair(double[][] points)

/* Return the distance of the closest pair of points
public static Pair getClosestPair(Point2D[] points)

/** Return the distance of the closest pair of points
 * in pointsOrderedOnX[low..high]. This is a recursive
 * method. pointsOrderedOnX and pointsOrderedOnY are
 * not changed in the subsequent recursive calls.
public static Pair distance(Point2D[] pointsOrderedOnX, int low, int high, Point2D[] pointsOrderedOnY)

/** Compute the distance between two points p1 and p2
public static double distance(Point2D p1, Point2D p2)

/** Compute the distance between points (x1, y1) and (x2, y2)
public static double distance(double x1, double y1, double x2, double y2)

 */
package c22_EfficientAlgorithms;

import javafx.geometry.Point2D;

import java.util.*;

public class E2207 {
    public static void main(String[] args) {
        Point2D[] points = new Point2D[100];
        for (int i = 0; i < points.length; i++) {
            points[i] = new Point2D(Math.random() * 500, Math.random()* 500);
        }

        Pair closest = getClosestPair(points);
        System.out.println("The closest pair of 100 points is " + closest);
        System.out.println("Distance is " + closest.getDistance());
    }

    /** Return the distance of the closest pair of points */
    public static Pair getClosestPair(double[][] points) {
        Point2D[] points2D = new Point2D[points.length];
        for (int i = 0; i < points.length; i++)
            points2D[i] = new Point2D(points[i][0], points[i][1]);
        // Sort the points
        Arrays.sort(points2D, new Point2DComparator());
        return getClosestPair(points2D);
    }

    /** Return the distance of the closest pair of points */
    public static Pair getClosestPair(Point2D[] points) {
        Point2D[] points2DY = points.clone();
        Arrays.sort(points2DY, new Point2DComparatorY());
        return distance(points, 0, points.length -1, points2DY);
    }

    public static Pair getClosestPair(Pair pair1, Pair pair2) {
        if (pair1 == null && pair2 == null)
            return null;
        else if (pair1 == null) {
            return pair2;
        }
        else if (pair2 == null) {
            return pair1;
        }
        else {
            double d1 = pair1.getDistance();
            double d2 = pair2.getDistance();
            if (d1 < d2) {
                return pair1;
            }
            else {
               return pair2;
            }
        }
    }

    /** Return the distance of the closest pair of points
     * in pointsOrderedOnX[low..high]. This is a recursive
     * method. pointsOrderedOnX and pointsOrderedOnY are
     * not changed in the subsequent recursive calls.
     */
    public static Pair distance(Point2D[] pointsOrderedOnX, int low, int high, Point2D[] pointsOrderedOnY) {
        if (low >= high)
            return null;
        else if (low + 1 == high) {
            return new Pair(pointsOrderedOnX[low], pointsOrderedOnX[high]);
        }

        int midIndex = (low + high) / 2;
        Pair pair1 = distance(pointsOrderedOnX, low, midIndex, pointsOrderedOnY);
        Pair pair2 = distance(pointsOrderedOnX, midIndex + 1, high, pointsOrderedOnY);

        Pair pairFinal = getClosestPair(pair1, pair2);
        double d = (pairFinal == null) ? Double.MAX_VALUE : pairFinal.getDistance();

        //Find pair on the contact strips
        ArrayList<Point2D> stripL = new ArrayList<>();
        ArrayList<Point2D> stripR = new ArrayList<>();
        for (int i = low; i <= high; i++) {
            double x= pointsOrderedOnY[i].getX();
            double midX = pointsOrderedOnX[midIndex].getX();
            if ( x <= midX && x >= midX - d) {
                stripL.add(pointsOrderedOnY[i]);
            }
            else if ( x >= midX && x <= midX + d) {
                stripR.add(pointsOrderedOnY[i]);
            }
        }

        for (Point2D p: stripL) {
            //skip the points in stripR below p.getY -d;
            int indexR = 0;
            while (indexR < stripR.size() && stripR.get(indexR).getY() <= p.getY() -d)
                indexR++;

            // check distance from p to another point in stripR, with Y coordinate in range of p.y +-d
            int start = indexR;
            while (start < stripR.size() && stripR.get(start).getY() <= p.getY() + d) {
                double distance = p.distance(stripR.get(start));
                if (distance < d){
                    d = distance;
                    pairFinal = new Pair(p, stripR.get(start));
                }
                start++;
            }
        }

        return pairFinal;
    }

    /** Compute the distance between two points p1 and p2 */
    public static double distance(Point2D p1, Point2D p2) {
        return p1.distance(p2);
    }



    /** Compute the distance between points (x1, y1) and (x2, y2) */
    public static double distance(double x1, double y1, double x2, double y2) {
        Pair pair = new Pair(x1, y1, x2, y2);
        return pair.getDistance();
    }
}
