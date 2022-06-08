package c04_FunctionsCharString;

import java.util.Scanner;

public class E0406 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a radius of the circle: ");
        double r = input.nextDouble();

        double angle1 = Math.random() * 2 * Math.PI;
        double x1 = r * Math.cos(angle1);
        double y1 = r * Math.sin(angle1);
        System.out.println("The first random point in a circle is " + x1 + ", " + y1);
        
        double angle2 = Math.random() * 2 * Math.PI;
        double x2 = r * Math.cos(angle2);
        double y2 = r * Math.sin(angle2);
        System.out.println("The second random point in a circle is " + x2 + ", " + y2);
        
        double angle3 = Math.random() * 2 * Math.PI;
        double x3 = r * Math.cos(angle3);
        double y3 = r * Math.sin(angle3);
        System.out.println("The third random point in a circle is " + x3 + ", " + y3);

        double s1 = Math.sqrt( (x1 - x2) * (x1 - x2) + (y1 -y2) * (y1 - y2) );
        double s2 = Math.sqrt( (x1 - x3) * (x1 - x3) + (y1 -y3) * (y1 - y3) );
        double s3 = Math.sqrt( (x3 - x2) * (x3 - x2) + (y3 -y2) * (y3 - y2) );

        double a1 = Math.toDegrees(Math.acos( (s1 * s1 - s2 * s2 - s3 * s3) / (-2 * s2 * s3)) );
        double a2 = Math.toDegrees(Math.acos( (s2 * s2 - s1 * s1 - s3 * s3) / (-2 * s1 * s3)) );
        double a3 = Math.toDegrees(Math.acos( (s3 * s3 - s2 * s2 - s1 * s1) / (-2 * s2 * s1)) );

        double total = a1 + a2 + a3;

        System.out.println("The three angles of a random triangle is " + a1 + ", " + a2 + ", " + a3);
        System.out.println(total);

        input.close();
    }
}
