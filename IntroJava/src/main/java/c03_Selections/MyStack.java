/*(Create Stack from list) Define a class MyStack that extends Stack to be
able to have its constructor use a list of objects instead of pushing each object
individually.*/
package c03_Selections;

import java.util.List;
import java.util.Stack;

public class MyStack<E> extends Stack<E> {
    public MyStack (List<E> list) {
        super();
        list.forEach(this::push);
    }
}
