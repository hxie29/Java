/*the well-known Eratosthenes algorithm for finding prime numbers. Eratosthenes (276–194 b.c.) was a Greek mathematician
who devised a clever algorithm, known as the Sieve of Eratosthenes, for finding all prime
numbers … n. His algorithm is to use an array named primes of n Boolean values. Initially,
all elements in primes are set true. Since the multiples of 2 are not prime, set primes[2 * i]
to false for all 2 … i … n/2, as shown in Figure 22.3. Since we don’t care about primes[0]
and primes[1], these values are marked * in the figure. */
package c22_EfficientAlgorithms;

import java.util.Arrays;
import java.util.Scanner;

public class E22L07 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Find all prime numbers <= n, enter n:");
        int n = input.nextInt();
        final int PER_LINE = 10;
        int count = 0;

        boolean[] prime = new boolean[n + 1];
        Arrays.fill(prime, true);
        System.out.println("The prime numbers are: ");

        // the theoretical complexity is O(n * sqrt(n) / log(n)), in practical it's much better than theoretical
        for (int i = 2; i <= n / i; i++) {
            if (prime[i]) {
                for (int k = i; k <= n / i; k++) {
                    prime[i * k] = false;
                }
            }
        }

        for (int i = 2; i < prime.length; i++) {
            if (prime[i]) {
                count++;
                System.out.print((count % PER_LINE == 0) ? "\n" : "" + i + "\t");
            }
        }
    }

}
