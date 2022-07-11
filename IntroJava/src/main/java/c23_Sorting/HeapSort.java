package c23_Sorting;

import java.util.Comparator;

public class HeapSort {
    public static void heapSort(int[] list) {
        Heap<Integer> heap = new Heap<>();
        for (int ints: list)
            heap.add(ints);
        for (int i = list.length -1; i >= 0; i--)
            list[i] = heap.remove();
    }
    public static <E extends Comparable<E>> void heapSort(E[] list) {
        //Create a heap binary tree with list
        Heap<E> heap = new Heap<>(list);
        //Remove elements from heap one by one till it's empty, add elements to list from last to beginning
        for (int i = list.length -1; i >= 0; i--) {
            list[i] = heap.remove();
        }
    }
    public static <E> void heapSort(E[] list, Comparator<? super E> comparator) {
        HeapWithComparator<E> heap = new HeapWithComparator<>(list, comparator);
        for (int i = list.length -1; i >= 0; i--) {
            list[i] = heap.remove();
        }
    }
}
