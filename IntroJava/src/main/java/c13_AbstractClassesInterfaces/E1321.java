package c13_AbstractClassesInterfaces;

import java.math.BigInteger;
import java.util.Scanner;

/*
(Algebra: vertex form equations) The equation of a parabola can be expressed in
either standard form (y = ax2 + bx + c) or vertex form (y = a(x - h)2 + k).
Write a program that prompts the user to enter a, b, and c as integers in standard
form and displays h = -b/2a; k= (4ac - b*b) /4a in the vertex form. Display h
and k as rational numbers. Here are some sample runs:

Enter a, b, c: 1 3 1
h is –3/2 k is –5/4
Enter a, b, c: 2 3 4
h is –3/4 k is 23/8
*/
public class E1321 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a , b, c for parabola function y = a * x^2 + b * x +c :");
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        input.close();
    
        RationalBig h = new RationalBig(new BigInteger("" + (-1 * b)), new BigInteger("" + (2 * a)));
        RationalBig k = new RationalBig(new BigInteger("" + ( 4 * a * c - b * b)), new BigInteger("" + (4 * a)));
        System.out.println("h is " + h + " k is " + k);
    }

}