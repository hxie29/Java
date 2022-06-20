//Find GCD from the largest factor to 1
package c22_EfficientAlgorithms;

import java.util.Scanner;

public class E22L03 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first integer:");
        int m = input.nextInt();
        System.out.println("Enter the second integer:");
        int n = input.nextInt();
        System.out.println("GCD is " + findGCD(m,n));

    }
    //  complexity = O(n);
    private static int findGCD(int m, int n) {
        int gcd = 1;
        if (m % n == 0)
            return n;

        for (int k = n /2; k>= 1; k--) {
            if (n % k == 0 && m % k == 0)
                gcd = k;
        }
        return gcd;
    }
}
