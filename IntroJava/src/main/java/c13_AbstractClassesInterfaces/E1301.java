package c13_AbstractClassesInterfaces;/*
(Triangle class) Design a new Triangle class that extends the abstract
GeometricObject class. Draw the UML diagram for the classes Triangle and
GeometricObject then implement the Triangle class. Write a test program
that prompts the user to enter three sides of the triangle, a color, and a Boolean
value to indicate whether the triangle is filled. The program should create a Triangle
object with these sides, and set the color and filled properties using the
input. The program should display the area, perimeter, color, and true or false to
indicate whether it is filled or not.
*/

public class E1301 {
    public static void main(String[] args) {
        try {
            Triangle t = new Triangle(2, 2, 2, "Green", false);
            System.out.println("Area: " + t.getArea());
            System.err.println("Perimeter: " + t.getPerimeter());
            System.out.println("Color: " + t.getColor());
            System.out.println("Filled? " + t.isFilled());
        }
        catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        }
    }
}

