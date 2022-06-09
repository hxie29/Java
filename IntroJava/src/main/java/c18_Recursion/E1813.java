/*Write a recursive method public static void randomFillSortedArray
(int[] x, int l, int r, int a, int b) that fills the array x between l
and r with random values between a and b such that x is sorted. Here is a sample
run:
Enter the array size: 10
Enter the limits: 0 1000
[235, 280, 382, 428, 458, 462, 484, 495, 536, 850]
Enter the array size: 10
Enter the limits: 0 9
[0, 0, 3, 3, 4, 6, 6, 8, 8, 9]*/
package c18_Recursion;

import java.util.Arrays;

public class E1813 {
    public static void main(String[] args) {
        int[] x = new int[8];
        for (int i = 0; i < x.length; i++) {
            x[i] = (int)(Math.random() * 500);
        }
        System.out.println(Arrays.toString(x));
        System.out.println(max(x, 0, x.length -1));
    }

    public static int max(int[]x, int low, int high) {
        if (low == high)
            return x[high];
        else
            return Math.max(x[low], max(x, low + 1, high));
    }
}
