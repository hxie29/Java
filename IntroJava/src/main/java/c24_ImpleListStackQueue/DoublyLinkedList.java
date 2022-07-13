package c24_ImpleListStackQueue;

import java.util.Iterator;

public class DoublyLinkedList<E> implements MyList<E>{
    private Node<E> head, tail;
    private int size;

    public DoublyLinkedList(){}

    public DoublyLinkedList(E[] objects) {
        for (E e: objects)
            add(e);
    }

    public void addFirst(E e) {
        Node<E> newNode = new Node<>(e);
        newNode.next = head;
        head.previous = newNode;
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
            newNode.previous = tail;
            tail = newNode;
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
            Node<E> newNode = new Node<>(e);
            current.next = newNode;
            newNode.previous = current;
            newNode.next = temp;
            temp.previous = newNode;
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
        temp.next = null;
        size--;
        if (head == null) tail = null;
        else head.previous = null;
        return temp.element;
    }

    public E removeLast() {
        if (size <= 1) return removeFirst();

        Node<E> temp = tail;
        tail = temp.previous;
        temp.next = temp.previous = null;
        size--;
        return temp.element;
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
        current.next.previous = previous;
        current.next = current.previous = null;
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
        Node<E> current = tail;
        if (tail != null) {
            for (int i = size - 1; i >= 0; i--) {
                if (current.element.equals(e))
                    return i;
                current = current.previous;
            }
        }
        return -1;
    }

    @Override
    public int indexOf(Object e) {
        Node<E> current = head;
        if (head != null) {
            for (int i = 0; i < size; i++) {
                if (current.element.equals(e))
                    return i;
                current = current.next;
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
    public int size() {
        return size;
    }

    @Override
    public Iterator<E> iterator() {
        return new DoublyLinkedListIterator();
    }

    private class DoublyLinkedListIterator implements Iterator<E> {
        private Node<E> current = head;

        public DoublyLinkedListIterator(){};

        public DoublyLinkedListIterator(int index){
            setCurrent(index);
        }

        private void setCurrent(int index) {
            if (index == size -1)
                current = tail;
            else if (index >= 0 && index < size - 1) {
                for (int i = 1; i < index; i++)
                    current = current.next;
            }
        }

        @Override
        public boolean hasNext() {
            return current != null;
        }

        public boolean hasPrevious() {
            return current.previous != null;
        }

        @Override
        public E next() {
            E temp = current.element;
            current = current.next;
            return temp;
        }

        public E previous() {
            E temp = current.previous.element;
            current = current.previous;
            return temp;
        }

        @Override
        public void remove() {
            Node<E> after = current.next;
            after.previous = current.previous;
            current.previous.next = after;
            current.previous = current.next = null;
            current = after;
        }
    }
}
