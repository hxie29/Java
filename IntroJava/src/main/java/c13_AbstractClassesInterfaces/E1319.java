import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.Scanner;

import javax.swing.plaf.multi.MultiPanelUI;

/*
(Convert decimals to fractions) Write a program that prompts the user to enter a
decimal number and displays the number in a fraction. (Hint: read the decimal
number as a string, extract the integer part and fractional part from the string,
and use the BigInteger implementation of the Rational class in Programming
Exercise 13.15 to obtain a rational number for the decimal number.) Here are some
sample runs:

Enter a decimal number: 3.25
The fraction number is 13/4
Enter a decimal number: –0.45452
The fraction number is –11363/25000
*/
public class E1319 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a decimal number:");
        String decimalStr = input.next();

        String n = decimalStr.split("[.]")[0];
        if (n.charAt(0) == '-') 
            checkDigit(n.substring(1));
        else 
            checkDigit(n);
            
        String d = decimalStr.split("[.]")[1];
        checkDigit(d);

        int digitSize = (int) Math.pow(10, d.length());
        long number = (long)(Double.parseDouble(decimalStr) * digitSize);
        checkDigit(d);

        Rational r = new Rational(new BigInteger(number + ""), new BigInteger(digitSize + ""));
        System.out.println("The fraction number is " + r.toString());
        input.close();
    }

    public static void checkDigit(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i))) {
                System.out.println("Wrong input: " + s);
                System.exit(1);
            }
        }
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
