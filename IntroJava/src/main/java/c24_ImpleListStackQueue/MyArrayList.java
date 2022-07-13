package c24_ImpleListStackQueue;

import java.util.Iterator;

public class MyArrayList<E> implements MyList<E> {
    public static final int INITIAL_CAPACITY = 16;
    private E[] data = (E[]) new Object[INITIAL_CAPACITY];
    private int size = 0;

    public MyArrayList() {}

    public MyArrayList(E[] objects) {
        for (E object : objects) {
            add(object);
        }
    }

    @Override
    public void add(int index, E e) {
        if (index < 0 || index > size)
            throw new IndexOutOfBoundsException("Index: " + index + " , Size: " + size);

        ensureCapacity();
        if (size - index >= 0) System.arraycopy(data, index, data, index + 1, size - index);
        data[index] = e;
        size++;
    }

    private void ensureCapacity() {
        if (size >= data.length) {
            E[] newData = (E[]) new Object[size * 2 + 1];
            System.arraycopy(data, 0, newData, 0, data.length);
            data = newData;
        }
    }

    public int getCapacity() {
        return data.length;
    }

    @Override
    public void clear() {
        data = (E[]) new Object[INITIAL_CAPACITY];
        size = 0;
    }

    @Override
    public boolean contains(Object o) {
        for (int i = 0; i < size; i++) {
            if (o.equals(data[i])) return true;
        }
        return false;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return data[index];
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + " , Size: " + size);
    }

    @Override
    public int indexOf(Object e) {
        for (int i = 0; i < size; i++) {
            if (e.equals(data[i])) return i;
        }
        return -1;
    }

    @Override
    public int lastIndexOf(E e) {
        for (int i = size -1; i >= 0; i--) {
            if (e.equals(data[i])) return i;
        }
        return -1;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);

        E e = data[index];
        if (size - index >= 0) System.arraycopy(data, index + 1, data, index, size - index - 1);
        data[size-1] = null;
        size--;
        return e;
    }

    @Override
    public E set(int index, E e) {
        checkIndex(index);
        E old = data[index];
        data[index] = e;
        return old;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            result.append(data[i]);
            if (i < size - 1) result.append(",");
        }
        return result + "]";
    }

    public void trimToSize() {
        if (size != data.length) {
            E[] newData = (E[]) new Object[size];
            System.arraycopy(data, 0, newData, 0, size);
            data = newData;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<E>{
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < size;
        }

        @Override
        public E next() {
            return data[current++];
        }

        // remove the element returned by the last next()
        @Override
        public void remove() {
            if (current == 0)
                throw new IllegalStateException();
            MyArrayList.this.remove(--current);
        }
    }

    @Override
    public int size() {
        return size;
    }
}
