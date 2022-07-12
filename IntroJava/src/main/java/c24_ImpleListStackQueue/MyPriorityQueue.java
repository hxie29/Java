package c24_ImpleListStackQueue;

import c23_Sorting.Heap;

public class MyPriorityQueue<E extends Comparable<E>> {
    private final Heap<E> heap = new Heap<E>();

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
