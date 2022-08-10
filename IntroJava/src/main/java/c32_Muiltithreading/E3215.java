package c32_Muiltithreading;


public class E3215 {
    public static void main(String[] args) {
        final int SIZE = 7000000;
        double[] list1 = new double[SIZE];

        for (int i = 0; i < list1.length; i++)
            list1[i] = Math.random() * 1000;

        long startTime = System.currentTimeMillis();
        double sum1 = ParallelSum.parallelSum(list1);
        long endTime = System.currentTimeMillis();
        System.out.println("\nParallel time with " + Runtime.getRuntime().availableProcessors() +
                " processors is " + (endTime - startTime) + " milliseconds");

        double sum2 = 0;
        startTime = System.currentTimeMillis();
        for (double v : list1) {
            sum2 += v;
        }

        endTime = System.currentTimeMillis();
        System.out.println("\nSequential time is " + (endTime - startTime) + " milliseconds");

        System.out.println("Parallel sum result: " + sum1);
        System.out.println("Sequential sum result: " + sum2);
    }
}
