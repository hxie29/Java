//Bounded type demo
package c19_Generics;

import c13_AbstractClassesInterfaces.Circle;
import c13_AbstractClassesInterfaces.Rectangle;
import c13_AbstractClassesInterfaces.GeometricObject;

public class E19L03 {
    public static void main(String[] args) {
        Rectangle rec = new Rectangle(2, 2);
        Circle c = new Circle(2);
        System.out.println("Same area?" + equalArea(rec, c));
    }

    public static <E extends GeometricObject> boolean equalArea(E o1, E o2) {
        return o1.getArea() == o2.getArea();
    }
}
