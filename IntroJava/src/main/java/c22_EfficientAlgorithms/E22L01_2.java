// Example 7: computation of a^n for an integer n, different algorithms
package c22_EfficientAlgorithms;

public class E22L01_2 {
    public static void main(String[]args) {
        compute1(2,1200);
        compute2(2,1200);
        compute3(2,1201);
    }

    private static void compute1(int a, int n) {
        long result = 1;
        long startTime = System.currentTimeMillis();
        for (int i = 1; i <=n; i++) {
            result *= a;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time used for complexity of O(n) is " + (endTime - startTime) + " milliseconds.");
    }
    private static void compute2(int a, int n) {
        long result = a;
        long k = (long) (Math.log(n) / Math.log(2));
        long startTime = System.currentTimeMillis();
        for (int i = 1; i <=k; i++) {
            result *= result;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time used for complexity of O(logN) is " + (endTime - startTime) + " milliseconds.");
    }
    private static void compute3(int a, int n) {
        long result = a;
        long startTime = System.currentTimeMillis();
        for (int i = 1; i <= n; i++) {
            if (n % 2 == 0) {
                result *= result;
                n /= 2;
            }
            else {
                result = a * result * result;
                n /= 2;
            }

        }
        long endTime = System.currentTimeMillis();
        System.out.println("Time used for complexity of O(logN) is " + (endTime - startTime) + " milliseconds.");
    }
//Answer - recursive
    public static int f(int a, int n) {
        if (n == 1) {
            return a;
        }
        else {
            int temp = f(a, n / 2);
            if (n % 2 == 0) {
                return temp * temp;
            }
            else {
                return a * temp * temp;
            }
        }
    }

}
