//Heap sort example
package c23_Sorting;

import java.util.Arrays;

public class E23L10 {
    public static void main(String[] args) {
        Integer[] list = {-44, -5, -3, 3, 3, 1, -4, 0, 1, 2, 4, 5, 53};
        HeapSort.heapSort(list);
        System.out.println(Arrays.toString(list));
    }
}
