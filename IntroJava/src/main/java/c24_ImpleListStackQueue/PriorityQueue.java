/*(Generic PriorityQueue using Comparator) Revise MyPriorityQueue
in Listing 24.8, using a generic parameter for comparing objects. Define a new
constructor with a Comparator as its argument as follows:
PriorityQueue(Comparator<? super E> comparator)*/
package c24_ImpleListStackQueue;

import c23_Sorting.HeapWithComparator;
import java.util.Comparator;

public class PriorityQueue<E> {
    private final HeapWithComparator<E> heap;

    public PriorityQueue(Comparator <? super E> comparator) {
        heap = new HeapWithComparator<>(comparator);
    }

    public void enqueue(E e) {
        heap.add(e);
    }

    public E dequeue() {
        return heap.remove();
    }

    public int getSize() {
        return heap.getSize();
    }
}
