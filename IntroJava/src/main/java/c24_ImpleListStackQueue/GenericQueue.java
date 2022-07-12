package c24_ImpleListStackQueue;

import java.util.LinkedList;

public class GenericQueue<E> {
    private final LinkedList<E> list = new LinkedList<>();

    public void enqueue(E e) {
        list.addLast(e);
    }

    public E dequeue () {
        return list.removeFirst();
    }

    public int getSize() {
        return list.size();
    }

    @Override
    public String toString() {
        return "Queue: " + list;
    }
}
