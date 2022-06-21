package c22_EfficientAlgorithms;

import javafx.geometry.Point2D;

import java.util.Comparator;

public class Point2DComparatorY implements Comparator<Point2D> {

    @Override
    public int compare(Point2D o1, Point2D o2) {
        if (o1.getY() != o2.getY())
            return (o1.getY() - o2.getY() < 0) ? -1 : 1;
        else
            return (o1.getX() - o2.getX() < 0) ? -1 : (o1.getX() - o2.getX() == 0) ? 0 : -1;
    }
}
