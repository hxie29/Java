/*(Geometry: convex hull animation) Programming Exercise 22.11 finds a convex
hull for a set of points entered from the console. Write a program that enables
the user to add or remove points by clicking the left or right mouse button and
displays a convex hull, as shown in Figure 22.8c.*/
package c22_EfficientAlgorithms;

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class ConvexHullPane extends Pane {
    private final static ArrayList<Point2D> points = new ArrayList<>();
    private final Stack<Circle> circles = new Stack<>();

    public ConvexHullPane() {
        this.setHeight(800);
        this.setWidth(800);
    }

    public void addPoint(double x, double y) {
        points.add(new Point2D(x,y));
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
        double[][] s = new double[points.size()][2];
        for (int i = 0; i < points.size(); i++) {
            s[i][0] = points.get(i).getX();
            s[i][1] = points.get(i).getY();
        }
        ArrayList<Point2D> convex = getConvexHull(s);
        Polygon poly = new Polygon();
        poly.setFill(Color.TRANSPARENT);
        poly.setStroke(Color.BLACK);
        for (Point2D p: convex) {
            poly.getPoints().add(p.getX());
            poly.getPoints().add(p.getY());
        }
        this.getChildren().removeIf(e -> e instanceof Polygon);
        this.getChildren().add(poly);
    }

    private ArrayList<Point2D> getConvexHull (double[][] s) {
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

    private boolean atLeft (Point2D p0, Point2D p1, Point2D p2) {
        return (p1.getX() - p0.getX()) * (p2.getY() - p0.getY()) - (p2.getX() - p0.getX()) * (p1.getY() - p0.getY()) <= 0;
    }
}
