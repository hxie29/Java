package c09_ObjectsClasses;

public class QuadraticEquation {
    //Data fields
    private final double a;
    private final double b;
    private final double c;

    //Constructor
    public QuadraticEquation(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
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

    public double getDiscriminant(){
        return b * b - 4 * a * c;
    }

    public double getRoot1(){
        if (this.getDiscriminant() < 0) return 0;
        else return (-1 * b + Math.pow(this.getDiscriminant(), 0.5)) / 2 /a;
    }
    public double getRoot2(){
        if (this.getDiscriminant() < 0) return 0;
        else return (-1 * b - Math.pow(this.getDiscriminant(), 0.5)) / 2 /a;
    }
}
