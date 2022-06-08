package c09_ObjectsClasses;

public class Circle {
    // Data fields
    private double radius;
    static int numberOfCircles;

    //Constructor with no arguments
    Circle() {
        radius = 1;
        numberOfCircles++;
    }

    //Constructor with arguments
    Circle(double newRadius) {
        radius = newRadius;
        numberOfCircles++;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    // Other methods
    // static methods only invoke/access static method/data field
    static int getNumberOfObjects() {
        return numberOfCircles;
    }

    // instance methods can invoke/access both static and instance method/data field
    double getArea() {
        return radius * radius * Math.PI;
    }
}
