package c03_Selections;

import java.util.Scanner;

public class E0301 {
    public static void main(String[] args) {
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
            System.out.println("There is no solution.");
        }
        input.close();
    }
}
