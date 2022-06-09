package c13_AbstractClassesInterfaces;/*
Java provides data types for integers and floating-point numbers, but not for rational
numbers. This section shows how to design a class to represent rational numbers.
Since rational numbers share many common features with integers and floating-point
numbers, and Number is the root class for numeric wrapper classes, it is appropriate to define
Rational as a subclass of Number. Since rational numbers are comparable, the Rational
class should also implement the Comparable interface. Figure 13.8 illustrates the Rational
class and its relationship to the Number class and the Comparable interface.
*/

public class E13L12 {
    public static void main(String[] args) {
        Rational2 a = new Rational2(2, 4);
        Rational2 b = new Rational2(-1,2);
        
        System.out.println(a + " + " + b + " = " + a.add(b));
        System.out.println(a + " - " + b + " = " + a.subtract(b));
        System.out.println(a + " * " + b + " = " + a.multiply(b));
        System.out.println(a + " / " + b + " = " + a.divide(b));
        System.out.println(b + " is " + b.doubleValue());
    }
}

