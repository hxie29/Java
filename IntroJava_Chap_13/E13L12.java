/*
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
    private long numerator = 0;
    private long denominator = 1;

    //Constructor
    public Rational() {
    }

    public Rational (long numerator, long denominator) throws IllegalArgumentException {
        if (denominator == 0) 
            throw new IllegalArgumentException("Denominator cannot be zero.");
        else {
            int gcd = gcd(numerator, denominator);
            this.numerator = ((denominator > 0) ? 1 : -1 ) * numerator / gcd;
            this.denominator = Math.absExact(denominator) / gcd;
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
        return numerator;
    }

    public long getDenominator(){
        return denominator;
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
        if (numerator == 0 || denominator == 1) return numerator + "";
        else return numerator + "/" + denominator; 
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
        return numerator * 1.0 / denominator;
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
