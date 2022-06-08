package c03_Selections;

import java.util.Scanner;

public class E0331 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        //enter the exchange rate
        System.out.println("Please enter the exchange rate: ");
        double exchangeRate = input.nextDouble();

        //choose the conversion direction
        System.out.println("Enter 0 to convert dollars to RMB and 1 vice versa: ");
        double convert = input.nextDouble();

        // calculate currency
        if (convert == 0) {
            System.out.println("Enter the dollar amount: ");
            double dollar = input.nextDouble();
            double rmb = dollar * exchangeRate;
            System.out.println("$" + dollar + " is " + rmb + " yuan.");
        }
        else if (convert == 1) {
            System.out.println("Enter the RMB amount: ");
            double rmb = input.nextDouble();
            double dollar = rmb / exchangeRate;
            System.out.println(rmb + " yuan is $" + dollar + ".");
        }
        else System.out.println("Invalid input.");

        // close input
        input.close();
    }
}
