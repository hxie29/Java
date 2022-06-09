/*Combinations refer to the combination of n things taken p at a time without
repetition. A recursive definition of C(n, p) is C(n, 0) = C(n, n) = 1, otherwise
C(n, p) = C(n - 1, p) + C(n - 1, p - 1).
Write a method public static long C(long n, long p) that computes
and returns C(n, p).*/
package c18_Recursion;

public class E1804 {
    public static void main(String[] args) {
        System.out.println(combination(6, 3));
    }

    private static long combination(long n, long p) {
        if (n < p)
            return -1;
        else if (p == 0 || p == n)
            return 1;
        else
            return combination(n - 1, p) + combination(n-1, p-1);
    }
}
