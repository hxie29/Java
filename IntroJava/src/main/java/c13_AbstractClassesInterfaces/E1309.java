package c13_AbstractClassesInterfaces;/*
(Enable Circle comparable) Rewrite the Circle class in Listing 13.2 to extend
GeometricObject and implement the Comparable interface. Override the
equals method in the Object class. Two Circle objects are equal if their radii
are the same. Draw the UML diagram that involves Circle, GeometricObject,
and Comparable.
*/

public class E1309 {
    public static void main(String[] args) {
        GeometricObject a = new Circle(5);
        GeometricObject c = new Circle(5);
        System.out.println(a.equals(c));
    }
}