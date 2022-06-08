package c12_ExceptionTextIO;// Circle class with exception
import java.util.Date;
public class E12L07{
    public static void main(String[] args) {
        try{
            Circle c1 = new Circle(5);
            Circle c2 = new Circle(-1);
            Circle c3 = new Circle(10);
        }
        catch(IllegalArgumentException ex) {
            System.out.println(ex); // This is equivalent to print ex.toString()
        }

        System.out.println("Number of circles: " + Circle.getNumberOfObjects());
    }
}

class Circle extends GeometricObject{

    //Data fields (all data fields in superclass are inherited)
    private double radius;
    private static int numberOfObjects = 0;

    //Constructor
    public Circle(double radius){
        setRadius(radius);
        numberOfObjects++;
    }

    public Circle(double radius, String color, boolean filled){
        //Calling constructor from super class  --> always put on the first line of command
        super(color, filled);
        setRadius(radius);
        numberOfObjects++;
    }

    //Methods
    public double getRadius(){
        return radius;
    }

    public void setRadius(double radius) throws IllegalArgumentException{ // Declaring Exception on method line
        if (radius >= 0) {
            this.radius = radius;
        }
        else throw new IllegalArgumentException("Radius cannot be negative."); // Throw an exception
    }

    public static int getNumberOfObjects(){
        return numberOfObjects;
    }

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
    public String toString(){
        return super.toString() + "\nradius is " + radius;
    }

}

class GeometricObject {
    //Data encapsulation
    private String color = "white";
    private boolean filled;
    private Date dateCreated;

    //Constructor
    public GeometricObject(){
        dateCreated = new Date();
    }

    public GeometricObject(String color, boolean filled){
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

    public String toString(){
        return "created on " + dateCreated + "\ncolor: " + color + " and filled: " + filled;
    }
}
