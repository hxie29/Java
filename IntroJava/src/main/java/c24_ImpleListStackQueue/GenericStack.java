package c24_ImpleListStackQueue;

import java.util.ArrayList;

public class GenericStack<E> {
    private final ArrayList<E> list = new ArrayList<>();

    public int getSize() {
        return list.size();
    }

    public E peek() {
        return list.get(getSize() -1);
    }

    public boolean isEmpty() {
        return list.size() == 0;
    }

    public void push(E o) {
        list.add(o);
    }

    public E pop() {
        E o = this.peek();
        list.remove(getSize() -1);
        return o;
    }

    @Override
    public String toString() {
        return "stack: " + list;
    }
}
