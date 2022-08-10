/*(Generic parallel merge sort) Revise Listing 32.10, ParallelMergeSort.java, to
define a generic parallelMergeSort method as follows:
public static <E extends Comparable<E>> void
parallelMergeSort(E[] list)*/
package c32_Muiltithreading;

import java.util.concurrent.RecursiveAction;
import static c23_Sorting.MergeSort.merge;
import static c23_Sorting.MergeSort.mergeSort;

public class GenericSortTask<E extends Comparable<E>> extends RecursiveAction {
    private final static int THRESHOLD = 500;
    private final E[] list;

    private final int low;
    private final int high;
    public GenericSortTask(E[] list) {
        this (list, 0, list.length-1);
    }

    public GenericSortTask(E[] list, int low, int high) {
        this.list = list;
        this.high = high;
        this.low = low;
    }

    @Override
    protected void compute() {
        if (high - low < THRESHOLD) {
            mergeSort(list, low, high);
        }
        else {
            int mid = (low + high) /2;
            //Recursively sort the two halves
            invokeAll(new GenericSortTask<>(list, low, mid-1), new GenericSortTask<>(list, mid, high));
            //Merge first half and second half
            merge(list, low, high);
        }
    }
}
