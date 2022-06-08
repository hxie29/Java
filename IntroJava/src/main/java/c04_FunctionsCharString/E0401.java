package c04_FunctionsCharString;

import java.util.Scanner;

public class E0401 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the length from the center of a pentagon to a vertex: ");
        double r = input.nextDouble();

        double s = 2 * r * Math.sin(Math.PI / 5);
        double area = 5 * s * s / 4 / Math.tan(Math.PI / 5);
        
        System.out.println("The area of the pentagon is " + (int)(area * 100) / 100.0);

        input.close();
    }
}
