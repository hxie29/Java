/*
(The Octagon class) Write a class named Octagon that extends
GeometricObject and implements the Comparable and Cloneable interfaces.
Assume all eight sides of the octagon are of equal length. The area can be
computed using the following formula:
area = 12 + 4/sqrt(2) * side * side

The Octagon class has a private double data field named side with its getter and
setter methods. The class has a no-arg constructor that creates an Octagon with
side 0, and a constructor to create an Octagon with a specified side.
Draw the UML diagram that involves Octagon, GeometricObject, Comparable,
and Cloneable. Write a test program that creates an Octagon object with side
value 5 and displays its area and perimeter. Create a new object using the clone
method, and compare the two objects using the compareTo method.
*/
import java.util.Date;
public class E1311 {
    public static void main(String[] args) {
        Octagon a = new Octagon(5);
        GeometricObject b = (Octagon)a.clone();
        System.out.println(a == b);
        System.out.println(a.equals(b));
    }
}

//Superclass
abstract class GeometricObject{
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

    //Return the max geometric object based on area
    public static GeometricObject max(GeometricObject a, GeometricObject b) {
        return (a.getArea() > b.getArea()) ? a : b;
    }
}

//Subclass
class Octagon extends GeometricObject implements Comparable<Octagon>, Cloneable{
    //Data fields (all data fields in superclass are inherited)
    private double side;

    //Constructor
    public Octagon(){
        this(0);
    }

    public Octagon(double side){
        setside(side);
    }

    public Octagon(double side, String color, boolean filled){
        //Calling constructor from super class  --> always put on the first line of command
        super(color, filled);
        setside(side);
    }

    //Methods
    public double getside(){
        return side;
    }

    public void setside(double side){
        this.side = side;
    }

    // Implement
    public double getArea(){
        return (2 + 4 / Math.pow(2, 0.5)) * side * side;
    }

    public double getPerimeter(){
        return side * 8;
    }

    public void printOctagon(){
        System.out.println("The Octagon is created " + getDate() + " and the side is " + side);
    }

    @Override
    public int compareTo(Octagon o) {
        return (getArea() > o.getArea()) ? 1 : ((getArea() < o.getArea()) ? -1 : 0);
    }

    @Override
    public boolean equals(Object a) {
        return ((Octagon)a).getside() == side;
    }

    @Override
    public String toString(){
        return super.toString() + "\nside is " + side;
    }

    @Override
    public Object clone(){
        Octagon o = new Octagon(side);
        return o;
    }

}