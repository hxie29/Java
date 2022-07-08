package c23_Sorting;

import java.util.Comparator;

public class BubbleSort {
    /*
    * In the worst case, the bubble-sort algorithm requires n - 1 passes. The first pass makes
    * n - 1 comparisons, the second pass makes n - 2 comparisons, and so on; the last pass makes
    * 1 comparison. Thus, the total number of comparisons is as follows:
    * (n - 1) + (n - 2) + ... + 2 + 1
    * = (n - 1)n/2 = n^2/2 -n/2
    * = O(n2)
    * */
    public static void bubbleSort(int[] list) {
        boolean swapped = true;
        for (int i = 1; swapped && i < list.length; i++) {
            swapped = false;
            for (int k = 0; k < list.length - i; k++) {
                if (list[k + 1] < list[k]) {
                    int temp = list[k];
                    list[k] = list[k + 1];
                    list[k+ 1] = temp;
                    swapped = true;
                }
            }
        }
    }
    /*
    * (Generic bubble sort) Write the following two generic methods using bubble
    * sort. The first method sorts the elements using the Comparable interface, and
    * the second uses the Comparator interface.
    * public static <E extends Comparable<E>> void bubbleSort(E[] list)
    * public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) */

    public static <E extends Comparable<E>> void bubbleSort(E[] list) {
        boolean swapped = true;
        for (int i = 1; i < list.length && swapped; i++) {
            swapped = false;
            for (int j = 0; j < list.length - i; j++) {
                if (list[j+1].compareTo(list[j]) < 0) {
                    E temp = list[j+1];
                    list[j+1] = list[j];
                    list[j] = temp;
                    swapped = true;
                }
            }
        }
    }
    public static <E> void bubbleSort(E[] list, Comparator<? super E> comparator) {
        boolean swapped = true;
        for (int i = 1; i < list.length && swapped; i++) {
            swapped = false;
            for (int j = 0; j < list.length - i; j++) {
                if (comparator.compare(list[j], list[j+1]) > 0) {
                    E temp = list[j+1];
                    list[j+1] = list[j];
                    list[j] = temp;
                    swapped = true;
                }
            }
        }
    }
}
