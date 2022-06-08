import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;

import javax.swing.plaf.multi.MultiPanelUI;

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
    
        Rational h = new Rational(new BigInteger("" + (-1 * b)), new BigInteger("" + (2 * a)));
        Rational k = new Rational(new BigInteger("" + ( 4 * a * c - b * b)), new BigInteger("" + (4 * a)));
        System.out.println("h is " + h.toString() + " k is " + k.toString());
    }

}

class Rational extends Number implements Comparable<Rational> {
    private BigInteger[] r = new BigInteger[2];

    //Constructor
    public Rational() {
        this(BigInteger.ZERO, BigInteger.ONE);
    }

    public Rational (BigInteger numerator, BigInteger denominator) throws IllegalArgumentException {
        if (denominator.compareTo(BigInteger.ZERO) == 0) 
            throw new IllegalArgumentException("Denominator cannot be zero.");
        else {
            BigInteger gcd = gcd(numerator, denominator);
            r[0] = (numerator.divide(gcd)).multiply(((denominator.compareTo(BigInteger.ZERO)> 0) ? BigInteger.ONE : (new BigInteger("-1"))));
            r[1] = (denominator.abs()).divide(gcd);
        }
    }

    private static BigInteger gcd(BigInteger n1, BigInteger n2) {
        BigInteger gcd = BigInteger.ONE;
        for (BigInteger k = BigInteger.ONE; k.compareTo(n1.abs()) <= 0 && k.compareTo(n2.abs()) <= 0; k = k.add(BigInteger.ONE)) {
            if (n1.remainder(k).equals(BigInteger.ZERO) && n2.remainder(k).equals(BigInteger.ZERO)) {
                gcd = k;
            }
        }
        return gcd;
    }

    public BigInteger getNumerator() {
        return r[0];
    }

    public BigInteger getDenominator(){
        return r[1];
    }

    public Rational add(Rational a) {
        BigInteger numerator = a.getDenominator().multiply(r[0]).add(a.getNumerator().multiply(r[1]));
        BigInteger denominator = a.getDenominator().multiply(r[1]);
        return new Rational(numerator, denominator);
    }

    public Rational subtract(Rational a) {
        BigInteger numerator = a.getDenominator().multiply(r[0]).subtract(a.getNumerator().multiply(r[1]));
        BigInteger denominator = a.getDenominator().multiply(r[1]);
        return new Rational(numerator, denominator);
    }

    public Rational multiply(Rational a) {
        BigInteger numerator = a.getNumerator().multiply(r[0]);
        BigInteger denominator = a.getDenominator().multiply(r[1]);
        return new Rational(numerator, denominator);
    }

    public Rational divide(Rational a) {
        BigInteger numerator = r[0].multiply(a.getDenominator());
        BigInteger denominator = r[1].multiply(a.getNumerator());
        return new Rational(numerator, denominator);
    }

    @Override
    public String toString() {
        if (r[0].equals(new BigInteger("0")) || r[1].equals(BigInteger.ONE)) return r[0].toString();
        else return r[0].toString() + "/" + r[1].toString(); 
    }

    @Override
    public int compareTo(Rational a) {
        return (this.subtract(a).getNumerator().compareTo(BigInteger.ZERO) > 0) ? 1 : ((this.subtract(a).getNumerator().compareTo(BigInteger.ZERO) < 0) ? -1 :0); 
    }

    @Override
    public boolean equals(Object o) {
        return this.subtract((Rational) o).getNumerator().equals(BigInteger.ZERO);
    }

    @Override
    public int intValue() {
        return (int)doubleValue();
    }

    @Override
    public double doubleValue() {
        // BigDecimal divide needs round up
        return (new BigDecimal(r[0])).divide(new BigDecimal(r[1]), 20, RoundingMode.HALF_UP).doubleValue();
    }

    @Override 
    public float floatValue() {
        return (float)doubleValue();
    }
    @Override 
    public long longValue() {
        return (long)doubleValue();
    }

}
