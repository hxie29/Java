package c09_ObjectsClasses;

public class Rectangle {

    //data fields
    private double width = 1;
    private double height = 1;

    // constructor
    public Rectangle() {
    }

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // method
    public double getArea() {
        return width * height;
    }

    public double getPerimeter() {
        return (width + height) * 2;
    }
}

