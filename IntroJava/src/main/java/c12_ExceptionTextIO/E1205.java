package c12_ExceptionTextIO;/*
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

public class E1205 {
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

