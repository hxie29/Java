//Parallel Merge sort
package c32_Muiltithreading;

import c23_Sorting.MergeSort;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class E32L10 {
    public static void main(String[] args) {
        final int SIZE = 1000000;
        int[] list1 = new int[SIZE];
        int[] list2 = new int[SIZE];

        for (int i = 0; i < list1.length; i++) {
            list1[i] = list2[i] = (int) (Math.random() * 10000000);
        }

        long startTime = System.currentTimeMillis();
        MergeSort.mergeSort(list2);
        long endTime = System.currentTimeMillis();
        System.out.println("\nSequential time is " + (endTime - startTime) + " milliseconds");

        startTime = System.currentTimeMillis();
        parallelMergeSort(list1);
        endTime = System.currentTimeMillis();
        System.out.println("\nParallel merge sort with " + Runtime.getRuntime().availableProcessors()
                + " processors, time is " + (endTime - startTime) + " milliseconds");
    }

    public static void parallelMergeSort(int[] list) {
        RecursiveAction mainTask = new SortTask(list);
        ForkJoinPool pool = new ForkJoinPool();
        pool.invoke(mainTask);
    }

    private static class SortTask extends RecursiveAction {
        private final static int THREADSHOLD = 500;
        private final int[] list;

        SortTask(int[] list) {
            this.list = list;
        }

        @Override
        protected void compute() {
            if (list.length < THREADSHOLD) {
                Arrays.sort(list);
            }
            else {
                int[] firstHalf = new int[list.length /2];
                System.arraycopy(list, 0, firstHalf, 0, firstHalf.length);

                int[] secondHalf = new int[list.length - list.length / 2];
                System.arraycopy(list, firstHalf.length, secondHalf,0, secondHalf.length);

                //Recursively sort the two halves
                invokeAll(new SortTask(firstHalf), new SortTask(secondHalf));

                //Merge first half and second half
                MergeSort.merge(firstHalf, secondHalf, list);
            }
        }
    }
}
