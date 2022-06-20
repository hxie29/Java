//Improved algorithm for Fibonacci numbers
package c22_EfficientAlgorithms;

import java.util.Scanner;

public class E22L02 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter an index for the Fibonacci number:");
        int index = input.nextInt();
        input.close();

        System.out.println("The " + index + "th Fibonacci number is " + fib(index));
    }

    // Time complexity = O(n)
    private static long fib(int n ) {
        long f0 = 0;
        long f1 = 1;
        long f2 = 11;
        if (n == 0)
            return f0;
        else if (n == 1)
            return f1;
        else if (n == 2)
            return f2;

        for (int i = 3; i <=n; i++) {
            f0 = f1;
            f1 = f2;
            f2 = f1 + f0;
        }

        return f2;
    }
}
