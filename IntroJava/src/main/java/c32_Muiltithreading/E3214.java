package c32_Muiltithreading;


import c23_Sorting.QuickSort;

public class E3214 {
    public static void main(String[] args) {
        final int SIZE = 7000000;
        int[] list1 = new int[SIZE];
        int[] list2 = new int[SIZE];

        for (int i = 0; i < list1.length; i++)
            list1[i] = list2[i] = (int)(Math.random() * 10000000);

        long startTime = System.currentTimeMillis();
        ParallelQuickSort.parallelQuickSort(list1); // Invoke parallel merge sort
        long endTime = System.currentTimeMillis();
        System.out.println("\nParallel time with " + Runtime.getRuntime().availableProcessors() +
                " processors is " + (endTime - startTime) + " milliseconds");

        startTime = System.currentTimeMillis();
        QuickSort.quickSort(list2);
        endTime = System.currentTimeMillis();
        System.out.println("\nSequential time is " + (endTime - startTime) + " milliseconds");

        System.out.println("100th element in list 1: " + list1[100]);
        System.out.println("100th element in list 2: " + list2[100]);
    }
}
