/*Write a recursive method that finds the kth-smallest value of a given array. Use
the method pos of Programming Exercise 18.16.*/
package c18_Recursion;

import java.util.Arrays;

public class E1817 {
    public static void main(String[] args) {
        int[] a = {8,7,4,1,9,6,2,5,3,0};
        System.out.println(Arrays.toString(a));
        int value = a[pos(a, 7, 0, a.length -1)];
        System.out.println(value);
        System.out.println(Arrays.toString(a));
    }

    public static int pos(int[] a, int k, int low, int high) {
        // find the rank of low element, the rank value is pivot
        int pivot = E1816.partition(a, low, high);
        // if the pivot rank is k, goal reached, recursion is stopped
        if (pivot + 1 == k) {
            return pivot;
        }
        // if the rank is larger, then we should look for the first element's rank of the smaller partition
        else if (pivot + 1 > k) {
            return pos(a, k, 0, pivot + 1);
        }
        // if the rank is smaller, then we should look for the first element's rank of the larger partition
        else {
            return pos(a, k, pivot + 1, high);
        }
    }
}
