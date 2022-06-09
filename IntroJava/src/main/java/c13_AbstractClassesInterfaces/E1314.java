package c13_AbstractClassesInterfaces;/*

(Demonstrate the benefits of encapsulation) Rewrite the Rational class
in Listing 13.13 using a new internal representation for the numerator and
denominator. Create an array of two integers as follows:
private long[] r = new long[2];
Use r[0] to represent the numerator and r[1] to represent the denominator.
The signatures of the methods in the Rational class are not changed, so a client
application that uses the previous Rational class can continue to use this new
Rational class without being recompiled.
*/

public class E1314 {
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

