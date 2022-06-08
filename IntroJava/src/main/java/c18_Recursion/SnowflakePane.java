package com.example.recursion;

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;
import java.util.ArrayList;

public class SnowflakePane extends Pane {
    private int order = 0;
    private final ArrayList<Point2D> originPoints = new ArrayList<>();


    public SnowflakePane() {
        int HEIGHT = 500;
        setHeight(HEIGHT);
        int WIDTH = 800;
        setWidth(WIDTH);
        int SIDE = 400;
        Point2D p1 = new Point2D(getWidth() /2 - 0.5 * SIDE, 10 + 0.5 * SIDE * Math.pow(3, 0.5));
        Point2D p2 = new Point2D(getWidth() /2, 10);
        Point2D p3 = new Point2D(getWidth() /2 + 0.5 * SIDE, 10 + 0.5 * SIDE * Math.pow(3, 0.5));
        originPoints.add(p1);
        originPoints.add(p2);
        originPoints.add(p3);
        paint();
    }

    public void setOrder(int order) {
        this.order = order;
        paint();
    }

    private void paint() {
        if (order == 0) {
            // order 0's logic is slightly different from the rest's
            // it's a static triangle , instead of generate three additional points of a line (of 2 points)
            drawPoly(originPoints);
        }

        // for order larger than 0, a pair of points is used to generate additional 3 points
        // additional 3 points are inserted in between the two points
        else{
            // get all points of polygon through a recursion call, starting with 3 lines (3 points)
            ArrayList<Point2D> points = getPoints(originPoints,0);
            // create a polygon with all points
            drawPoly(points);
        }
    }
    // Use recursion to get lists of points
    private ArrayList<Point2D> getPoints(ArrayList<Point2D> originPoints, int split) {
        // Base case -- end condition is split number reaches order required
        if (split == order) {
            return originPoints;
        }
        else {
            // find points at next level , a pair of points is used to generate additional 3 points
            // additional 3 points are inserted in between the two points
            // Make a new Arraylist to store all new points
            ArrayList<Point2D> newList = new ArrayList<>();
            Point2D[] pair;
            for (int i = 0; i < originPoints.size(); i++) {
                //first use loop to find all pair of points
                if (i < originPoints.size() -1) {
                    pair = new Point2D[]{originPoints.get(i), originPoints.get(i + 1)};
                }
                else {
                    pair = new Point2D[]{originPoints.get(i), originPoints.get(0)};
                }
                // after getting one pair of points generate 3 other points, and stored them in the new list;
                newList.addAll(generatePoints(pair));
            }
            // return the new list;
            return getPoints(newList, split + 1);
        }
    }
    private ArrayList<Point2D> generatePoints(Point2D[] pair) {
        double x1 = pair[0].getX();
        double y1 = pair[0].getY();
        double x2 = pair[0].getX();
        double y2 = pair[1].getY();
        Point2D p1a = new Point2D(x1 * 2/ 3 + x2 /3, y1 * 2/3 + y2 /3);
        Point2D p1c = new Point2D(x1 / 3 + x2 * 2/3, y1 /3 + y2  * 2/3);
        // find p1b by rotating p1p2 30 degree counter clock wise
        double length = p1a.distance(p1c);
        double angle = p1a.angle(p1c) / 180 * Math.PI;
        double set60 = ((y2 - y1) * (x2 - x1) < 0) ? Math.PI / 3 : - Math.PI / 3;
        /*double x3 = p1a.getX() + Math.cos(angle + set60 ) * length;
        double y3 = p1a.getY() + Math.sin(angle + set60 ) * length;*/
        /*p'x = cos(theta) * (px-ox) - sin(theta) * (py-oy) + ox
        p'y = sin(theta) * (px-ox) + cos(theta) * (py-oy) + oy*/
        double x3 = Math.cos(Math.PI / 3) * (p1c.getX() - p1a.getX()) + Math.sin(Math.PI / 3) * (p1c.getY() - p1a.getY()) + p1a.getX();
        double y3 = Math.sin(Math.PI / 3) * (p1c.getX() - p1a.getX()) - Math.cos(Math.PI / 3) * (p1c.getY() - p1a.getY()) + p1a.getY();
        Point2D p1b = new Point2D(x3, y3);

        ArrayList<Point2D> list = new ArrayList<>();
        list.add(pair[0]);
        list.add(p1a);
        list.add(p1b);
        list.add(p1c);
        return list;
    }
    private void drawPoly(ArrayList<Point2D> points) {
        System.out.println(points.size() + " points collected.");
        Polygon poly = new Polygon();
        for (Point2D point: points) {
            poly.getPoints().addAll(point.getX(),point.getY());
        }
        poly.setStroke(Color.BLACK);
        poly.setFill(Color.WHITE);
        getChildren().clear();
        getChildren().add(poly);
    }

    @Override
    protected void setHeight(double v) {
        super.setHeight(v);
    }

    @Override
    protected void setWidth(double v) {
        super.setWidth(v);
    }
}
