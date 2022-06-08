package c08_MultidimensionArrays;/*
(Financial application: compute tax) Rewrite Listing 3.5, ComputeTax.java,
using arrays. For each filing status, there are six tax rates. Each rate is applied
to a certain amount of taxable income. For example, from the taxable income of
$400,000 for a single filer, $8,350 is taxed at 10%, (33,950 - 8,350) at 15%,
*/
import java.util.Scanner;

public class E0812 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        double[] rates = {0.1, 0.15, 0.25, 0.28, 0.33, 0.35};
        int[][] brackets = {
            {8350, 33950, 82250, 171550, 372950}, // Single filer
            {16700, 67900, 137050, 20885, 372950}, // Married jointly  −or qualifying widow(er)
            {8350, 33950, 68525, 104425, 186475}, // Married separately
            {11950, 45500, 117450, 190200, 372950} // Head of household
            };

        System.out.println("(0-single filer, 1-married jointly or " + "qualifying widow(er), 2-married separately, 3-head of " + "household) Enter the filing status:");
        int status = input.nextInt();
        System.out.println("Enter the taxable income: ");
        double income = input.nextDouble();
        double tax = computeTax(status, income, rates, brackets);
        System.out.println("Tax is " + tax);
        input.close();
    }

    public static double computeTax(int status, double income, double[] rates, int[][] brackets) {
        double tax = 0;
        double incomeTaxed;
        for (int i = 4; i >= 0; i--) {
            if (income > brackets[status][i]) {
                incomeTaxed = income - brackets[status][i];
                tax += incomeTaxed * rates[i+1];
                income -= incomeTaxed;
            }
        }
        tax += brackets[status][0] * rates[0];
        return tax;
    }
}
