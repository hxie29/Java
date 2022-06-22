package c22_EfficientAlgorithms;

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import java.util.ArrayList;
import java.util.Stack;

public class ClosestPairPane extends Pane {
    private final ArrayList<Point2D> points = new ArrayList<>();
    private final ArrayList<Point2D> points2DY = new ArrayList<>();
    private final Stack<Circle> circles = new Stack<>();
    public ClosestPairPane() {
        setHeight(800);
        setWidth(800);
    }
    public void addPoint(double x, double y) {
        points.add(new Point2D(x,y));
        points2DY.add(new Point2D(x,y));
        Circle c = new Circle(x, y, 5);
        c.setFill(Color.BLACK);
        circles.push(c);
        this.getChildren().add(c);
        draw(getClosestPair());
    }

    public void removePoint(double x, double y) {
        double centerX = 0, centerY = 0;
        for (Circle e: circles) {
            if (e.contains(x, y)) {
                centerX = e.getCenterX();
                centerY = e.getCenterY();
                break;
            }
        }

        if (points.size() > 0) {
            points.remove(new Point2D(centerX, centerY));
            points2DY.remove(new Point2D(centerX, centerY));
            this.getChildren().remove(circles.pop());
            draw(getClosestPair());
        }
    }

    private void draw(Pair pair) {
        if (pair != null) {
            getChildren().removeIf(e -> e instanceof Line);
            Point2D p1 = pair.getP1();
            Point2D p2 = pair.getP2();
            Line line = new Line (p1.getX(), p1.getY(), p2.getX(), p2.getY());
            getChildren().add(line);
        }
    }

    private Pair getClosestPair() {
        points.sort(new Point2DComparator());
        points2DY.sort(new Point2DComparatorY());
        return distance(points, 0, points.size() -1, points2DY);
    }
    private Pair getClosestPair(Pair pair1, Pair pair2) {

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

    private Pair distance(ArrayList<Point2D> pointsOrderedOnX, int low, int high, ArrayList<Point2D> pointsOrderedOnY) {
        if (low >= high)
            return null;
        else if (low + 1 == high) {
            return new Pair(pointsOrderedOnX.get(low), pointsOrderedOnX.get(high));
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
            double x= pointsOrderedOnY.get(i).getX();
            double midX = pointsOrderedOnX.get(midIndex).getX();
            if ( x <= midX && x >= midX - d) {
                stripL.add(pointsOrderedOnY.get(i));
            }
            else if ( x >= midX && x <= midX + d) {
                stripR.add(pointsOrderedOnY.get(i));
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
}
