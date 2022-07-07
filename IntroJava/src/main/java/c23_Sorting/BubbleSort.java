package c23_Sorting;

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
}
