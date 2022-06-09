package c13_AbstractClassesInterfaces;

class Rational3 extends Number implements Comparable<Rational3> {
    private final long[] r = new long[2];

    //Constructor
    public Rational3() {
        this(0, 1);
    }

    public Rational3(long numerator, long denominator) throws IllegalArgumentException {
        if (denominator == 0)
            throw new IllegalArgumentException("Denominator cannot be zero.");
        else {
            int gcd = gcd(numerator, denominator);
            r[0] = ((denominator > 0) ? 1 : -1) * numerator / gcd;
            r[1] = Math.absExact(denominator) / gcd;
        }
    }

    private static int gcd(long n1, long n2) {
        int gcd = 1;
        for (int k = 1; k <= n1 && k <= n2; k++) {
            if ((n1 % k == 0) && (n2 % k == 0)) {
                gcd = k;
            }
        }
        return gcd;
    }

    public long getNumerator() {
        return r[0];
    }

    public long getDenominator() {
        return r[1];
    }

    public Rational3 add(Rational3 a) {
        long numerator = a.getDenominator() * getNumerator() + a.getNumerator() * getDenominator();
        long denominator = a.getDenominator() * getDenominator();
        return new Rational3(numerator, denominator);
    }

    public Rational3 subtract(Rational3 a) {
        long numerator = a.getDenominator() * getNumerator() - a.getNumerator() * getDenominator();
        long denominator = a.getDenominator() * getDenominator();
        return new Rational3(numerator, denominator);
    }

    public Rational3 multiply(Rational3 a) {
        long numerator = a.getNumerator() * getNumerator();
        long denominator = a.getDenominator() * getDenominator();
        return new Rational3(numerator, denominator);
    }

    public Rational3 divide(Rational3 a) {
        long numerator = getNumerator() * a.getDenominator();
        long denominator = getDenominator() * a.getNumerator();
        return new Rational3(numerator, denominator);
    }

    @Override
    public String toString() {
        if (r[0] == 0 || r[1] == 1) return r[0] + "";
        else return r[0] + "/" + r[1];
    }

    @Override
    public int compareTo(Rational3 a) {
        return (this.subtract(a).getNumerator() > 0) ? 1 : ((this.subtract(a).getNumerator() < 0) ? -1 : 0);
    }

    @Override
    public boolean equals(Object o) {
        if (o != null)
            return this.subtract((Rational3) o).getNumerator() == 0;
        else return false;
    }

    @Override
    public int intValue() {
        return (int) doubleValue();
    }

    @Override
    public double doubleValue() {
        return r[0] * 1.0 / r[1];
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
