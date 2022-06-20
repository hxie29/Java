/*We can prove that if i is not prime, there must exist a prime number p such that i = pq and
p <= q. Here is the proof. Assume i is not prime; let p be the smallest factor of i. p must be
prime, otherwise, p has a factor k with 2 <= k <p. k is also a factor of i, which contradicts that
p be the smallest factor of i. Therefore, if i is not prime, you can find a prime number from 2 to
sqrt(i) that is divisible by i. This leads to a more efficient algorithm for finding all prime numbers
up to n, as given in Listing 22.6. */
package c22_EfficientAlgorithms;

import java.util.ArrayList;
import java.util.Scanner;

public class E22L06 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Find all prime numbers <= n, enter n:");
        int n = input.nextInt();
        final int PER_LINE = 10;
        /*This algorithm is another example of dynamic programming. The algorithm stores the
        results of the sub problems in the array list and uses them later to check whether a new number
        is prime.*/
        ArrayList<Integer> prime = new ArrayList<>();
        int count = 0;
        int root = 0;
        int number = 2;

        System.out.println("The prime numbers are: ");

        while (number <= n) {
            boolean isPrime = true;
            //root = (int)Math.sqrt(number);
            //reduce the number of sqrt computations, O(n * sqrt(n))
            if (root * root < number)
                root++;

            // Test whether number is prime
            // use found prime numbers to divide number, until it's sqrt. if none is divisible, then this number is prime number
            // the complexity is O(n * sqrt(n) / log(n))
            for (int i = 0; i < prime.size() && prime.get(i) <= root; i++) {
                if (number % prime.get(i) == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                count++;
                prime.add(number);
                System.out.print((count % PER_LINE == 0) ? "\n" : "" + number + "\t");
            }
            number++;
        }
    }

}
