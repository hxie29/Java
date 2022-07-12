package c24_ImpleListStackQueue;


import java.util.Iterator;

public class MyLinkedList<E> implements MyList<E>{
    private Node<E> head, tail;
    private int size;

    public MyLinkedList(){}

    public MyLinkedList(E[] objects) {
        for (E e: objects)
            add(e);
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head = newNode;
        size++;

        if (tail == null)
            tail = head;
    }

    public void addLast(E e) {
        Node<E> newNode = new Node<>(e);
        if (tail == null) {
            head = tail = newNode;
        }
        else {
            tail.next = newNode;
            tail = tail.next;
        }
        size++;
    }

    @Override
    public void add(int index, E e) {
        if (index == 0) addFirst(e);
        else if (index >= size) addLast(e);
        else {
            Node<E> current = head;
            for (int i = 1; i < index; i++) {
                current = current.next;
            }
            Node<E> temp = current.next;
            current.next = new Node<>(e);
            (current.next).next = temp;
            size++;
        }
    }

    public E getFirst() {
        if (size == 0) return null;
        return head.element;
    }

    public E getLast() {
        if (size == 0) return null;
        return tail.element;
    }

    @Override
    public E get(int index) {
        if (index <0 || index >= size) return null;
        if (index == 0) return getFirst();
        if (index == size -1) return getLast();

        Node<E> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.element;
    }

    public E removeFirst() {
        if (size == 0) return null;

        Node<E> temp = head;
        head = head.next;
        size--;
        if (head == null) tail = null;
        return temp.element;
    }

    public E removeLast() {
        if (size <= 1) return removeFirst();

        Node<E> current = head;
        Node<E> removedElement = tail;
        for (int i = 1; i <= size - 2; i++) {
            current = current.next;
        }
        tail = current;
        tail.next = null;
        size--;
        return removedElement.element;
    }

    @Override
    public E remove(int index) {
        if (index <0 || index >= size) return null;
        if (index == 0) return removeFirst();
        if (index == size -1) return removeLast();

        Node<E> previous = head;
        for (int i = 1; i < index; i++) {
            previous = previous.next;
        }
        Node<E> current = previous.next;
        previous.next = current.next;
        size--;
        return current.element;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        Node<E> current = head;
        if (current != null) {
            result.append("[");
            for (int i = 0; i <size; i++) {
                result.append(current.element);
                current = current.next;
                if (current != null) result.append(",");
                else result.append("]");
            }
        }
        return  result.toString();
    }

    @Override
    public void clear() {
        size = 0;
        head = tail = null;
    }

    @Override
    public boolean contains(Object o) {
        Node<E> current = head;
        if (!head.element.equals(o)) {
            for (int i = 1; i < size; i++) {
                current = current.next;
                if (current.element.equals(o))
                    return true;
            }
        }
        return false;
    }

    @Override
    public int lastIndexOf(E e) {
        Node<E> current = head;
        if (head != null) {
            int index = 0;
            for (int i = 1; i < size; i++) {
                current = current.next;
                if (current.element.equals(e))
                    index = i;
            }
            return index;
        }
        return -1;
    }

    @Override
    public int indexOf(Object e) {
        Node<E> current = head;
        if (head != null) {
            for (int i = 1; i < size; i++) {
                current = current.next;
                if (current.element.equals(e))
                    return i;
            }
        }
        return -1;
    }

    @Override
    public E set(int index, E e) {
        if (index == 0) {
            E old = head.element;
            head.element = e;
            return old;
        }
        else if (index >= size) {
            E old = tail.element;
            tail.element = e;
            return old;
        }
        else {
            Node<E> current = head;
            for (int i = 0; i < index; i++) {
                current = current.next;
            }
            E old = current.element;
            current.element = e;
            return old;
        }
    }

    @Override
    public Iterator<E> iterator() {
        return new LinkedListIterator();
    }

    private class LinkedListIterator implements Iterator<E> {
        private Node<E> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public E next() {
            E temp = current.element;
            current = current.next;
            return temp;
        }

        @Override
        public void remove() {
            removeFirst();
        }
    }

    @Override
    public int size() {
        return size;
    }
}
