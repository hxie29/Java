package c02_Elementary;

import java.util.Scanner;
public class E0219 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Plase enter the coordinate of the first point: ");
        double x1 = input.nextDouble();
        double y1 = input.nextDouble();
        System.out.println("Plase enter the coordinate of the second point: ");
        double x2 = input.nextDouble();
        double y2 = input.nextDouble();
        System.out.println("Plase enter the coordinate of the third point: ");
        double x3 = input.nextDouble();
        double y3 = input.nextDouble();

        double s1 = Math.pow( (Math.pow((x1 - x2), 2) + Math.pow((y1-y2),2)) , 0.5);
        double s2 = Math.pow( (Math.pow((x1 - x3), 2) + Math.pow((y1-y3),2)) , 0.5);
        double s3 = Math.pow( (Math.pow((x3 - x2), 2) + Math.pow((y3-y2),2)) , 0.5);

        double s = (s1 + s2 + s3) / 2;
        double area = Math.pow((s * (s-s1) * (s -s2) * (s-s3)), 0.5);
        System.out.println("The side 1 length is " + (int)(s1 * 100) / 100.0);
        System.out.println("The side 2 length is " + (int)(s2 * 100) / 100.0);
        System.out.println("The side 3 length is " + (int)(s3 * 100) / 100.0);
        System.out.println("The area of the triangle is " + (int)(area * 100) / 100.0);
        input.close();
    }
}
