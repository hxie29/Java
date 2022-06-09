package c13_AbstractClassesInterfaces;/*
(Enable GeometricObject comparable) Modify the GeometricObject class
to implement the Comparable interface and define a static max method in the
GeometricObject class for finding the larger of two GeometricObject objects.
Draw the UML diagram and implement the new GeometricObject class. Write
a test program that uses the max method to find the larger of two circles, the larger
of two rectangles.
*/

public class E1305 {
    public static void main(String[] args) {
        GeometricObject a = new Circle(5);
        GeometricObject c = new Circle(5);
        GeometricObject b = new Rectangle(3, 5);
        System.out.println(a.compareTo(b));
        System.out.println(GeometricObject.max(a, b).toString());
        System.out.println(a.equals(c));
    }
}


