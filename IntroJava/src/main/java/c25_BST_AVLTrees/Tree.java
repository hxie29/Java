package c25_BST_AVLTrees;

import java.util.Collection;

public interface Tree<E> extends Collection<E> {

    boolean search(E e);

    boolean insert(E e);

    boolean delete (E e);

    default void inorder() {

    }

    default void preorder(){

    }

    default void postorder() {

    }

    int getSize();

    @Override
    default boolean isEmpty() {
        return size() == 0;
    }
    @Override
    void clear();

    @Override
    default boolean add(E e) {
        return insert(e);
    }

    @Override
    default boolean remove(Object o) {
        return delete((E)o);
    }

    @Override
    default int size() {
     return getSize();
    }

    @Override
    default boolean contains(Object o) {
        return search((E)o);
    }

    @Override
    default boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    default boolean addAll(Collection<? extends E> c) {
        c.forEach(this::insert);
        return true;
    }

    @Override
    default boolean removeAll(Collection<?> c) {
        c.forEach(e -> {
            if (search((E) e))
                delete((E) e);
        });
        return true;
    }

    @Override
    default boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    default Object[] toArray() {
        return null;
    }

    @Override
    default <T> T[] toArray(T[] a) {
        return null;
    }
}
