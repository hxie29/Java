/*
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
        Rational a = new Rational(2, 4);
        Rational b = new Rational(-1,2);
        
        System.out.println(a + " + " + b + " = " + a.add(b));
        System.out.println(a + " - " + b + " = " + a.subtract(b));
        System.out.println(a + " * " + b + " = " + a.multiply(b));
        System.out.println(a + " / " + b + " = " + a.divide(b));
        System.out.println(b + " is " + b.doubleValue());
    }
}

class Rational extends Number implements Comparable<Rational> {
    private long[] r = new long[2];

    //Constructor
    public Rational() {
        this(0,1);
    }

    public Rational (long numerator, long denominator) throws IllegalArgumentException {
        if (denominator == 0) 
            throw new IllegalArgumentException("Denominator cannot be zero.");
        else {
            int gcd = gcd(numerator, denominator);
            r[0] = ((denominator > 0) ? 1 : -1 ) * numerator / gcd;
            r[1] = Math.absExact(denominator) / gcd;
        }
    }

    private static int gcd(long n1, long n2) {
        int gcd = 1;
        for (int k = 1; k <= n1 && k <= n2 ; k++) {
            if ( (n1 % k == 0) && (n2 % k == 0) ) {
                gcd = k;
            }
        }
        return gcd;
    }

    public long getNumerator() {
        return r[0];
    }

    public long getDenominator(){
        return r[1];
    }

    public Rational add(Rational a) {
        long numerator = a.getDenominator() * getNumerator() + a.getNumerator() * getDenominator();
        long denominator = a.getDenominator() * getDenominator();
        return new Rational(numerator, denominator);
    }

    public Rational subtract(Rational a) {
        long numerator = a.getDenominator() * getNumerator() - a.getNumerator() * getDenominator();
        long denominator = a.getDenominator() * getDenominator();
        return new Rational(numerator, denominator);
    }

    public Rational multiply(Rational a) {
        long numerator = a.getNumerator() * getNumerator();
        long denominator = a.getDenominator() * getDenominator();
        return new Rational(numerator, denominator);
    }

    public Rational divide(Rational a) {
        long numerator = getNumerator() * a.getDenominator();
        long denominator = getDenominator() * a.getNumerator();
        return new Rational(numerator, denominator);
    }

    @Override
    public String toString() {
        if (r[0] == 0 || r[1] == 1) return r[0] + "";
        else return r[0] + "/" + r[1]; 
    }

    @Override
    public int compareTo(Rational a) {
        return (this.subtract(a).getNumerator() > 0) ? 1 : ((this.subtract(a).getNumerator() < 0 ) ? -1 :0); 
    }

    @Override
    public boolean equals(Object o) {
        return this.subtract((Rational) o).getNumerator() == 0;
    }

    @Override
    public int intValue() {
        return (int)doubleValue();
    }

    @Override
    public double doubleValue() {
        return r[0] * 1.0 / r[1];
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
