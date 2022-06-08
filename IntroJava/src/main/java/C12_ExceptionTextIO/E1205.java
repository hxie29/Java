/* 
(IllegalTriangleException) Programming Exercise 11.1 defined the
Triangle class with three sides. In a triangle, the sum of any two sides is
greater than the other side. The Triangle class must adhere to this rule.
Create the IllegalTriangleException class, and modify the constructor
of the Triangle class to throw an IllegalTriangleException object if a
triangle is created with sides that violate the rule, as follows:
/** Construct a triangle with the specified sides 
public Triangle(double side1, double side2, double side3)
throws IllegalTriangleException {
// Implement it
}

*/

import java.util.Scanner;
import java.util.Date;
public class E1101 {
    public static void main(String[]args){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the three sides of a triangle:");
        double side1 = input.nextDouble();
        double side2 = input.nextDouble();
        double side3 = input.nextDouble();

        try{
            Triangle t = new Triangle(side1, side2, side3);
            System.out.println("Area: " + t.getArea());
            System.out.println("Perimeter: " + t.getPerimeter());
        }

        catch(IllegalTriangleException ex) {
            System.out.println("Error: " + ex.getMessage());
        }

        input.close();
    }
}

//Subclass
class Triangle extends GeometricObject {
    //Data fields
    private double side1 = 1;
    private double side2 = 1;
    private double side3 = 1;

    //Constructor
    public Triangle(){
    }

    public Triangle(double side1, double side2, double side3) throws IllegalTriangleException{
        if (checkTriangle(side1, side2, side3)) {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        }
        else throw new IllegalTriangleException();
    }

    public Triangle(double side1, double side2, double side3, String color, boolean filled) throws IllegalTriangleException {
        super(color, filled);
        if (checkTriangle(side1, side2, side3)) {
            this.side1 = side1;
            this.side2 = side2;
            this.side3 = side3;
        }
        else throw new IllegalTriangleException();
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

    public static boolean checkTriangle (double a, double b, double c) {
        return (a + b > c) && ( a + c > b) && ( b + c > a);
    }

}

class IllegalTriangleException extends Exception {
    public IllegalTriangleException () {
        super(" In a triangle, the sum of any two sides is greater than the other side. ");
    }
}

//Superclass
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

