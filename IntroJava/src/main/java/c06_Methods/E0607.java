package c06_Methods;

import java.util.Scanner;

public class E0607 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the investment amount, annual interest rate%, and duration:");
        double amount = input.nextDouble();
        double monthlyRate = input.nextDouble() / 100 / 12;
        double year = input.nextDouble();

        futurePV(amount, monthlyRate, year);
        input.close();
    }

    public static void futurePV(double amount, double monthlyRate, double year) {
        System.out.printf("%-10s%15s\n", "Year", "Future Value");
        for (int i = 1; i <= year; i++) {
            double futureValue = amount * Math.pow((1 + monthlyRate), (12 * i));
            System.out.printf("%-10d%15.2f\n", i, futureValue);
        }
    }
}
