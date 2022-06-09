package c13_AbstractClassesInterfaces;

import java.math.BigInteger;

/*
(Use the Rational class) Write a program that computes the following summation
series using the Rational class:
1/2 + 3/4 + .. + 99/100
You will discover that the output is incorrect because of integer overflow (too
large). To fix this problem, see Programming Exercise 13.15.
*/
public class E1318 {
    public static void main(String[] args) {
        RationalBig[] r = new RationalBig[10];
        for (int i = 0; i < r.length; i++) {
            int n = 2 * i + 1;
            int d = 2 * i + 2;
            r[i] = new RationalBig(new BigInteger("" + n), new BigInteger("" + d));
        }
        System.out.println(sumRational(r).toString());
    }

    public static RationalBig sumRational(RationalBig[] list) {
        RationalBig sum = new RationalBig();
        for (RationalBig rationalBig : list) {
            sum = sum.add(rationalBig);
        }
        return sum;
    }
}