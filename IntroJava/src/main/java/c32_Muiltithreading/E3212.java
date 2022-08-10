/*(Parallel array initializer) Implement the following method using the Fork/Join
Framework to assign random values to the list.
public static void parallelAssignValues(double[] list)
Write a test program that creates a list with 9,000,000 elements and invokes
parallelAssignValues to assign random values to the list. Also implement a
sequential algorithm and compare the execution time of the two. Note if you use
Math.random(), your parallel code execution time will be worse than the sequential
code execution time because Math.random() is synchronized and cannot be
executed in parallel. To fix this problem, create a Random object for assigning
random values to a small list.*/

package c32_Muiltithreading;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class E3212 {
    public static void main(String[] args){
        final int N = 9999999;
        double[] list = new double[N];

        long startTime = System.currentTimeMillis();
        for (int i = 0; i < list.length; i++)
            list[i] = Math.random() * 1000000;
        long endTime = System.currentTimeMillis();
        System.out.println("Sequential time is " + (endTime - startTime));

        startTime = System.currentTimeMillis();
        parallelAssignValues(list);
        endTime = System.currentTimeMillis();
        System.out.println("Parallel time is " + (endTime - startTime) +
                ". With processors: " + Runtime.getRuntime().availableProcessors());
    }

    public static void parallelAssignValues(double[] list) {
        RecursiveAction task = new ParallelAssign(list, 0, list.length);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);
    }

    public static class ParallelAssign extends RecursiveAction {
        private final static int THRESHOLD = 10000;
        private final double[] list;
        private final int low;
        private final int high;
        public ParallelAssign(double[] list, int low, int high) {
            this.high = high;
            this.low = low;
            this.list = list;
        }

        @Override
        protected void compute() {
            Random random = new Random();
            if (high - low < THRESHOLD) {
                for (int i = low; i < high; i++) {
                    list[i] = random.nextDouble();
                }
            }
            else {
                int mid = (low + high)/2;
                invokeAll(new ParallelAssign(list, low, mid), new ParallelAssign(list, mid, high));
            }
        }
    }
}
