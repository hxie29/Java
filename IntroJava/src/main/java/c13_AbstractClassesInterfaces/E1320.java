/* 
(Algebra: solve quadratic equations) Rewrite Programming Exercise 3.1 to obtain
imaginary roots if the determinant is less than 0 using the Complex class in
Programming Exercise 13.17. Here are some sample runs:
Enter a, b, c: 1 2 1
The root is –1
Enter a, b, c: 1 2 3
The roots are –1.0 + 1.4142i and –1.0 + –1.4142i
 */
import java.util.Scanner;

public class E1317 {
    public static void main(String[] args){

        Scanner input = new Scanner(System.in);
        System.out.println("Please enter the value for a, b, c of quadratic equations ax^2 + bx + c =0 :");
        double a = input.nextDouble();
        double b = input.nextDouble();
        double c = input.nextDouble();
        double discriminant = b * b - 4 * a * c ;

        if (discriminant > 0) {
            double r1 = (-1 * b + Math.pow(discriminant, 0.5)) / 2 / a;
            double r2 = (-1 * b - Math.pow(discriminant, 0.5)) / 2 / a;
            System.out.println("The solutions to the equation is: r1 = " + r1 + " ; r2 = " + r2);
        }
        else if (discriminant == 0) {
            double r = -1 * b / 2 / a;
            System.out.println("The solution to the equation is: r = " + r);
        }
        else {
            double imaginary = Math.pow((Math.abs(discriminant)), 0.5) / 2 / a;
            Complex r1 = new Complex((-1 * b / 2 / a),imaginary);
            Complex r2 = new Complex((-1 * b / 2 / a),(imaginary * -1));
            System.out.println("The solutions to the equation is: r1 = " + r1.toString() + " ; r2 = " + r2.toString());
        }
        input.close();


        Complex c1 = new Complex(3.5,5.5);
        Complex c2 = new Complex(-3.5,1);

    }
}

class Complex implements Comparable<Complex>, Cloneable{
    private double a;
    private double b;

    //Constructor
    public Complex(){
        this(0,0);
    }

    public Complex(double a){
        this(a,0);
    }

    public Complex(double a, double b) {
        this.a = a;
        this.b = b;
    }

    //Methods
    public double getRealPart(){
        return a;
    }

    public double getImaginaryPart(){
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
        return (this.abs() > n.abs()) ? 1 : ((this.abs() < n.abs()) ? -1 : 0);
    }

    @Override
    public Object clone() {
        try{
            return super.clone();
        }
        catch (CloneNotSupportedException ex) {
            return null;
        }
    }
}
