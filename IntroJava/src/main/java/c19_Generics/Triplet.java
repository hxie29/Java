/*(Inheritance between generic classes) Create a Triplet class that encapsulates
three objects of the same data type in a given instance of Triplet.*/
package c19_Generics;

public class Triplet<E> {
    private final E one;
    private final E two;
    private final E three;

    public Triplet(E one, E two, E three) {
        this.one = one;
        this.two = two;
        this.three = three;
    }

    public E getOne() {
        return one;
    }

    public E getTwo() {
        return two;
    }

    public E getThree() {
        return three;
    }
}
