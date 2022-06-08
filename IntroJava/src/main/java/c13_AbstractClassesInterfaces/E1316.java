/*
(Create a rational-number calculator) Write a program similar to Listing 7.9,
Calculator.java. Instead of using integers, use rationals, as shown in Figure 13.10.
You will need to use the split method in the String class, introduced in
Section 10.10.3, Replacing and Splitting Strings, to retrieve the numerator string
and denominator string, and convert strings into integers using the Integer
. parseInt method.
Figure 13.10 (a) The program takes a string argument that consists of operand1, operator, and
operand2 from the command line and displays the expression and the result of the arithmetic
operation. (b) A complex number can be interpreted as a point in a plane
*/
public class E1316 {
    public static void main(String[] args) {
        // Check number of strings passed
            if (args.length != 3) {
            System.out.println("Usage: java Calculator RationalNumber a/b operator RationalNumber c/d");
            System.exit(1);
            }
            
            String s1= args[0].split("[/]")[0];
            checkDigit(s1);
            String s2= args[0].split("[/]")[1];
            checkDigit(s2); 
            String s3= args[2].split("[/]")[0];
            checkDigit(s3);
            String s4= args[2].split("[/]")[1];
            checkDigit(s4);

            Rational r1 = new Rational(Integer.parseInt(s1), Integer.parseInt(s2));
            Rational r2 = new Rational(Integer.parseInt(s3), Integer.parseInt(s4));
            
            Rational result = new Rational();
            switch (args[1].charAt(0)) {
                case '+': result = r1.add(r2); break;
                case '-': result = r1.subtract(r2); break;
                case '.': result = r1.multiply(r2); break;
                case '/': result = r1.divide(r2);
            }
            
                System.out.println(args[0] + ' ' + args[1] + ' ' + args[2] + " = " + result.toString());
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
    private long[] r = new long[2];

    //Constructor
    public Rational() {
        this (0,1);
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
