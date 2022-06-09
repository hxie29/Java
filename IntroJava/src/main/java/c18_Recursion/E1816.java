/*Write a recursive method public static int pos(int[] a, int l,
int r) that positions a[l] at its rank if the array a were sorted between l and r,
and that returns this rank. That is, we assume that a is an unsorted array of int,
l and r are int such that 0 6= l 6= r 6 a.length, after this call : k = pos(a, l, r); a
contains the same elements before and after this call, but it is such that a[k] 7=
a[i] for all i in [l, k-1] and a[k] 6 a[j] for all j in [k+1, r].
For instance, consider this fragment:
int[] a = {8,7,4,1,9,6,2,5,3,0};
System.out.println(Arrays.toString(a));
// [8, 7, 4, 1, 9, 6, 2, 5, 3, 0]
pos(a, 2, 7); // a[2..7] = {4, 1, 9, 6, 2, 5}
System.out.println(Arrays.toString(a));
/* [8, 7, 1, 2, 4, 6, 5, 9, 3, 0] is possible because
4 >= 2, 4 >= 1, 4 < 6, 4 < 5, 4 < 9.
But It could also be [8, 7, 2, 1, 4, 6, 5, 9, 3, 0], or
[8, 7, 2, 1, 4, 9, 5, 6, 3, 0] */
package c18_Recursion;

import java.util.Arrays;

public class E1816 {
    public static void main(String[] args) {
        int[] a = {8,7,4,1,9,6,2,5,3,0};
        System.out.println(Arrays.toString(a));

        int k = partition(a,2,7);
        System.out.println(Arrays.toString(a));
        quickSort(a, 2, 7);
        System.out.println(Arrays.toString(a));
        System.out.println(k);
    }

    //Quick sort is sorting by partitioning an array into 2 smaller arrays recursively
    public static void quickSort(int[] a, int low, int high) {
        if (low < high) {
            int parti = partition(a, low, high);
            quickSort(a, low, parti -1);
            quickSort(a, parti+1, high);
        }
    }

    // Partition:  k = pos(a, l, r);
    // a[k] >= a[i] for all i in [l, k-1] and a[k] 6 a[j] for all j in [k+1, r].
    public static int partition(int[]a, int low, int high) {
        //Choose a pivot
        int pivot = low;
        //Separate the pivot from looping
        low++;
        //loop the rest of the partition
        while (low <= high) {
            // if lower index element is larger than pivot, and higher index element is smaller than pivot, swap these two elements
            if (a[low] > a[pivot] && a[high] < a[pivot])
                swap(a, low, high);
            // if lower index element <= pivot, then it's on the right side
            else if (a[low] <= a[pivot]) {
                low++;
            }
            // if higher index element >= pivot, then it's on the right side
            else if (a[high] >= a[pivot]) {
                high--;
            }
        }
        // after the remaining array is rightly put into two parts of <smaller> & < larger>, we need to put the pivot
        // in between them, since now the low > high (condition to exit above loop), swap pivot with high
        swap(a, pivot, high);
        // index high is now at it's right place, return this index to split the array into 2 smaller partitions for recursion
        return high;
    }

    public static void swap(int[]a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}
