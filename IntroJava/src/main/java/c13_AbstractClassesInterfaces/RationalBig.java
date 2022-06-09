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

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

class RationalBig extends Number implements Comparable<RationalBig> {
    private final BigInteger[] r = new BigInteger[2];

    //Constructor
    public RationalBig() {
        this(BigInteger.ZERO, BigInteger.ONE);
    }

    public RationalBig(BigInteger numerator, BigInteger denominator) throws IllegalArgumentException {
        if (denominator.compareTo(BigInteger.ZERO) == 0)
            throw new IllegalArgumentException("Denominator cannot be zero.");
        else {
            BigInteger gcd = gcd(numerator, denominator);
            r[0] = (numerator.divide(gcd)).multiply(((denominator.compareTo(BigInteger.ZERO) > 0) ? BigInteger.ONE : (new BigInteger("-1"))));
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

    public BigInteger getDenominator() {
        return r[1];
    }

    public RationalBig add(RationalBig a) {
        BigInteger numerator = a.getDenominator().multiply(r[0]).add(a.getNumerator().multiply(r[1]));
        BigInteger denominator = a.getDenominator().multiply(r[1]);
        return new RationalBig(numerator, denominator);
    }

    public RationalBig subtract(RationalBig a) {
        BigInteger numerator = a.getDenominator().multiply(r[0]).subtract(a.getNumerator().multiply(r[1]));
        BigInteger denominator = a.getDenominator().multiply(r[1]);
        return new RationalBig(numerator, denominator);
    }

    public RationalBig multiply(RationalBig a) {
        BigInteger numerator = a.getNumerator().multiply(r[0]);
        BigInteger denominator = a.getDenominator().multiply(r[1]);
        return new RationalBig(numerator, denominator);
    }

    public RationalBig divide(RationalBig a) {
        BigInteger numerator = r[0].multiply(a.getDenominator());
        BigInteger denominator = r[1].multiply(a.getNumerator());
        return new RationalBig(numerator, denominator);
    }

    @Override
    public String toString() {
        if (r[0].equals(new BigInteger("0")) || r[1].equals(BigInteger.ONE)) return r[0].toString();
        else return r[0] + "/" + r[1];
    }

    @Override
    public int compareTo(RationalBig a) {
        return Integer.compare(this.subtract(a).getNumerator().compareTo(BigInteger.ZERO), 0);
    }

    @Override
    public boolean equals(Object o) {
        if (o != null)
            return this.subtract((RationalBig) o).getNumerator().equals(BigInteger.ZERO);
        else return false;
    }

    @Override
    public int intValue() {
        return (int) doubleValue();
    }

    @Override
    public double doubleValue() {
        // BigDecimal divide needs round up
        return (new BigDecimal(r[0])).divide(new BigDecimal(r[1]), 20, RoundingMode.HALF_UP).doubleValue();
    }

    @Override
    public float floatValue() {
        return (float) doubleValue();
    }

    @Override
    public long longValue() {
        return (long) doubleValue();
    }

}
