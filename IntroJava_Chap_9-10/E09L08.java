/* Circle class with data encapsulation to protect client from accidentally modifying data*/

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

class Circle {
    //data field
    private double radius = 1;
    private static int numberOfObjects = 0;

    // constructor
    public Circle() { // can be accessed from any class in any packages
        numberOfObjects++;
    }

    // constructor with arguments
    public Circle(double newRadius) {
        radius = newRadius;
        numberOfObjects++;
    }

    //To provide reader access to private data fields from other classes/ packages
    public double getRadius() {
        return radius; // now radius is accessed from a method defined in this class
    } 

    //To provide writer access to private data fields from other classes/ packages
    public void setRadius(double newRadius) {
        radius = (newRadius >= 0) ? newRadius : 0; // now radius is accessed from a method defined in this class
    }

    //To provide reader access to private data fields from other classes/ package
    //This is also an static method (can only access/invoke static methods/data fields)
    public static int getNumberOfObjects() {
        return numberOfObjects;
    }

    public double getArea() {
        return radius * radius * Math.PI;
    }
}


