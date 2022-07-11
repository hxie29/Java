package c23_Sorting;

public class SelectionSort {
    public static void selectionSort(int[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            int min = list[i];
            int minIndex = i;
            for (int k = i + 1; k < list.length; k++) {
                if (list[k] < min) {
                    min = list[k];
                    minIndex = k;
                }
            }
            if (minIndex != i) {
                list[minIndex] = list[i];
                list[i] = min;
            }
        }
    }
}
