/*
* The height of a tree that contains a single node is 0. Conventionally,
* the height of an empty tree is −1. Since a heap is a complete binary tree, the first level
* has 1 (2^0) node, the second level has 2 (2^1) nodes, the kth level has 2^(k-1) nodes, the h level has
* 2^(h-1) nodes, and the last (h + 1)th level has at least 1 and at most 2^h nodes. Therefore,
* 1 + 2 + ... + 2^(h-1) < n <= 1 + 2 + ... + 2^(h-1) + 2^h
* --> 2^h -1 < n <= 2^(h+1) -1
*
* Thus, h < log(n+1) <= h + 1. Therefore, log(n+1) -1 <= h < log(n+1)
* Hence, the height of a heap is O(log(n)). More precisely, you can prove that
* h = [log(n)] for a non-empty tree.
*
* Since the add method traces a path from a leaf to a root, it takes at most h steps to add a
* new element to the heap. Thus, the total time for constructing an initial heap is O(n * log(n)) for
* an array of n elements. Since the remove method traces a path from a root to a leaf, it takes at
* most h steps to rebuild a heap after removing the root from the heap. Since the remove method
* is invoked n times, the total time for producing a sorted array from a heap is O(n*log(n)).
* */
package c23_Sorting;
import java.util.ArrayList;

public class Heap<E extends Comparable<E>> implements Cloneable {
    protected ArrayList<E> list = new ArrayList<>();

    public Heap() {}

    public Heap(E[] objects) {
        for (E object : objects) {
            add(object);
        }
    }

    public ArrayList<E> getList() {
        return list;
    }

    public int getParentIndex(int index) {
        return (index > 0) ? (index -1) / 2 : -1;
    }

    public int leftChildIndex(int index) {
        return index * 2 + 1;
    }

    public int rightChildIndex(int index) {return index * 2 + 2;}

    public void add(E object) {
        list.add(object);
        int currentIndex = list.size() -1;

        while (currentIndex > 0) {
            int parentIndex = getParentIndex(currentIndex);
            if (list.get(parentIndex).compareTo(list.get(currentIndex)) < 0) {
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
        remove(removedObject);

        return removedObject;
    }

    public int remove(E key) {
        if (list.contains(key)) {
            int index = list.indexOf(key);
            list.set(index, list.get(list.size() -1));
            list.remove(list.size() -1);

            int currentIndex = 0;
            while (currentIndex < list.size()) {
                int leftChildIndex = leftChildIndex(currentIndex);
                int rightChildIndex = rightChildIndex(currentIndex);

                if (leftChildIndex >= list.size()) break;

                int maxIndex = leftChildIndex;
                if (rightChildIndex < list.size()) {
                    if (list.get(maxIndex).compareTo(list.get(rightChildIndex)) < 0)
                        maxIndex = rightChildIndex;
                }

                if (list.get(currentIndex).compareTo(list.get(maxIndex)) < 0) {
                    E temp = list.get(currentIndex);
                    list.set(currentIndex, list.get(maxIndex));
                    list.set(maxIndex, temp);
                    currentIndex = maxIndex;
                }
                else break;
            }
            return index;
        }
        else
            return -1;
    }

    public int getSize() {
        return list.size();
    }

    /* E2311 (Heap clone and equals) Implement the clone and equals method in the Heap class.*/
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Heap<E> cloneHeap = new Heap<>();
        cloneHeap.list = (ArrayList<E>) list.clone();
        return cloneHeap;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Heap)
            return list.equals(((Heap<?>) obj).list);

        return false;
    }
}
