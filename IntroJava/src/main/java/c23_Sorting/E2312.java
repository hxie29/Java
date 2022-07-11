/*(Radix sort) Write a program that randomly generates 1,200,000 integers and
sorts them using radix sort.*/
package c23_Sorting;

public class E2312 {
    public static void main(String[] args) {
        int[] list = new int[1_200_000];
        for (int i = 0; i < list.length; i++) {
            list[i] = (int)(Math.random() * 1000);
        }
        RadixSort.radixSort(list);
        int count = 0;
        for (int ints: list) {
            System.out.print((++count % 20 == 0) ? ints + "\n" : ints + " ");
        }
    }
}
