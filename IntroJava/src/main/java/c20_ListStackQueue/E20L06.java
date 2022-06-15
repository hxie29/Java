//Test geometric object comparator
package c20_ListStackQueue;

import c13_AbstractClassesInterfaces.Circle;
import c13_AbstractClassesInterfaces.GeometricObject;
import c13_AbstractClassesInterfaces.Rectangle;

import java.util.Comparator;

public class E20L06 {
    public static void main(String[] args) {
        GeometricObject g1 = new Rectangle(5,5);
        GeometricObject g2 = new Circle(5);
        GeometricObject g = GeometricObject.max(g1, g2);
    }

    private static GeometricObject max (GeometricObject g1, GeometricObject g2, Comparator<GeometricObject> c) {
        return (c.compare(g1, g2) > 0) ? g1 : g2;
    }
}
