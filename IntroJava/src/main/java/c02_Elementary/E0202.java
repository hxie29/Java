package c02_Elementary;

import java.util.Scanner;

public class E0202 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);  
        System.out.println("Please enter the side leangth of an equilateral triangle: ");
        double side = input.nextDouble();
        double area = (Math.pow(3, 0.5) / 4) * side * side;
        double volumn = area * side;
        System.out.println("The area of triangle with the side length of " + side + " is " + (int)(area * 100) / 100.0 );
        System.out.println("The volumn of triangle with the side length of " + side + " is " + (int)(volumn * 100) / 100.0 );
        input.close();
    }
}
