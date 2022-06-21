/*(Execution time for GCD) Write a program that obtains the execution time for
finding the GCD of every two consecutive Fibonacci numbers from the index
46 to index 50 using the algorithms in Listings 22.3 and 22.4. Your program
should print a table like this:
                          46       47      48      49      50
Listing 22.3 GCD
Listing 22.4 GCDEuclid
*/

package c22_EfficientAlgorithms;

public class E2206 {
    public static void main(String[] args) {
        long[] numbers = {fib(46), fib(47), fib(48), fib(49), fib(50)};
        long[] timeGCD = {getTime(numbers[1], numbers[0]), getTime(numbers[2], numbers[1]), getTime(numbers[3], numbers[2]), getTime(numbers[4], numbers[3])};
        long[] timeEuclidGCD = {getTimeEuc(numbers[1], numbers[0]), getTimeEuc(numbers[2], numbers[1]), getTimeEuc(numbers[3], numbers[2]), getTimeEuc(numbers[4], numbers[3])};
        System.out.printf("%-20s | %-5d %-5d %-5d %-5d %-5d\n"," ", numbers[0], numbers[1], numbers[2], numbers[3], numbers[4]);
        System.out.printf("%-20s | %-10d %-10d %-10d %-10d\n","GCD", timeGCD[0], timeGCD[1], timeGCD[2], timeGCD[3]);
        System.out.printf("%-20s | %-10d %-10d %-10d %-10d\n","EuclidGCD", timeEuclidGCD[0], timeEuclidGCD[1], timeEuclidGCD[2], timeEuclidGCD[3]);
    }

    private static long getTime(long m, long n) {
        long startTime = System.currentTimeMillis();
        long gcd = findGCD(m, n);
        return System.currentTimeMillis() - startTime;
    }
    // finding GCD from the largest factor to 1, complexity O(n)
    private static long findGCD(long m, long n) {
        long gcd = 1;
        if (m % n == 0)
            return n;

        for (long k = n /2; k>= 1; k--) {
                if (n % k == 0 && m % k == 0)
                    gcd = k;
        }

        return gcd;
    }

    private static long getTimeEuc(long m, long n) {
        long startTime = System.currentTimeMillis();
        long gcd = euclidGCD(m, n);
        return System.currentTimeMillis() - startTime;
    }

    // Euclid's algorithm, complexity = O(log(n));
    private static long euclidGCD(long m, long n) {
        if (m % n == 0)
            return n;

        else
            return euclidGCD(n, m % n);
    }
    private static long fib(int n) {
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
