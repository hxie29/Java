package c27_Hashing;

import java.util.*;
public class MyHashSet<E> implements Collection<E> {

/*Data Fields*/
    // Define the default hash-table size. Must be a power of 2
    private static final int DEFAULT_INITIAL_CAPACITY = 4;
    // Define the maximum hash-table size. 1 << 30 is same as 2^30
    private static final int MAXIMUM_CAPACITY = 1 << 30;
    private int capacity;

    private static final float DEFAULT_MAX_LOAD_FACTOR = 0.75f;

    private float loadFactorThreshold;

    private int size;
    // Hash table is an array with each cell being a linked list - separate chaining
    LinkedList<E>[] table;

/*Constructor*/
    public MyHashSet() {
        this(MAXIMUM_CAPACITY, DEFAULT_MAX_LOAD_FACTOR);
    }
    public MyHashSet(int initialCapacity) {
        this(initialCapacity, DEFAULT_MAX_LOAD_FACTOR);
    }
    public MyHashSet(int initialCapacity, float loadFactorThreshold) {
        if (initialCapacity > MAXIMUM_CAPACITY)
            capacity = MAXIMUM_CAPACITY;
        else
            capacity = trimToPowerOf2(initialCapacity);
        this.loadFactorThreshold = loadFactorThreshold;
        table = new LinkedList[capacity];
    }


/*Methods*/
    @Override
    public void clear() {
        size = 0;
        removeElements();
    }

    @Override
    public boolean contains(Object element) {
        int bucketIndex = hash(element.hashCode());
        if (table[bucketIndex] != null) {
            LinkedList<E> bucket = table[bucketIndex];
            for (E entry: bucket)
                if (entry.equals(element))
                    return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean add(E element) {
        // key already exists, value stored needs to be replaced
        if (contains(element))
            return false;

        //Key does not exit, a new entry to be added
        if (size >= capacity * loadFactorThreshold) {
            if (capacity == MAXIMUM_CAPACITY)
                throw new RuntimeException("Exceeding maximum capacity");
            rehash();
        }

        int bucketIndex = hash(element.hashCode());
        if (table[bucketIndex] == null)
            table[bucketIndex] = new LinkedList<>();
        table[bucketIndex].add(element);
        size++;
        return true;
    }

    @Override
    public boolean remove(Object element) {
        if (!contains(element))
            return false;
        int bucketIndex = hash(element.hashCode());
        if (table[bucketIndex] != null) {
            LinkedList<E> bucket = table[bucketIndex];
            bucket.removeIf(entry -> entry.equals(element));
        }
        size--;
        return true;
    }

    public ArrayList<E> setToList() {
        ArrayList<E> list = new ArrayList<>();
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null)
                list.addAll(table[i]);
        }
        return list;
    }

    @Override
    public String toString() {
        ArrayList<E> list = setToList();
        StringBuilder str = new StringBuilder("[");
        if (list.size() > 0) {
            for (int i = 0; i < list.size() - 1; i++)
                str.append(list.get(i)).append(", ");
            str.append(list.get(list.size()-1));
        }
        str.append("]");
        return str.toString();
    }

    @Override
    public Iterator<E> iterator() {
        return new MyHashSetIterator<E>(this);
    }

    @Override
    public boolean addAll(Collection<? extends E> c) {
        if (c.size() == 0)
            return false;
        c.forEach(this::add);
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o))
                return false;
        }
        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (Object o : c) {
            if (contains(o))
                remove(o);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o))
                remove(o);
        }
        return true;
    }

    @Override
    public Object[] toArray() {
        ArrayList<E> list = setToList();
        return list.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    private static class MyHashSetIterator<E> implements Iterator<E> {
        private ArrayList<E> list;
        private int current = 0;
        private MyHashSet<E> set;

        public MyHashSetIterator(MyHashSet<E> set) {
            this.set = set;
            list = set.setToList();
        }

        @Override
        public boolean hasNext() {
            return current < list.size();
        }

        @Override
        public E next() {
            return list.get(current++);
        }

        @Override
        public void remove() {
            if (current > 0 && current < list.size()) {
                E e = list.remove(--current);
                set.remove(e);
            }
        }
    }
    private void removeElements() {
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null)
                table[i].clear();
        }
    }

    private void rehash() {
        ArrayList<E> list = setToList();
        capacity <<= 1; // double capacity
        table = new LinkedList[capacity];
        size = 0;
        this.addAll(list);
    }

    private int hash(int hashCode) {
        return supplementalHash(hashCode) & (capacity -1);
    }
    private static int supplementalHash(int h) {
        h ^= (h >>> 20) ^ (h >>> 12);
        return h ^ (h >>> 7) ^ (h >>> 4);
    }

    private static int trimToPowerOf2(int initialCapacity) {
        int capacity = 1;
        while (capacity < initialCapacity)
            capacity <<= 1; // Same as capacity *= 2. <= is more efficient
        return capacity;
    }
}
