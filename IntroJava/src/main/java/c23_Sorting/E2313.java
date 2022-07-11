/*
* (Execution time for sorting) Write a program that obtains the execution time of
* selection sort, bubble sort, merge sort, quick sort, heap sort, and radix sort for
* input size 60,000, 120,000, 180,000, 240,000, 300,000, and 360,000. Your program
* should create data randomly and print a table like this:
* Array size: 60,000, 120,000, 180,000, 240,000, 300,000, 360,000
* (Hint: You can use the following code template to obtain the execution time.)
* long startTime = System.currentTimeMillis();
* //perform the task;
* long endTime = System.currentTimeMillis();
* long executionTime = endTime − startTime;
* The text gives a recursive quick sort. Write a nonrecursive version in this exercise.*/
package c23_Sorting;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class E2313 {
    private static final Lock lock = new ReentrantLock();

    public static void main(String[] args) {
        int[] sizes = {60_000, 120_000, 180_000, 240_000, 300_000, 360_000};

        //Print header
        System.out.printf("%-12s%-2s%-12s%-12s%-12s%-12s%-12s%-12s\n", "Array", "|", "Selection", "Bubble", "Merge", "Quick", "Heap", "Radix");
        System.out.printf("%-12s%-2s%-12s%-12s%-12s%-12s%-12s%-12s\n", "size", "|", "Sort", "Sort", "Sort", "Sort", "Sort", "Sort");
        //Print horizontal line
        System.out.println("--------------------------------------------------------------------------------\n");
        //Print each size's and time
        for (int size:sizes) {
            int[] array = createArray(size);
            long[] timeOfSorting = new long[6];
            for (int i = 0; i < timeOfSorting.length; i++) {
                timeOfSorting[i] = getTime(array, i);
            }
            System.out.printf("%-12d%-2s%-12d%-12d%-12d%-12d%-12d%-12d\n", size, "|", timeOfSorting[0], timeOfSorting[1],
                    timeOfSorting[2], timeOfSorting[3], timeOfSorting[4], timeOfSorting[5]);
        }
    }

    private static int[] createArray(int size) {
        int[] array = new int[size];
        for (int i = 0; i < array.length; i++) {
            array[i] = (int)(Math.random() * 100);
        }
        return array;
    }

    private static long getTime(int[] array, int selectionMode) {
        lock.lock();
        int[] arrayCopy = new int[array.length];
        System.arraycopy(arrayCopy, 0, arrayCopy, 0, array.length);
        long startTime = System.currentTimeMillis();
        switch (selectionMode) {
            case 0 -> SelectionSort.selectionSort(arrayCopy);
            case 1 -> BubbleSort.bubbleSort(arrayCopy);
            case 2 -> MergeSort.mergeSort(arrayCopy);
            case 3 -> QuickSort.quickSortIterative(arrayCopy);
            case 4 -> HeapSort.heapSort(arrayCopy);
            case 5 -> RadixSort.radixSort(arrayCopy);
        }
        long endTime = System.currentTimeMillis();
        lock.unlock();
        return endTime-startTime;
    }

}
