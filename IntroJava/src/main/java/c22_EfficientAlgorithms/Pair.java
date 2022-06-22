package c22_EfficientAlgorithms;

import javafx.geometry.Point2D;

public class Pair {
    private final Point2D p1;
    private final Point2D p2;

    public Pair(Point2D p1, Point2D p2) {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Pair(double x1, double y1, double x2, double y2) {
        p1 = new Point2D(x1,y1);
        p2 = new Point2D(x2, y2);
    }

    public Point2D getP1() {
        return p1;
    }

    public Point2D getP2() {
        return p2;
    }

    public double getDistance() {
        return p1.distance(p2);
    }

    @Override
    public String toString() {
        return "["+ p1.getX() + ", " + p1.getY() + "]" + ", ["+ p2.getX() + ", " + p2.getY() + "]";
    }

}
