/*(Find the smallest number) Write a method that uses the divide-and-conquer
approach to find the smallest number in a list.*/
package c22_EfficientAlgorithms;

import java.util.Arrays;

public class E2224 {
    public static void main(String[] args) {
        int[] numbers = new int[20];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 100);
        }

        System.out.println(Arrays.toString(numbers));
        System.out.println("Smallest number is " + smallest(numbers));
    }

    private static int smallest(int[] list) {
        return smallest(0,list.length, list);
    }

    private static int smallest(int low, int high, int[] list) {
        if (low + 1 == high)
            return list[low];
        else if (low + 2 == high)
            return Math.min(list[low], list[low + 1]);
        else {
            int midIndex = (low + high) / 2;
            return Math.min(smallest(low, midIndex, list), smallest(midIndex, high, list));
        }
    }
}
