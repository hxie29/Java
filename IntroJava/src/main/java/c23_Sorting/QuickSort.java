package c23_Sorting;

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
        int pivot = list[first];
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
}
