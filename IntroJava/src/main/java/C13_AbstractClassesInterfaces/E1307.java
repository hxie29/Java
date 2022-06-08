/*
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
import java.util.Date;
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

//Superclass
abstract class GeometricObject implements Comparable<GeometricObject>{
    //Data encapsulation
    private String color = "white";
    private boolean filled;
    private Date dateCreated;

    //Constructor is defined as protected because it is used only by subclasses (even outside the package)
    protected GeometricObject(){
        dateCreated = new Date();
    }

    protected GeometricObject(String color, boolean filled){
        setColor(color);
        setFilled(filled);
        dateCreated = new Date();
    }

    //Methods
    public String getColor(){
        return color;
    }

    public boolean isFilled(){
        return filled;
    }

    public void setColor(String color){
        this.color = color;
    }

    public void setFilled(boolean filled){
        this.filled = filled;
    }

    public Date getDate(){
        return dateCreated;
    }

    @Override
    public String toString(){
        return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
    }

    //Public abstrct methods does not have implementation, does not have a body, ends with;
    public abstract double getArea();
    public abstract double getPerimeter();

    @Override
    public int compareTo(GeometricObject o) {
        return (getArea() > o.getArea()) ? 1 : ((getArea() < o.getArea()) ? -1 : 0);
    }
    
    //Return the max geometric object based on area
    public static GeometricObject max(GeometricObject a, GeometricObject b) {
        return (a.getArea() > b.getArea()) ? a : b;
    }
}

//Subclass 
class Square extends GeometricObject implements Colorable {
    //data fields
    private double side = 1;

    // constructor
    public Square() {  
    }

    public Square(double side) {
        setside(side);
    }

    // method
    public double getside(){
        return side;
    }

    public void setside(double side){
        this.side = side;
    }


    public double getArea() {
        return side * side;
    }

    public double getPerimeter() {
        return side * 4;
    }
    @Override
    public String toString(){
        return "Square, side is " + side + super.toString();
    }

    @Override
    public void toColor(String color) {
        super.setColor(color);
    }

}

public interface Colorable {
    public void toColor(String color);
}
