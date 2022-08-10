package c32_Muiltithreading;

import c23_Sorting.QuickSort;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class ParallelQuickSort {
    public static void parallelQuickSort(int[] list) {
        RecursiveAction task = new ParallelQuickSortTask(list);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(task);
    }

    public static class ParallelQuickSortTask extends RecursiveAction {
        private final int[] list;

        private final int low;
        private final int high;
        private final static int THRESHOLD = 500;

        public ParallelQuickSortTask(int[] list) {
            this(list, 0, list.length-1);
        }

        public ParallelQuickSortTask(int[] list, int low, int high) {
            this.list = list;
            this.low = low;
            this.high = high;
        }

        @Override
        protected void compute() {
            if (high - low < THRESHOLD)
                QuickSort.quickSort(list, low, high);
            else {
                int pivotIndex = QuickSort.partition(list, low, high);
                invokeAll(new ParallelQuickSortTask(list, low, pivotIndex -1), new ParallelQuickSortTask(list, pivotIndex+1, high));
            }
        }
    }
}
