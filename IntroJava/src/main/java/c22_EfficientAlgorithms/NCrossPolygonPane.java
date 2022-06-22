/* (Geometry: noncrossed polygon) Write a program that enables the user to add
or remove points by clicking the left or right mouse button and displays a noncrossed
polygon that links all the points, as shown in Figure 22.11a. A polygon
is crossed if two or more sides intersect, as shown in Figure 22.11b. Use the
following algorithm to construct a polygon from a set of points:

Step 1: Given a set of points S, select the rightmost lowest
point p0 in the set S.
Step 2: Sort the points in S angularly along the x-axis
with p0 as the center. If there is a tie and two points have
the same angle, the one that is closer to p0 is considered
greater. The points in S are now sorted as p0, p1, p2, ...,
pn−1.
Step 3: The sorted points form a noncrossed polygon.
*/

package c22_EfficientAlgorithms;

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class NCrossPolygonPane extends Pane {
    private final ArrayList<MyPointN> points = new ArrayList<>();
    private final Stack<Circle> circles = new Stack<>();
    public NCrossPolygonPane() {
        setHeight(800);
        setWidth(800);
    }

    public void addPoint(double x, double y) {
        points.add(new MyPointN(x,y));
        Circle c = new Circle(x, y, 5);
        c.setFill(Color.BLACK);
        circles.push(c);
        this.getChildren().add(c);
        getPolygon();
    }

    public void removePoint() {
        if (points.size() > 0) {
            points.remove(points.size() -1);
            this.getChildren().remove(circles.pop());
            getPolygon();
        }
    }

    private void getPolygon() {
        points.sort(new MyPointNYComparator());
        MyPointN p0 = points.get(points.size() -1);
        points.forEach(p -> p.setRightMostLowestPoint(p0));
        Collections.sort(points);

        Polygon poly = new Polygon();
        poly.setFill(Color.TRANSPARENT);
        poly.setStroke(Color.BLACK);
        for (MyPointN p: points) {
            poly.getPoints().add(p.getX());
            poly.getPoints().add(p.getY());
        }
        this.getChildren().removeIf(e -> e instanceof Polygon);
        this.getChildren().add(poly);
    }

    private static class MyPointN implements Comparable<MyPointN> {
        double x, y;
        MyPointN rightMostLowestPoint;

        MyPointN(double x, double y) {
            this.x = x;
            this.y = y;
        }

        public double getY() {
            return y;
        }

        public double getX() {
            return x;
        }

        public void setRightMostLowestPoint(MyPointN p) {
            rightMostLowestPoint = p;
        }

        @Override
        public int compareTo(MyPointN o) {
            Point2D p1 = new Point2D(this.x - rightMostLowestPoint.x, this.y - rightMostLowestPoint.y);
            Point2D p2 = new Point2D( o.x - rightMostLowestPoint.x, o.y - rightMostLowestPoint.y);
            Point2D p0 = new Point2D(1, 0);
            if (p1.magnitude() == 0)
                return -1;
            else if (p2.magnitude() == 0) {
                return 1;
            }
            else {
                double angle1 = p0.angle(p1);
                double angle2 = p0.angle(p2);
                if (angle1 == angle2) {
                    return (p1.magnitude() < p2.magnitude()) ? 1 : -1;
                }
                else return (angle1 < angle2) ? -1 : 1;
            }

        }
    }

    private static class MyPointNYComparator implements Comparator<MyPointN> {
        @Override
        public int compare(MyPointN o1, MyPointN o2) {
            if (o1.getY() != o2.getY())
                return (o1.getY() - o2.getY() < 0) ? -1 : 1;
            else
                return (o1.getX() - o2.getX() < 0) ? -1 : (o1.getX() - o2.getX() == 0) ? 0 : -1;
        }
    }

}
