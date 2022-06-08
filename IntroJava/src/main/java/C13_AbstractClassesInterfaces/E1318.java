import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import javax.swing.plaf.multi.MultiPanelUI;

/*
(Use the Rational class) Write a program that computes the following summation
series using the Rational class:
1/2 + 3/4 + .. + 99/100
You will discover that the output is incorrect because of integer overflow (too
large). To fix this problem, see Programming Exercise 13.15.
*/
public class E1318 {
    public static void main(String[] args) {
        Rational[] r = new Rational[10];
        for (int i = 0; i < r.length; i++) {
            int n = 2 * i + 1;
            int d = 2 * i + 2;
            r[i] = new Rational(new BigInteger("" + n), new BigInteger("" + d));
        }
        System.out.println(sumRational(r).toString());
    }

    public static Rational sumRational(Rational[] list) {
        Rational sum = new Rational();
        for (int i = 0; i < list.length; i++) {
            sum = sum.add(list[i]);
        }
        return sum;
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
