package c23_Sorting;

import c13_AbstractClassesInterfaces.Circle;

import java.util.Comparator;

public class CircleComparator implements Comparator<Circle> {
    @Override
    public int compare(Circle o1, Circle o2) {
        return Double.compare(o1.getRadius(), o2.getRadius());
    }
}
