package c09_ObjectsClasses;/* Circle class with data encapsulation to protect client from accidentally modifying data*/

public class E09L08 {
    public static void main(String[] args) {
        Circle c1 = new Circle(5.0);
        System.out.println("The area of the circle of radius " + c1.getRadius() + " is " + c1.getArea());

        c1.setRadius(c1.getRadius() * 1.1);
        System.out.println("The circle's radius is modified to " + c1.getRadius());

        System.out.println("Number of objects created: " + Circle.getNumberOfObjects());

        Circle c2 = new Circle();
        System.out.println("The second circle has a radius of " + c2.getRadius());
        System.out.println("Number of objects created: " + Circle.getNumberOfObjects());
    }
}


