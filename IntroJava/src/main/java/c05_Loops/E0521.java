package c05_Loops;

import java.util.Scanner;

public class E0521 {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        
    
        System.out.println("Enter loan amount:");
        double loan = input.nextDouble();

        System.out.println("Enter the number of years:");
        int numberOfYears = input.nextInt();

        // print out title
        System.out.printf("%-20s %-20s %-20s\n", "Interest Rate", "Monthly Payment", "Total Payment");

        // print out each year's item using loop
        for (int step = 0; step <= 20; step++) {
            double annualRate = (5 + 0.25 * step);
            double monthRate = annualRate / 100 / 12;
            double monthPayment = loan * monthRate / (1 - 1 / Math.pow((1 + monthRate), (numberOfYears * 12)) );
            double totalPay = monthPayment * 12 * numberOfYears;
            // formatting is still not correct!
            System.out.printf("%-4.3f %-16s %-20.2f %-18.2f \n", annualRate, "%", monthPayment, totalPay);
        }
        input.close();
    }    
}