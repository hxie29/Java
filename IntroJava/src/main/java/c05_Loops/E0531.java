package c05_Loops;

import java.util.Scanner;

public class E0531 {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);

        // input
        System.out.println("Enter the deposit:");
        double value = input.nextDouble();
        System.out.println("Enter the maturity period - number of months:");
        int numberOfMonth = input.nextInt();
        System.out.println("Enter the annual interest rate%:");
        double monthInterest = input.nextDouble() / 100 / 12;

        // print out title row
        System.out.printf("%-10s%-10s\n", "Month", "CD Value");

        // print out each month value
        for (int n = 1; n <= numberOfMonth; n++) {
            value *= (1 + monthInterest);
            System.out.printf("%-10d%-10.2f\n", n, value);
        }

        input.close();
    }    
}
