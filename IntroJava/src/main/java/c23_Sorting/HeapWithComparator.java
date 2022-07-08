/*
* (Generic Heap using Comparator) Revise Heap in Listing 23.9, using a generic
* parameter and a Comparator for comparing objects. Define the class as follows:
* class HeapWithComparator<E> {
    private Comparator<? super E> comparator; // For comparing elements
    public HeapWithComparator() {
        // Implement no−arg constructor by creating a comparator for natural order
    }
public HeapWithComparator(Comparator<? super E> comparator) {
    this.comparator = comparator;
}
// Implement all add, remove, and getSize method
} */
package c23_Sorting;

import java.util.ArrayList;
import java.util.Comparator;

public class HeapWithComparator<E> {
    private Comparator<? super E> comparator;
    private final ArrayList<E> list = new ArrayList<>();

    public HeapWithComparator() {
        // Implement no−arg constructor by creating a comparator for natural order
        comparator = (Comparator<? super E>) Comparator.naturalOrder();
    }

    public HeapWithComparator(Comparator<? super E> comparator) {
        this.comparator = comparator;
    }

    public HeapWithComparator(E[] objects) {
        for (E object: objects)
            add(object);
    }

    public HeapWithComparator(E[] objects, Comparator<? super E> comparator) {
        this.comparator = comparator;
        for (E object: objects)
            add(object);
    }

    // Implement all add, remove, and getSize method
    public void add(E newObject) {
        list.add(newObject);
        int currentIndex = list.size() - 1;
        while (currentIndex >0) {
            int parentIndex = (currentIndex -1) /2;
            if (comparator.compare(list.get(parentIndex), list.get(currentIndex)) < 0) {
                list.set(currentIndex, list.get(parentIndex));
                list.set(parentIndex, newObject);
                currentIndex = parentIndex;
            }
            else break;
        }
    }

    public E remove() {
        if (list.size() == 0) return null;

        E removedObject = list.get(0);
        list.set(0, list.get(list.size() -1));
        list.remove(list.size()-1);

        int currentIndex = 0;
        while (currentIndex < list.size()) {
            int leftChildIndex = 2 * currentIndex + 1;
            int rightChildIndex = 2 * currentIndex + 2;
            if (leftChildIndex >= list.size()) break;

            int maxIndex = leftChildIndex;
            if (rightChildIndex < list.size()) {
                if (comparator.compare(list.get(rightChildIndex), list.get(leftChildIndex)) > 0) {
                    maxIndex = rightChildIndex;
                }
            }

            if (comparator.compare(list.get(currentIndex), list.get(maxIndex)) < 0) {
                E temp = list.get(currentIndex);
                list.set(currentIndex,list.get(maxIndex));
                list.set(maxIndex, temp);
                currentIndex = maxIndex;
            }
            else break;
        }
        return removedObject;
    }

    public int getSize() {
        return list.size();
    }

}
