package c23_Sorting;

import java.util.Comparator;

public class InsertionSort {
    public static void insertionSort(int[] list) {
        //Time complexity = O(n^2)
        /*
        T(n) = (2 + c) + (2 * 2 + c) + ... + (2 * (n - 1) + c)
             = 2(1 + 2 + ... + n - 1) + c(n - 1)
             = 2(n - 1)n/2 + cn - c = n2 - n + cn - c
             = O(n^2)
        */
        for (int i = 1; i < list.length; i++) {
            int currentElement = list[i];
            int k = i - 1;
            while (k >= 0 && list[k] > currentElement) {
                    list[k + 1] = list[k];
                    k--;
            }
            list[k + 1] = currentElement;
        }
    }

    /* (Generic insertion sort) Write the following two generic methods using insertion
     * sort. The first method sorts the elements using the Comparable interface and the
     * second uses the Comparator interface.
     * public static <E extends Comparable<E>> void insertionSort (E[] list)
     * public static <E> void insertionSort(E[] list, Comparator<?super E> comparator)*/
    public static <E extends Comparable<E>> void insertionSort (E[] list){
        for (int i = 1; i < list.length; i++) {
            E currentElement = list[i];
            int k = i -1;
            while( k >= 0 && list[k].compareTo(currentElement) > 0) {
                    list[k + 1] = list[k];
                    k--;
            }
            list[k + 1] = currentElement;
        }
    }
    public static <E> void insertionSort(E[] list, Comparator<?super E> comparator) {
        for (int i = 1; i < list.length; i++) {
            E currentElement = list[i];
            int k = i -1;
            while (k >= 0 && comparator.compare(list[k], currentElement) >0) {
                list[k+1] = list[k];
                k--;
            }
            list[k+1] = currentElement;
        }
    }
}
