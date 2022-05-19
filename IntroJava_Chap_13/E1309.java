/*
(Enable Circle comparable) Rewrite the Circle class in Listing 13.2 to extend
GeometricObject and implement the Comparable interface. Override the
equals method in the Object class. Two Circle objects are equal if their radii
are the same. Draw the UML diagram that involves Circle, GeometricObject,
and Comparable.
*/
import java.util.Date;
public class E1309 {
    public static void main(String[] args) {
        GeometricObject a = new Circle(5);
        GeometricObject c = new Circle(5);
        System.out.println(a.equals(c));
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
class Circle extends GeometricObject implements Comparable<Circle>{
    //Data fields (all data fields in superclass are inherited)
    private double radius;

    //Constructor
    public Circle(){
    }

    public Circle(double radius){
        setRadius(radius);
    }

    public Circle(double radius, String color, boolean filled){
        //Calling constructor from super class  --> always put on the first line of command
        super(color, filled);
        setRadius(radius);
    }

    //Methods
    public double getRadius(){
        return radius;
    }

    public void setRadius(double radius){
        this.radius = radius;
    }

    // Implement
    public double getArea(){
        return Math.PI * radius * radius;
    }

    public double getPerimeter(){
        return Math.PI * radius * 2;
    }

    public void printCircle(){
        System.out.println("The circle is created " + getDate() + " and the radius is " + radius);
    }

    @Override
    public int compareTo(Circle o) {
        return (getArea() > o.getArea()) ? 1 : ((getArea() < o.getArea()) ? -1 : 0);
    }

    @Override
    public boolean equals(Object a) {
        return ((Circle)a).getRadius() == radius;
    }

    @Override
    public String toString(){
        return super.toString() + "\nradius is " + radius;
    }

}