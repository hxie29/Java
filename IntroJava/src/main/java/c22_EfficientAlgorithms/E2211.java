/*(Geometry: Graham’s algorithm for finding a convex hull) Section 22.10.2
introduced Graham’s algorithm for finding a convex hull for a set of points.
Assume Java’s coordinate system is used for the points. Implement the algorithm
using the following method:

 */
/** Return the points that form a convex hull
public static ArrayList<MyPoint> getConvexHull(double[][] s)


 MyPoint is a static inner class defined as follows:
private static class MyPoint implements Comparable<MyPoint> {
    double x, y;
    MyPoint rightMostLowestPoint;
     MyPoint(double x, double y) {
     this.x = x; this.y = y;
     }
     public void setRightMostLowestPoint(MyPoint p) {
     rightMostLowestPoint = p;
     }

     @Override
     public int compareTo(MyPoint o) {
     // Implement it to compare this point with point o
     // angularly along the x-axis with rightMostLowestPoint
     // as the center, as shown in Figure 22.10b. By implementing
     // the Comparable interface, you can use the Array.sort
     // method to sort the points to simplify coding.
     }
 }

Write a test program that prompts the user to enter the set size and the points,
and displays the points that form a convex hull. Here is a sample run:
How many points are in the set? 6
Enter six points: 1 2.4 2.5 2 1.5 34.5 5.5 6 6 2.4 5.5 9
The convex hull is
(1.5, 34.5) (5.5, 9.0) (6.0, 2.4) (2.5, 2.0) (1.0, 2.4)

 */
package c22_EfficientAlgorithms;

import javafx.geometry.Point2D;

import java.util.*;

public class E2211 {
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
        ArrayList<MyPoint> hullPoints = getConvexHull(s);
        System.out.println("The convex hull is : ");
        for (MyPoint point: hullPoints) {
            System.out.print("(" + point.x + ", " + point.y + ") ");
        }
    }

    public static ArrayList<MyPoint> getConvexHull(double[][] s) {
        MyPoint[] points = new MyPoint[s.length];
        for (int i = 0; i < s.length; i++) {
            points[i] = new MyPoint(s[i][0], s[i][1]);
        }
        Arrays.sort(points, new MyPointYComparator());
        MyPoint p0 = points[points.length -1];
        System.out.println(p0.x + ", " + p0.y);
        for (MyPoint point: points) {
            point.setRightMostLowestPoint(p0);
        }
        Arrays.sort(points);


        ArrayList<MyPoint> hullPoints = new ArrayList<>();
        hullPoints.add(points[0]);
        hullPoints.add(points[1]);
        hullPoints.add(points[2]);

        int index = 3;
        while (index < points.length) {
            MyPoint t1 = hullPoints.get(hullPoints.size() - 1);
            MyPoint t2 = hullPoints.get(hullPoints.size() - 2);
            MyPoint p = points[index];

            if (atLeft(t2,t1,p)) {
                hullPoints.add(p);
                index++;
            }
            else
                hullPoints.remove(t1);
        }
        return hullPoints;
    }


    private static class MyPoint implements Comparable<MyPoint> {
        double x, y;
        MyPoint rightMostLowestPoint;

        MyPoint(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getY() {
            return y;
        }

        public double getX() {
            return x;
        }

        public void setRightMostLowestPoint(MyPoint p) {
            rightMostLowestPoint = p;
        }

        @Override
        public int compareTo(MyPoint o) {
            Point2D p1 = new Point2D(this.x - rightMostLowestPoint.x, this.y - rightMostLowestPoint.y);
            Point2D p2 = new Point2D( o.x - rightMostLowestPoint.x, o.y - rightMostLowestPoint.y);
            Point2D p0 = new Point2D(1, 0);
            if (p1.magnitude() == 0)
                return -1;
            else if (p2.magnitude() == 0) {
                return 1;
            }
            else return Double.compare(p0.angle(p1), p0.angle(p2));
        }
    }

    private static boolean atLeft (MyPoint p0, MyPoint p1, MyPoint p2) {
        return (p1.x - p0.x) * (p2.y - p0.y) - (p2.x - p0.x) * (p1.y - p0.y) <= 0;
    }

    private static class MyPointYComparator implements Comparator<MyPoint> {
        @Override
        public int compare(MyPoint o1, MyPoint o2) {
            if (o1.getY() != o2.getY())
                return (o1.getY() - o2.getY() < 0) ? -1 : 1;
            else
                return (o1.getX() - o2.getX() < 0) ? -1 : (o1.getX() - o2.getX() == 0) ? 0 : -1;
        }
    }
}
