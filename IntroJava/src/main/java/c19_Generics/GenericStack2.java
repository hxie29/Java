/*(Revising Listing 19.1) Revise the GenericStack class in Listing 19.1 to implement
it using an array rather than an ArrayList. You should check the array size
before adding a new element to the stack. If the array is full, create a new array that
doubles the current array size and copy the elements from the current array to the
new array.*/

package c19_Generics;

import java.util.Arrays;

public class GenericStack2<E> {

    private int capacity = 100;
    private int size;
    private E[] list = (E[]) new Object[capacity];

    public int getSize() {
        return size;
    }

    public E peek() {
        if (size == 0)
            return null;
        else
            return list[list.length -1];
    }

    public boolean isEmpty() {
        return list.length == 0;
    }

    public void push(E o) {
        list[size++] = o;

        if (size == capacity) {
            E[] temp = (E[]) new Object[capacity *= 2];
            System.arraycopy(list,0, temp, 0, list.length);
            list = temp;
        }
    }

    public E pop() {
        if (size == 0)
            return null;
        else return list[--size];
    }

    @Override
    public String toString() {
        return "stack: " + Arrays.toString(list);
    }
}
