//Comparator Interface
package c20_ListStackQueue;

import c13_AbstractClassesInterfaces.GeometricObject;

import java.io.Serializable;
import java.util.Comparator;

public class GeometricObjectComparator implements Comparator<GeometricObject>, Serializable {
    @Override
    public int compare(GeometricObject o1, GeometricObject o2) {
        return (int)(o1.getArea() - o2.getArea());
    }
}
