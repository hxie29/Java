package c24_ImpleListStackQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class PrioritySortedArrayList<E extends Comparable<E>> {
    private final ArrayList<E> list = new ArrayList<>();
    public PrioritySortedArrayList(){}
    public PrioritySortedArrayList(E[] objects) {
        list.addAll(Arrays.asList(objects));
        list.sort(Comparator.reverseOrder());
    }

    public void enqueue(E e) {
        int index = 0;
        while (index < list.size()) {
            if (list.get(index).compareTo(e) < 0)
                break;
            else
                index++;
        }
        list.add(index, e);
    }

    public E dequeue() {
        return list.remove(0);
    }

    public int getSize() {
        return list.size();
    }
}
