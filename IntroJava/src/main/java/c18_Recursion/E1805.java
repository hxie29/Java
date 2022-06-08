/*The previous method is probably not efficient if you wrote it exactly as its recursive
definition. It is not because the method is recursive but because it has not
been well-written. It is quite easy to verify that there is another recurrent definition
of C(n, p), which is C(n, 0) = C(n, n) = 1, otherwise C(n, p) = C(n, p - 1) *
(n - p + 1) /p. Keeping this in mind, write the previous method.*/
package com.example.recursion;

public class E1805 {
    public static void main(String[] args) {
        System.out.println(combination(6, 3));
    }

    private static long combination(long n, long p) {
        if (n < p)
            return -1;
        else if (p == 0 || p == n)
            return 1;
        else
            return combination(n, p-1) * (n - p + 1) / p;
    }
}
