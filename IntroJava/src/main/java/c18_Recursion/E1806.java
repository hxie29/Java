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
import java.util.Scanner;
import static java.util.Arrays.sort;

public class E1806 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the array size:");
        int size = input.nextInt();
        int[] x = new int[size];
        System.out.println("Enter the limits:");
        int low = input.nextInt();
        int high = input.nextInt();

        randomFillSortedArray(x, low, high);
    }

    public static void randomFillSortedArray(int[]x, int low, int high) {
        for (int i = 0; i < x.length; i++) {
            x[i] = low + (int)(Math.random() * (high - low));
        }
        sort(x);
        System.out.println(Arrays.toString(x));
    }
}
