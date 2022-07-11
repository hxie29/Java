package c23_Sorting;

import java.util.Stack;

public class QuickSort {
    /*
    * In the best case, the pivot divides the array each time into two parts of about the same size.
    * Let T(n) denote the time required for sorting an array of n elements using quick sort. Thus,
    * recursive quick sort on partition time two sub arrays
    * T(n) = T(n/2) + T(n/2) + n (partition time)
    * Similar to the merge-sort analysis, T(n) = O(n log n).
    *
    * In the worst case, the pivot divides the array each time into one big sub array with the other
    * array empty. The size of the big sub array is one less than the one before divided. The algorithm
    *  requires (n - 1) + (n - 2) + ... + 2 + 1 = O(n2) time.*/
    public static void quickSort(int[] list) {
        quickSort(list, 0, list.length - 1);
    }


    public static void quickSort(int[] list, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list,pivotIndex + 1, last);
        }
    }

    /* To partition an array of n elements, it takes n comparisons and n moves in the worst case.
    Thus,the time required for partition is O(n).*/
    public static int partition(int[] list, int first, int last) {
        //Improve quick sort E2304 by selecting the median among the first, middle, and the last elements in the list.
        int pivot = Math.max(list[(first + last) / 2], Math.max(list[first], list[last]));
        int low = first + 1;
        int high = last;

        while (high > low) {
            while (low <= high && list[low] <= pivot) {
                low++;
            }

            while (low <= high && list[high] > pivot) {
                high--;
            }

            if (high > low) {
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while (high > first && list[high] >= pivot)
            high--;

        if (list[high] < pivot) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        }
        else return first;
    }

    public static void quickSortIterative(int[] list) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0);
        stack.push(list.length-1);
        while (!stack.isEmpty()) {
            int end = stack.pop();
            int start = stack.pop();
            if (end - start > 0) {
                int pivot = partition(list, start, end);
                stack.push(start);
                stack.push(pivot -1);
                stack.push(pivot +1);
                stack.push(end);
            }
        }
    }
}
