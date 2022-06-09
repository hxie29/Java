//Recursive binary search
package c18_Recursion;

import static java.util.Arrays.sort;

public class E18L06 {
    public static void main(String[] args) {
        int[] list = {3,5,7,1,51,52,67,36};
        sort(list);
        System.out.println(recursiveBinarySearch(list, 51));
    }
   public static int recursiveBinarySearch(int[] list, int key) {
        return recursiveBinarySearch(list, key, 0, list.length -1);
   }

   public static int recursiveBinarySearch(int[] list, int key, int low, int high) {
        if (low > high)
            return -1;

        int mid = (low + high) / 2;

        if (key < list[mid])
            return recursiveBinarySearch(list, key, low, mid-1);
        else if (key == list[mid])
            return mid;
        else
            return recursiveBinarySearch(list, key, mid+1, high);
   }
}
