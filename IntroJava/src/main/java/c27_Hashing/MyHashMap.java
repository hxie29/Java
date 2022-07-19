package c27_Hashing;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

public class MyHashMap<K, V> implements MyMap<K, V> {

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
    LinkedList<Entry<K, V>>[] table;

/*Constructor*/
    public MyHashMap() {
        this(MAXIMUM_CAPACITY, DEFAULT_MAX_LOAD_FACTOR);
    }
    public MyHashMap(int initialCapacity) {
        this(initialCapacity, DEFAULT_MAX_LOAD_FACTOR);
    }
    public MyHashMap(int initialCapacity, float loadFactorThreshold) {
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
        removeEntries();
    }

    @Override
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    @Override
    public boolean containsValue(V value) {
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                LinkedList<Entry<K, V>> bucket = table[i];
                for (Entry<K,V> entry: bucket)
                    if (entry.getValue().equals(value))
                        return true;
            }
        }
        return false;
    }

    @Override
    public V get(K key) {
        int bucketIndex = hash(key.hashCode());
        if (table[bucketIndex] != null) {
            LinkedList<Entry<K, V>> bucket = table[bucketIndex];
            for (Entry<K,V> entry: bucket)
                if (entry.getKey().equals(key))
                    return entry.getValue();
        }
        return null;
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
    public V put(K key, V value) {
        // key already exists, value stored needs to be replaced
        if (get(key) != null) {
            int bucketIndex = hash(key.hashCode());
            LinkedList<Entry<K, V>> bucket = table[bucketIndex];
            for (Entry<K, V> entry: bucket)
                if (entry.getKey().equals(key)) {
                    V oldValue = entry.getValue();
                    entry.value = value;
                    return oldValue;
                }
        }

        //Key does not exit, a new entry to be added
        if (size >= capacity * loadFactorThreshold) {
            if (capacity == MAXIMUM_CAPACITY)
                throw new RuntimeException("Exceeding maximum capacity");
            rehash();
        }

        int bucketIndex = hash(key.hashCode());
        if (table[bucketIndex] == null)
            table[bucketIndex] = new LinkedList<>();
        table[bucketIndex].add(new Entry<>(key, value));
        size++;
        return value;
    }


    @Override
    public void remove(K key) {
        int bucketIndex = hash(key.hashCode());
        if (table[bucketIndex] != null) {
            LinkedList<Entry<K, V>> bucket = table[bucketIndex];
            for (Entry<K,V> entry: bucket)
                if (entry.getKey().equals(key))  {
                    bucket.remove(entry);
                    size--;
                    break;
                }
        }
    }

    @Override
    public Set<Entry<K, V>> entrySet() {
        Set<Entry<K, V>> set = new HashSet<>();
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                LinkedList<Entry<K, V>> bucket = table[i];
                for (Entry<K,V> entry: bucket)
                        set.add(entry);
            }
        }
        return set;
    }

    @Override
    public Set<K> keySet() {
        Set<K> set = new HashSet<>();
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                LinkedList<Entry<K, V>> bucket = table[i];
                for (Entry<K,V> entry: bucket)
                    set.add(entry.getKey());
            }
        }
        return set;
    }

    @Override
    public Set<V> values() {
        Set<V> set = new HashSet<>();
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null) {
                LinkedList<Entry<K, V>> bucket = table[i];
                for (Entry<K,V> entry: bucket)
                    set.add(entry.getValue());
            }
        }
        return set;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder("[");
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null && table[i].size() > 0)
                for (Entry<K,V> entry: table[i])
                    str.append(entry).append(", ");
        }
        str.append("]");
        return str.toString();
    }

    private void removeEntries() {
        for (int i = 0; i < capacity; i++) {
            if (table[i] != null)
                table[i].clear();
        }
    }

    private void rehash() {
        Set<Entry<K,V>> set = entrySet();
        capacity <<= 1; // double capacity
        table = new LinkedList[capacity];
        size = 0;
        for (Entry<K,V> entry: set)
            put(entry.getKey(), entry.getValue());
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
