//Recursive binary search
package com.example.recursion;

public class E18L06 {
    public static void main(String[] args) {
        double[] list = {10.2, 34.4, 5.1, 8.4, 12.3};
        sort(list);
        for (double e: list) {
            System.out.print(e + " ");
        }
    }
    private static void sort(double[] list) {
        sort(list, 0, list.length -1);
    }

    private static void sort(double[] list, int low, int high) {
        if (low < high) {
            int indexOfMin = low;
            double min = list[low];
            for (int i = low + 1; i <= high; i++) {
                if (list[i] < min) {
                    indexOfMin = i;
                    min = list[i];
                }
            }
            if (indexOfMin != low) {
                list[indexOfMin] = list[low];
                list[low] = min;
            }
            sort(list, low + 1, high - 1);
        }
    }

}
