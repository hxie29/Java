/*((Implement GenericStack using inheritance) In Listing 19.1, GenericStack is
implemented using composition. Define a new stack class that extends ArrayList.
Draw the UML diagram for the classes then implement GenericStack. Write a test
program that prompts the user to enter five strings and displays them in reverse order.*/

package c19_Generics;
import java.util.ArrayList;

public class GenericStack3<E> extends ArrayList<E> {

    public int getSize() {
        return this.size();
    }

    public E peek() {
        return this.get(this.size() -1);
    }

    public boolean isEmpty() {
        return this.size() == 0;
    }

    public void push(E o) {
        this.add(o);
    }

    public E pop() {
        E temp = this.get(this.size() -1);
        this.remove(this.size() -1);
        return temp;
    }

    @Override
    public String toString() {
        return "stack: " + super.toString();
    }
}
