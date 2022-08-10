/*(Generic parallel merge sort) Revise Listing 32.10, ParallelMergeSort.java, to
define a generic parallelMergeSort method as follows:
public static <E extends Comparable<E>> void
parallelMergeSort(E[] list)*/
package c32_Muiltithreading;

import c23_Sorting.MergeSort;

import static c32_Muiltithreading.ParallelMergeSort.parallelMergeSort;

public class E3213 {
    //see class ParallelMergeSort
    public static void main(String[] args) {

        final int SIZE = 1000000;
        Integer[] list1 = new Integer[SIZE];
        Integer[] list2 = new Integer[SIZE];

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
}
