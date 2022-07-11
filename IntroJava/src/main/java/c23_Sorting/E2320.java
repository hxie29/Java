/*(Modify merge sort) Rewrite the mergeSort method to recursively sort the first
half of the array and the second half of the array without creating new temporary
arrays, then merge the two into a temporary array and copy its contents to the
original array, as shown in Figure 23.6b.*/
package c23_Sorting;

import java.util.Arrays;

public class E2320 {
    public static void main(String[] args) {
        int[] list = {1, 9, 4, 6, 5, -4, -6};
        mergeSort(list);
        System.out.println(Arrays.toString(list));
    }
    public static void mergeSort(int[] list) {
        mergeSort(list, 0, list.length-1);
    }

    public static void mergeSort(int[] list, int first, int last) {
        if (last - first > 1) {
            int midIndex = (first + last) /2;
            mergeSort(list, first, midIndex);
            mergeSort(list, midIndex, last);
        }
        merge(list, first, last);
    }
    public static void merge(int[] list, int first, int last) {
        if (last - first == 1 && list[first] > list[last]) {
            int temp = list[first];
            list[first] = list[last];
            list[last] = temp;
        }
        else if (last - first > 1){
            int current1 = first;
            int midIndex = (first + last) / 2;
            int current2 = midIndex;
            int[] temp = new int[last - first + 1];
            int current3 = 0;

            while (current1 < midIndex && current2 <= last) {
                if (list[current1] <= list[current2]) {
                    temp[current3++] = list[current1++];
                } else
                    temp[current3++] = list[current2++];
            }

            while (current1 < midIndex) {
                temp[current3++] = list[current1++];
            }

            while (current2 <= last) {
                temp[current3++] = list[current2++];
            }

            System.arraycopy(temp, 0, list, first, temp.length);
        }
    }
}
