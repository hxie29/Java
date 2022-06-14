/*(Several types) Create an Association class that encapsulates two objects of different
types. Similar to Programming Exercise 19.5, create a Transition class that does the
same of Association class with three objects.*/
package c19_Generics;

public class Association<E> {
    public E o1;
    public E o2;

    public Association(E o1, E o2) {
        this.o1 = o1;
        this.o2 = o2;
    }

}
