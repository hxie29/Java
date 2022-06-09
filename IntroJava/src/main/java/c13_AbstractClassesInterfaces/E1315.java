/*(Use BigInteger for the Rational class) Redesign and implement the
Rational class in Listing 13.13 using BigInteger for the numerator and denominator.
Write a test program that prompts the user to enter two rational numbers and
display the results as shown in the following sample run:
Enter the first rational number: 3 454
Enter the second second number: 7 2389
3/454 + 7/2389 = 10345/1084606
3/454 – 7/2389 = 3989/1084606
3/454 * 7/2389 = 21/1084606
3/454 / 7/2389 = 7167/3178
7/2389 is 0.0029300962745918793
*/
package c13_AbstractClassesInterfaces;

import java.math.BigInteger;

/*
(Demonstrate the benefits of encapsulation) Rewrite the Rational class
in Listing 13.13 using a new internal representation for the numerator and
denominator. Create an array of two integers as follows:
private BigInteger[] r = new BigInteger[2];
Use r[0] to represent the numerator and r[1] to represent the denominator.
The signatures of the methods in the Rational class are not changed, so a client
application that uses the previous Rational class can continue to use this new
Rational class without being recompiled.
*/
import java.util.Scanner;
public class E1315 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Enter the first rational number:");
        RationalBig a = new RationalBig(new BigInteger(input.next()), new BigInteger(input.next()));
        System.out.println("Enter the second rational number:");
        RationalBig b = new RationalBig(new BigInteger(input.next()), new BigInteger(input.next()));
        
        System.out.println(a + " + " + b + " = " + a.add(b));
        System.out.println(a + " - " + b + " = " + a.subtract(b));
        System.out.println(a + " * " + b + " = " + a.multiply(b));
        System.out.println(a + " / " + b + " = " + a.divide(b));
        System.out.println(b + " is " + b.doubleValue());

        input.close();
    }
}

