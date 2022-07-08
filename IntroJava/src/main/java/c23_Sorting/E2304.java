//(Improve quick sort) The quick-sort algorithm presented in the book selects the
//first element in the list as the pivot. Revise it by selecting the median among the
//first, middle, and the last elements in the list.
package c23_Sorting;

import java.util.Arrays;

public class E2304 {
    public static void main(String[] args) {
        int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        QuickSort.quickSort(list);
        System.out.println(Arrays.toString(list));
    }
}
