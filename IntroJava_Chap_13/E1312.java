/*
(Sum the areas of geometric objects) Write a method that sums the areas of all the
geometric objects in an array. The method signature is:
public static double sumArea(GeometricObject[] a)
Write a test program that creates an array of four objects (two circles and two
rectangles) and computes their total area using the sumArea method.
*/
import java.util.Date;
public class E1311 {
    public static void main(String[] args) {
        Octagon a = new Octagon(5);
        GeometricObject b = (Octagon)a.clone();
        Circle c = new Circle(2);
        GeometricObject[] list = {a, b, c};
        System.out.println(GeometricObject.sumArea(list));
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

    public static double sumArea(GeometricObject[] list) {
        double sum = 0;
        for (int i = 0; i < list.length; i++) {
            sum += list[i].getArea();
        }
        return sum;
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