/*In fact, we can prove that if n is not a prime, n must have a factor that is greater than
1 and less than or equal to 2n. Here is the proof. Since n is not a prime, there exist two
numbers p and q such that n = pq with 1 6 p … q. Note that n = 2n 2n. p must be
less than or equal to 2n. Hence, you need to check only whether 2, 3, 4, 5, . . . , or 2n
divides n. If not, n is prime. This significantly reduces the time complexity of the algorithm
to O(sqrt(n))*/
package c22_EfficientAlgorithms;

import java.util.Scanner;

public class E22L05 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Find all prime numbers <= n, enter n:");
        int n = input.nextInt();
        input.close();

        final int PER_LINE = 10;
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
            for (int i = 2; i <= root; i++) {
                if (number % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                count++;
                System.out.print((count % PER_LINE == 0) ? "\n" : "" + number + "\t");
            }
            number++;
        }
    }

}
