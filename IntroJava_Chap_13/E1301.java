/*
(Triangle class) Design a new Triangle class that extends the abstract
GeometricObject class. Draw the UML diagram for the classes Triangle and
GeometricObject then implement the Triangle class. Write a test program
that prompts the user to enter three sides of the triangle, a color, and a Boolean
value to indicate whether the triangle is filled. The program should create a Triangle
object with these sides, and set the color and filled properties using the
input. The program should display the area, perimeter, color, and true or false to
indicate whether it is filled or not.
*/
import java.util.Date;
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

//Subclass
class Triangle extends GeometricObject{
    //Data fields
    private double side1 = 1;
    private double side2 = 1;
    private double side3 = 1;

    //Constructor
    public Triangle(){
    }

    public Triangle(double side1, double side2, double side3) throws IllegalArgumentException{
        if (side1 + side2 > side3 && side2 + side3 > side1 && side1 + side3 > side2) {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        }
        else throw new IllegalArgumentException("Length input invalid.");
    }

    public Triangle(double side1, double side2, double side3, String color, boolean filled) throws IllegalArgumentException{
        super(color, filled);
        if (side1 + side2 > side3 && side2 + side3 > side1 && side1 + side3 > side2) {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        }
        else throw new IllegalArgumentException("Length input invalid.");
    }

    //Methods
    public double getSide1(){
        return side1;
    }
    public double getSide2(){
        return side2;
    }
    public double getSide3(){
        return side3;
    }

    public double getArea(){
        double s = (side1 + side2 + side3) / 2;
        return Math.pow((s * (s-side1) * (s -side2) * (s-side3)), 0.5);
    }

    public double getPerimeter(){
        return side1 + side2 + side3;
    }

    @Override
    public String toString(){
        return "Triangle: side1 = " + side1 + " side2 = " + side2 + " side3 = " + side3;
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
    
}
