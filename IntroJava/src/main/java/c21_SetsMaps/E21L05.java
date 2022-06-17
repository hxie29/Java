// Test tree set with comparator
package c21_SetsMaps;

import c13_AbstractClassesInterfaces.Circle;
import c13_AbstractClassesInterfaces.GeometricObject;
import c13_AbstractClassesInterfaces.Rectangle;
import c20_ListStackQueue.GeometricObjectComparator;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class E21L05 {
    public static void main(String[] args) {
        Set<GeometricObject> set = new HashSet<>();
        set.add(new Rectangle(5, 6));
        set.add(new Circle(5));
        set.add(new Circle(6));
        set.add(new Rectangle(4.5, 7));
        set.forEach(e -> System.out.println(e.getClass().toString() + " " + e.getArea()));

        TreeSet<GeometricObject> treeSet = new TreeSet<>(new GeometricObjectComparator());
        treeSet.addAll(set);
        treeSet.forEach(e -> System.out.println(e.getClass().toString() +  " " +e.getArea()));
    }
}
