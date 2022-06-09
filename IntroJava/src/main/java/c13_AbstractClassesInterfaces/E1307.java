package c13_AbstractClassesInterfaces;/*
(The Colorable interface) Design an interface named Colorable with a void
method named howToColor(). Every class of a colorable object must implement
the Colorable interface. Design a class named Square that extends
GeometricObject and implements Colorable. Implement howToColor to
display the message Color all four sides. The Square class contains a
data field side with getter and setter methods, and a constructor for constructing
a Square with a specified side. The Square class has a private double data
field named side with its getter and setter methods. It has a no-arg constructor
to create a Square with side 0, and another constructor that creates a Square
with the specified side.
Draw a UML diagram that involves Colorable, Square, and GeometricObject.
Write a test program that creates an array of five GeometricObjects. For each
object in the array, display its area and invoke its howToColor method if it is
colorable.
*/

public class E1307 {
    public static void main(String[] args) {
        Square a = new Square(5);
        GeometricObject b = new Square(3);
        System.out.println(a.compareTo(b));
        System.out.println(GeometricObject.max(a, b).toString());
        a.toColor("Yellow");
        System.out.println("Color a: " + a.getColor());
    }
}
