package c05_Loops;

import java.util.Scanner;

public class E0522 {
    public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        
        //input
        System.out.println("Enter loan amount:");
        double loan = input.nextDouble();
        System.out.println("Enter the number of years:");
        int numberOfYears = input.nextInt();
        System.out.println("Enter the interest rate:");
        double annualRate = input.nextDouble();
        
        // calculate monthly payment and total payment
        double monthRate = annualRate / 100 / 12;
        double monthPayment = loan * monthRate / (1 - 1 / Math.pow((1 + monthRate), (numberOfYears * 12)) );
        double totalPay = monthPayment * 12 * numberOfYears;

        // print out payment
        System.out.printf("%-18s%8.2f\n", "Monthly Payment:", monthPayment);
        System.out.printf("%-18s%8.2f\n", "Total Payment:", totalPay);
        System.out.println();

        // print out title
        System.out.printf("%-10s%-10s%-10s%-10s\n", "Payment#", "Interest", "Principle", "Balance");

        double balance = loan;
        // print out each year's item using loop
        for (int payment = 1; payment <= 12 * numberOfYears; payment++) {
            double interest = monthRate * balance;
            double principle = monthPayment - interest;
            balance -= principle;
            // formatting is still not correct!
            System.out.printf("%-10d%-10.2f%-10.2f%10.2f\n", payment, interest, principle, balance);
        }
        input.close();
    }    
}