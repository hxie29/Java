//Performance test
package c22_EfficientAlgorithms;

public class E22L01 {
    public static void main(String[] args) {
        getTime(1000000);
        getTime(10000000);
        getTime(100000000);
        getTime(1000000000);
    }

    private static void getTime(int n) {
        long startTime = System.currentTimeMillis();
        long k = 0;
        for (long i = 1; i <= n; i++) {
            k +=5;
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Execution time for n = " + n + " is " + (endTime - startTime) + " milliseconds");
    }
}
