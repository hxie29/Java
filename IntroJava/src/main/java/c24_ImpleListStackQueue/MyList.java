package c24_ImpleListStackQueue;


import java.util.Collection;

public interface MyList<E> extends Collection<E> {

    void add(int index, E e);

    E get(int index);

    int indexOf(Object e);

    int lastIndexOf(E e);

    E remove(int index);

    E set(int index, E e);

    @Override
    default boolean add(E e) {
        add(size(), e);
        return true;
    }

    @Override
    default boolean isEmpty() {
        return size() == 0;
    }

    @Override
    default boolean remove(Object e) {
        if (indexOf(e) >= 0) {
            remove(indexOf(e));
            return true;
        }
        else return false;
    }

    @Override
    default boolean contains(Object o) {
        for (E e: this)
            if (e.equals(o)) return true;
        return false;
    }

    @Override
    default boolean containsAll(Collection<?> c) {
        for (Object o: c)
            if (!this.contains(o)) return false;
        return true;
    }

    @Override
    default boolean addAll(Collection<? extends E> c) {
        for (E e: c)
            add(e);
        return true;
    }

    @Override
    default boolean removeAll(Collection<?> c) {
        for (Object e: c)
            remove(e);
        return true;
    }

    @Override
    default boolean retainAll(Collection<?> c) {
        c.forEach(e -> removeIf(a -> !this.contains(a)));
        return true;
    }

    @Override
    default Object[] toArray() {
        Object[] array = new Object[size()];
        for (int i = 0; i < size(); i++) {
            array[i] = get(i);
        }
        return array;
    }

    @Override
    default <T> T[] toArray(T[] array) {
        T[] list = (T[])new Object[size()];
        for (int i = 0; i < size(); i++) {
            if (get(i) != null)
                list[i] = (T)get(i);
        }
        return list;
    }

}
