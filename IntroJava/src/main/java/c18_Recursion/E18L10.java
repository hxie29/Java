//Compute factorial with TAIL recursive
package c18_Recursion;

import java.util.Scanner;

public class E18L10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a non-negative integer:");
        int n = input.nextInt();

        System.out.printf("Factorial of %d is %d", n, factorial(n, 1)); //alternative factorial(n);
    }

    public static long factorial(int n, long result) {
        if (n == 0)
            return result;
        else
            return factorial(n-1, n * result); // Tail recursion
            // alternative
            // return n * factorial(n-1);
    }

}
