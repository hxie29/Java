//Quick sort demo
package c23_Sorting;

import java.util.Arrays;

public class E23L08 {
    public static void main(String[] args) {
        int[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        QuickSort.quickSort(list);
        System.out.println(Arrays.toString(list));
    }
}
