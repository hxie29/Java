package c23_Sorting;

public class HeapSort {
    public static <E extends Comparable<E>> void heapSort(E[] list) {
        //Create a heap binary tree with list
        Heap<E> heap = new Heap<>(list);
        //Remove elements from heap one by one till it's empty, add elements to list from last to beginning
        for (int i = list.length -1; i >= 0; i--) {
            list[i] = heap.remove();
        }
    }
}
