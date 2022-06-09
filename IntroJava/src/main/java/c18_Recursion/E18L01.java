//Compute factorial
package c18_Recursion;

import java.util.Scanner;

public class E18L01 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a nonnegative integer:");
        int n = input.nextInt();

        System.out.printf("Factorial of %d is %d", n, factorial(n));
    }

    public static long factorial(int n) {
        if (n == 0)
            return 1;
        else
            return n * factorial(n-1);
    }

}
