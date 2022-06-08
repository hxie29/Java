package c09_ObjectsClasses;

/* (The Rectangle class) Following the example of the Circle class in Section 9.2,
design a class named Rectangle to represent a rectangle. The class contains:
■■ Two double data fields named width and height that specify the width and
height of the rectangle. The default values are 1 for both width and height.
■■ A no-arg constructor that creates a default rectangle.
■■ A constructor that creates a rectangle with the specified width and height.
■■ A method named getArea() that returns the area of this rectangle.
■■ A method named getPerimeter() that returns the perimeter.
Draw the UML diagram for the class then implement the class. Write a test program
that creates two Rectangle objects—one with width 4 and height 40, and 
the other with width 3.5 and height 35.9. Display the width, height, area, and
perimeter of each rectangle in this order.
*/

public class E0901 {
    public static void main(String[] args) {
        Rectangle rec1 = new Rectangle();
        Rectangle rec2 = new Rectangle(3.5, 35.9);
        System.out.println("The rectangle 1's area is " + rec1.getArea() + " and the perimeter is " + rec1.getPerimeter());
        System.out.println("The rectangle 2's area is " + rec2.getArea() + " and the perimeter is " + rec2.getPerimeter());

    }
}
