package c04_FunctionsCharString;

import java.util.Scanner;

public class E0405 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the side of a polygon: ");
        double s = input.nextDouble();
        System.out.println("Enter the number of sides: ");
        double n = input.nextDouble();

        double area = n * s * s / 4 / Math.tan(Math.PI / n);
        
        System.out.println("The area of the pentagon is " + (int)(area * 100) / 100.0);

        input.close();
    }
}

