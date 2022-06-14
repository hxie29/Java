//(Pair of objects of the same type) Create a Pair class that encapsulates two objects
//of the same data type in an instance of Pair.
package c19_Generics;

public class Pair<E> {

    private final E o1;
    private final E o2;

    public Pair(E o1, E o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

    public E getOne() {
        return o1;
    }

    public E getTwo() {
        return o2;
    }

    public E[] getPair() {
        return (E[]) new Object[]{o1, o2};
    }
}
