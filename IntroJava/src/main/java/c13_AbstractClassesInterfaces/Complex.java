package c13_AbstractClassesInterfaces;

class Complex implements Comparable<Complex>, Cloneable {
    private final double a;
    private final double b;

    //Constructor
    public Complex() {
        this(0, 0);
    }

    public Complex(double a) {
        this(a, 0);
    }

    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }

    //Methods
    public double getRealPart() {
        return a;
    }

    public double getImaginaryPart() {
        return b;
    }

    public Complex add(Complex c) {
        return new Complex(a + c.getRealPart(), b + c.getImaginaryPart());
    }

    public Complex subtract(Complex c) {
        return new Complex(a - c.getRealPart(), b - c.getImaginaryPart());
    }

    public Complex multiply(Complex c) {
        double real = a * c.getRealPart() - b * c.getImaginaryPart();
        double imaginary = b * c.getRealPart() + a * c.getImaginaryPart();
        return new Complex(real, imaginary);
    }

    public Complex divide(Complex c) {
        double real = (a * c.getRealPart() + b * c.getImaginaryPart()) / (c.getRealPart() * c.getRealPart() + c.getImaginaryPart() * c.getImaginaryPart());
        double imaginary = (b * c.getRealPart() - a * c.getImaginaryPart()) / (c.getRealPart() * c.getRealPart() + c.getImaginaryPart() * c.getImaginaryPart());
        return new Complex(real, imaginary);
    }

    public double abs() {
        return Math.pow((a * a + b * b), 0.5);
    }

    //Overrude methods
    @Override
    public String toString() {
        if (b == 0) return a + "";
        else if (a == 0) return b + "i";
        else return a + " + " + b + "i";
    }

    @Override
    public int compareTo(Complex n) {
        return Double.compare(this.abs(), n.abs());
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ex) {
            return null;
        }
    }
}
