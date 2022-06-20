//Euclid's algorithm for finding GCD
/*It is not difficult to prove the correctness of this algorithm. Suppose m % n = r. Thus, m =
qn + r, where q is the quotient of m / n. Any number that divides m and n evenly must also
divide r evenly. Therefore, gcd(m, n) is the same as gcd(n, r), where r = m % n. */
package c22_EfficientAlgorithms;

import java.util.Scanner;

public class E22L04 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the first integer:");
        int m = input.nextInt();
        System.out.println("Enter the second integer:");
        int n = input.nextInt();
        input.close();

        System.out.println("GCD is " + euclidGCD(m,n));
    }
    // complexity = O(log(n));
    private static int euclidGCD(int m, int n) {
        if (m % n == 0)
            return n;

        else
            return euclidGCD(n, m % n);
    }
}
