package c32_Muiltithreading;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

public class ParallelSum {
    public static double parallelSum(double[] list) {
        RecursiveTask<Double> task = new SumTask(list);
        ForkJoinPool pool = new ForkJoinPool();
        return pool.invoke(task);
    }

    private static class SumTask extends RecursiveTask<Double> {
        private final double[] list;
        private final int low;
        private final int high;

        private static final int THRESHOLD = 500;
        public SumTask(double[] list) {
            this(list, 0, list.length-1);
        }

        public SumTask(double[] list, int low, int high) {
            this.list = list;
            this.low = low;
            this.high = high;
        }

        @Override
        protected Double compute() {
            if (high - low < THRESHOLD) {
                double sum = 0;
                for (int i = low; i <= high; i++) {
                    sum+= list[i];
                }
                return sum;
            }
            else{
                int mid = (low + high)/2;
                SumTask task1 = new SumTask(list, low, mid);
                SumTask task2 = new SumTask(list, mid+1, high);
                // asynchronized execution of task1
                task1.fork();
                // compute task2 (recursively) and add the return value of task1
                return task2.compute() + task1.join();
            }
        }
    }
}
