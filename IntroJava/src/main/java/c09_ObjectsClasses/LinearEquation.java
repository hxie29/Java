package c09_ObjectsClasses;

public class LinearEquation {
    //Data fields
    private final double a;
    private final double b;
    private final double c;
    private final double d;
    private final double e;
    private final double f;

    //Constructor
    public LinearEquation(double a, double b, double c, double d, double e, double f){
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.f = f;
    }

    //Methods
    public double getCoefficientA() {
        return a;
    }
    public double getCoefficientB() {
        return b;
    }
    public double getCoefficientC() {
        return c;
    }
    public double getCoefficientD() {
        return a;
    }
    public double getCoefficientE() {
        return b;
    }
    public double getCoefficientF() {
        return c;
    }

    public boolean isSolvable(){
        return a * d - b * c != 0;
    }

    public double getX(){
        return (e * d - b * f)/ (a * d - b * c);
    }
    public double getY(){
        return (a * f - e * c)/ (a * d - b * c);
    }
}
