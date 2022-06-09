package c13_AbstractClassesInterfaces;/*
(Algebra: solve quadratic equations) Rewrite Programming Exercise 3.1 to obtain
imaginary roots if the determinant is less than 0 using the Complex class in
Programming Exercise 13.17. Here are some sample runs:
Enter a, b, c: 1 2 1
The root is –1
Enter a, b, c: 1 2 3
The roots are –1.0 + 1.4142i and –1.0 + –1.4142i
 */
import java.util.Scanner;

public class E1320 {
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
            System.out.println("The solutions to the equation is: r1 = " + r1 + " ; r2 = " + r2);
        }
        input.close();


        Complex c1 = new Complex(3.5,5.5);
        Complex c2 = new Complex(-3.5,1);

    }
}
