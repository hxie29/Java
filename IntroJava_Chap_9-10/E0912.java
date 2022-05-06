
/*(Geometry: intersecting point) Suppose two line segments intersect. The two endpoints
for the first line segment are (x1, y1) and (x2, y2) and for the second line
segment are (x3, y3) and (x4, y4). Write a program that prompts the user to enter
these four endpoints and displays the intersecting point. As discussed in Programming
Exercise 3.25, the intersecting point can be found by solving a linear equation.
Use the LinearEquation class in Programming Exercise 9.11 to solve this
equation. See Programming Exercise 3.25 for sample runs.

The intersecting point of the two lines can be found by solving the following linear
equations:
(y1 - y2)x - (x1 - x2)y = (y1 - y2)x1 - (x1 - x2)y1
(y3 - y4)x - (x3 - x4)y = (y3 - y4)x3 - (x3 - x4)y3

Enter x1, y1, x2, y2, x3, y3, x4, y4: 2 2 5 -1.0 4.0 2.0 -1.0 -2.0
The intersecting point is at (2.88889, 1.1111)

Enter x1, y1, x2, y2, x3, y3, x4, y4: 2 2 7 6.0 4.0 2.0 -1.0 -2.0
The two lines are parallel
*/
import java.util.Scanner;
public class E0912 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the two points for the first segement (x1, y1), (x2, y2):");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        System.out.println("Enter the two points for the second segement (x3, y3), (x4, y4):");
        double x3 = input.nextDouble();
        double y3 = input.nextDouble();
        double x4 = input.nextDouble();
        double y4 = input.nextDouble();

        double a = y1 - y2;
        double b = x2- x1;
        double c = (y1 - y2) * x1 - (x1- x2) * y1;
        double d = y3 - y4;
        double e = x4- x3;
        double f = (y3 - y4) * x3 - (x3- x4) * y3;

        LinearEquation equation = new LinearEquation(a, b, c, d, e, f);
        if (equation.isSolvable())
            System.out.println("The intersecting point is (" + equation.getX() + ", " + equation.getY() + ").");
        else System.out.println("The two lines are parralel");
        input.close();
    }
}

class LinearEquation {
    //Data fields
    private double a;
    private double b;
    private double c;
    private double d;
    private double e;
    private double f;

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
        if (a* d - b * c != 0) return true;
        else return false;
    }

    public double getX(){
        return (e * d - b * f)/ (a * d - b * c);
    }
    public double getY(){
        return (a * f - e * c)/ (a * d - b * c);
    }
}
