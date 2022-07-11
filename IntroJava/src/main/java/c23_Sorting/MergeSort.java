package c23_Sorting;

import java.util.ArrayList;
import java.util.Comparator;

public class MergeSort {
    /*
    * Let T(n) denote the time required for sorting an array of n elements using a merge sort. Without
    * loss of generality, assume n is a power of 2. The merge-sort algorithm splits the array into two
    * sub arrays, sorts the sub arrays using the same algorithm recursively, then merges the sub arrays. Therefore,
    * T(n) = T(n/2) + T (n/2) + merge time
    * To merge two sub arrays, it takes at most n - 1 comparisons to compare the elements from the two sub arrays,
    * and n moves to move elements to the temporary array. Thus, the total time is 2n - 1. Therefore,
    * T(n) = T(n/2) + T (n/2) + 2 * n -1
    * = O(n log n)*/
    public static void mergeSort(int[] list) {
       if (list.length > 1) {
           int[] firstHalf = new int[list.length / 2];
           int[] secondHalf = new int[list.length - list.length / 2];
           System.arraycopy(list, 0, firstHalf,0, firstHalf.length);
           System.arraycopy(list, firstHalf.length, secondHalf,0, secondHalf.length);
           mergeSort(firstHalf);
           mergeSort(secondHalf);
           merge(firstHalf, secondHalf, list);
       }
    }

    public static void merge(int[] list1, int[] list2, int[] temp) {
        int current1 = 0;
        int current2 = 0;
        int current3 = 0;

        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1] <= list2[current2]) {
                temp[current3++] = list1[current1++];
            }
            else
                temp[current3++] = list2[current2++];
        }

        while (current1 < list1.length) {
            temp[current3++] = list1[current1++];
        }

        while (current2 < list2.length) {
            temp[current3++] = list2[current2++];
        }
    }

    /* (Generic merge sort) Write the following two generic methods using merge sort.
     * The first method sorts the elements using the Comparable interface and the
     * second uses the Comparator interface.
     * public static <E extends Comparable<E>> void mergeSort(E[] list)
     * public static <E> void mergeSort(E[] list, Comparator<? super E> comparator) */

    public static <E extends Comparable<E>> void mergeSort(E[] list) {
        mergeSort(list, 0, list.length -1);
    }

    public static <E extends Comparable<E>> void mergeSort(E[] list, int beginIndex, int endIndex) {
        if (endIndex - beginIndex > 1) {
            int midIndex = (endIndex + beginIndex) / 2;
            mergeSort(list, beginIndex, midIndex);
            mergeSort(list, midIndex, endIndex);
        }
        merge(list, beginIndex, endIndex);
    }

    private static <E extends Comparable<E>> void merge(E[] list, int beginIndex, int endIndex) {
        if (endIndex - beginIndex == 1) {
            if (list[beginIndex].compareTo(list[endIndex]) > 0) {
                E temp = list[beginIndex];
                list[beginIndex] = list[endIndex];
                list[endIndex]  = temp;
            }
        }

        else if (endIndex - beginIndex > 1){
            int current1 = beginIndex;
            int midIndex = (beginIndex + endIndex) /2;
            int current2 = midIndex;
            ArrayList<E> array = new ArrayList<>();

            while (current1 < midIndex && current2 <= endIndex) {
                if (list[current1].compareTo(list[current2]) <= 0) {
                    array.add(list[current1++]);
                }
                else {
                    array.add(list[current2++]);
                }
            }

            while (current1 < midIndex) {
                array.add(list[current1++]);
            }

            while ((current2 <= endIndex)) {
                array.add(list[current2++]);
            }

            for (int i = beginIndex; i <= endIndex; i++) {
                list[i] = array.get(i - beginIndex);
            }
        }
    }

    public static <E> void mergeSort(E[] list, Comparator<? super E> comparator) {
        mergeSort(list, 0, list.length -1, comparator);

    }

    private static <E> void mergeSort(E[] list, int beginIndex, int endIndex, Comparator<? super E> comparator) {
        if (endIndex - beginIndex >= 2) {
            int midIndex = (endIndex + beginIndex) / 2;
            mergeSort(list, beginIndex, midIndex - 1, comparator);
            mergeSort(list, midIndex, endIndex, comparator);
        }
        merge(list, beginIndex, endIndex, comparator);
    }

    private static <E> void merge(E[] list, int beginIndex, int endIndex, Comparator<? super E> comparator) {
        if (endIndex - beginIndex == 1) {
            if (comparator.compare(list[beginIndex], list[endIndex]) > 0) {
                E temp = list[beginIndex];
                list[beginIndex] = list[endIndex];
                list[endIndex]  = temp;
            }
        }

        else if (endIndex - beginIndex > 1){
            int current1 = beginIndex;
            int midIndex = (beginIndex + endIndex) / 2;
            int current2 = midIndex;
            ArrayList<E> array = new ArrayList<>();

            while (current1 < midIndex && current2 <= endIndex) {
                if (comparator.compare(list[current1], list[current2]) <= 0) {
                    array.add(list[current1++]);
                } else {
                    array.add(list[current2++]);
                }
            }

            while (current1 < midIndex) {
                array.add(list[current1++]);
            }

            while ((current2 <= endIndex)) {
                array.add(list[current2++]);
            }

            for (int i = beginIndex; i <= endIndex; i++) {
                list[i] = array.get(i - beginIndex);
            }
        }
    }
}
