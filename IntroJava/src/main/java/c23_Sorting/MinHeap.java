/*
* (Min-heap) The heap presented in the text is also known as a max-heap, in which
* each node is greater than or equal to any of its children. A min-heap is a heap in
* which each node is less than or equal to any of its children. Min-heaps are often
* used to implement priority queues. Revise the Heap class in Listing 23.9 to implement a min-heap. */
package c23_Sorting;
import java.util.ArrayList;

public class MinHeap<E extends Comparable<E>> {
    private final ArrayList<E> list = new ArrayList<>();

    public MinHeap() {}

    public MinHeap(E[] objects) {
        for (E object : objects) {
            add(object);
        }
    }

    public void add(E object) {
        list.add(object);
        int currentIndex = list.size() -1;

        while (currentIndex > 0) {
            int parentIndex = (currentIndex - 1) /2;
            if (list.get(parentIndex).compareTo(list.get(currentIndex)) > 0) {
                list.set(currentIndex, list.get(parentIndex));
                list.set(parentIndex, object);
                currentIndex = parentIndex;
            }
            else
                break;
        }
    }

    public E remove() {
        if (list.size() == 0) return null;

        E removedObject = list.get(0);
        list.set(0, list.get(list.size() -1));
        //cannot combine these two lines, IndexOutOfBound
        list.remove(list.size() -1);

        int currentIndex = 0;
        while (currentIndex < list.size()) {
            int leftChildIndex = 2 * currentIndex +1;
            int rightChildIndex = 2 * currentIndex +2;

            if (leftChildIndex >= list.size()) break;

            int minIndex = leftChildIndex;
            if (rightChildIndex < list.size()) {
                if (list.get(minIndex).compareTo(list.get(rightChildIndex)) > 0)
                    minIndex = rightChildIndex;
            }

            if (list.get(currentIndex).compareTo(list.get(minIndex)) > 0) {
                E temp = list.get(currentIndex);
                list.set(currentIndex, list.get(minIndex));
                list.set(minIndex, temp);
                currentIndex = minIndex;
            }
            else break;
        }
        return removedObject;
    }

    public int getSize() {
        return list.size();
    }

}
