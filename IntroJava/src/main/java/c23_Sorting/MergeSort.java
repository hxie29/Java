package c23_Sorting;

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
}
