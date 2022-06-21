/*(Efficient polynomial calculation) For a polynomial f(x) = anxn + an-1xn-1 +
an-2xn-2 + c + a1x + a0, write an efficient program that prompts the user
to enter the degree n, the coefficients a0 to an, and the value for x, and computes
and displays ƒ(x). Here is a sample run:
Enter n: 3
Enter x: 2
Enter a0: 1
Enter a1: 2
Enter a2: 3
Enter a3: 4
f(2.000000) = 49.000000 */
package c22_EfficientAlgorithms;

import java.util.Scanner;

public class E2202 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter n:");
        int n = input.nextInt();
        double[] coefficient = new double[n + 1];
        System.out.println("Enter x:");
        double x = input.nextDouble();
        for (int i = 0; i <= n; i++) {
            System.out.println("Enter a" + i);
            coefficient[i] = input.nextDouble();
        }

        double f = coefficient[n];
        //Compute
        for (int i = 1; i <= n; i++) {
            f = f * x + coefficient[n - i];
        }

        System.out.println("f(" + x + ") = " + f);
    }
}
