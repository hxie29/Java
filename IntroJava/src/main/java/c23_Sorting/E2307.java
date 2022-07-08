/*
 * (Min-heap) The heap presented in the text is also known as a max-heap, in which
 * each node is greater than or equal to any of its children. A min-heap is a heap in
 * which each node is less than or equal to any of its children. Min-heaps are often
 * used to implement priority queues. Revise the Heap class in Listing 23.9 to implement a min-heap. */
package c23_Sorting;

import java.util.Arrays;

public class E2307 {
    public static void main(String[] args) {
        Integer[] list = {2, 3, 2, 5, 6, 1, -2, 3, 14, 12};
        MinHeap<Integer> minHeap = new MinHeap<>(list);
        for (int i = 0; i < list.length; i++) {
            list[i] = minHeap.remove();
        }
        System.out.println(Arrays.toString(list));
    }
}
