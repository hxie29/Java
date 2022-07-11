package c23_Sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class RadixSort {
    public static void main(String[] args) {
        int[] list = {331, 454, 230, 34, 343, 45, 59, 453, 345, 231, 9};
        radixSort(list);
        System.out.println(Arrays.toString(list));
    }

    public static void radixSort(int[] list) {
        ArrayList<Integer>[] bucket = new ArrayList[10];
        for (int i = 0; i < 10; i++) {
            bucket[i] = new ArrayList<>();
        }

        int digit = (int)Math.log(getMax(list)) + 1;

        for (int i = 1; i <= digit; i++) {
            for (int k : list) {
                int key = k / (int)(Math.pow(10, i -1)) % 10 ;
                bucket[key].add(k);
            }

            int index = 0;
            for (ArrayList<Integer> integers : bucket) {
                if (integers.size() > 0) {
                    for (Integer integer : integers) {
                        list[index++] = integer;
                    }
                    integers.clear();
                }
            }
        }
    }

    private static int getMax(int[] list) {
        return IntStream.of(list).max().getAsInt();
    }
}
