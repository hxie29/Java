package c13_AbstractClassesInterfaces;
/*
(Sum the areas of geometric objects) Write a method that sums the areas of all the
geometric objects in an array. The method signature is:
public static double sumArea(GeometricObject[] a)
Write a test program that creates an array of four objects (two circles and two
rectangles) and computes their total area using the sumArea method.
*/

public class E1312 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Octagon a = new Octagon(5);
        GeometricObject b = (Octagon)a.clone();
        Circle c = new Circle(2);
        GeometricObject[] list = {a, b, c};
        System.out.println(GeometricObject.sumArea(list));
    }
}