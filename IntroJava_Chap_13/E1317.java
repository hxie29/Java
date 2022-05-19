/* 
(Math: The Complex class) A complex number is a number in the form a + bi,
where a and b are real numbers and i is 2-1. The numbers a and b are known
as the real part and imaginary part of the complex number, respectively. You can
perform addition, subtraction, multiplication, and division for complex numbers
using the following formulas:
a + bi + c + di = (a + c) + (b + d)i
a + bi - (c + di) = (a - c) + (b - d)i
(a + bi) * (c + di) = (ac - bd) + (bc + ad)i
(a + bi)/(c + di) = (ac + bd)/(c2 + d2) + (bc - ad)i/(c2 + d2)
You can also obtain the absolute value for a complex number using the following
formula:
  a + bi   = 2a2 + b2
(A complex number can be interpreted as a point on a plane by identifying the
(a,b) values as the coordinates of the point. The absolute value of the complex
number corresponds to the distance of the point to the origin, as shown
in Figure 13.10.)
Design a class named Complex for representing complex numbers and the
methods add, subtract, multiply, divide, and abs for performing complex-
number operations, and override toString method for returning a string
representation for a complex number. The toString method returns (a + bi)
as a string. If b is 0, it simply returns a. Your Complex class should also implement
Cloneable and Comparable. Compare two complex numbers using their
absolute values.
Provide three constructors Complex(a, b), Complex(a), and Complex().
Complex() creates a Complex object for number 0, and Complex(a) creates
a Complex object with 0 for b. Also provide the getRealPart() and
getImaginaryPart() methods for returning the real part and the imaginary part
of the complex number, respectively.
Draw the UML class diagram and implement the class. Write a test program
that prompts the user to enter two complex numbers and displays the result of
their addition, subtraction, multiplication, division, and absolute value. Here is
a sample run:
Enter the first complex number: 3.5 5.5
Enter the second complex number: –3.5 1
(3.5 + 5.5i) + (–3.5 + 1.0i) = 0.0 + 6.5i
(3.5 + 5.5i) – (–3.5 + 1.0i) = 7.0 + 4.5i
(3.5 + 5.5i) * (–3.5 + 1.0i) = –17.75 + –15.75i
(3.5 + 5.5i) / (–3.5 + 1.0i) = –0.5094 + –1.7i
|(3.5 + 5.5i)| = 6.519202405202649
 */
import java.util.Scanner;

public class E1317 {
    public static void main(String[] args){
        Complex c1 = new Complex(3.5,5.5);
        Complex c2 = new Complex(-3.5,1);
        System.out.println(c1.toString());
        System.out.println(c2.toString());
        System.out.println(c1.toString() + " + " + c2.toString() + " = " + c1.add(c2).toString());
        System.out.println(c1.toString() + " - " + c2.toString() + " = " + c1.subtract(c2).toString());
        System.out.println(c1.toString() + " * " + c2.toString() + " = " + c1.multiply(c2).toString());
        System.out.println(c1.toString() + " / " + c2.toString() + " = " + c1.divide(c2).toString());
        System.out.println(c1.toString() + " > " + c2.toString() + " ? " + c1.compareTo(c2));
    }
}

class Complex implements Comparable<Complex>, Cloneable{
    private double a;
    private double b;

    //Constructor
    public Complex(){
        this(0,0);
    }

    public Complex(double a){
        this(a,0);
    }

    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }

    //Methods
    public double getRealPart(){
        return a;
    }

    public double getImaginaryPart(){
        return b;
    }

    public Complex add(Complex c) {
        return new Complex(a + c.getRealPart(), b + c.getImaginaryPart());
    }
    
    public Complex subtract(Complex c) {
        return new Complex(a - c.getRealPart(), b - c.getImaginaryPart());
    }

    public Complex multiply(Complex c) {
        double real = a * c.getRealPart() - b * c.getImaginaryPart();
        double imaginary = b * c.getRealPart() + a * c.getImaginaryPart();
        return new Complex(real, imaginary);
    }

    public Complex divide(Complex c) {
        double real = (a * c.getRealPart() + b * c.getImaginaryPart()) / (c.getRealPart() * c.getRealPart() + c.getImaginaryPart() * c.getImaginaryPart());
        double imaginary = (b * c.getRealPart() - a * c.getImaginaryPart()) / (c.getRealPart() * c.getRealPart() + c.getImaginaryPart() * c.getImaginaryPart());
        return new Complex(real, imaginary);
    }

    public double abs() {
        return Math.pow((a * a + b * b), 0.5);
    }

    //Overrude methods
    @Override
    public String toString() {
        if (b == 0) return a + "";
        else if (a == 0) return b + "i";
        else return a + " + " + b + "i";
    }

    @Override
    public int compareTo(Complex n) {
        return (this.abs() > n.abs()) ? 1 : ((this.abs() < n.abs()) ? -1 : 0);
    }

    @Override
    public Object clone() {
        try{
            return super.clone();
        }
        catch (CloneNotSupportedException ex) {
            return null;
        }
    }
}
