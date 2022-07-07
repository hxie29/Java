//Insertion sort example
package c23_Sorting;

import java.util.Arrays;

public class E23L01 {
    public static void main(String[] args) {
        int[] list = {1, 9, 4, 6, 5, -4};
        InsertionSort.insertionSort(list);
        System.out.println(Arrays.toString(list));
    }
}
