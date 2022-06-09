package c13_AbstractClassesInterfaces;

import java.util.ArrayList;

@SuppressWarnings("CommentedOutCode")
class MyStack {
    private final ArrayList<Object> list = new ArrayList<>();

    public boolean isEmpty() {
        return list.isEmpty();
    }

    public int getSize() {
        return list.size();
    }

    public Object peek() {
        return list.get(list.size() - 1);
    }

    public void push(Object o) {
        list.add(o);
    }

    public Object pop() {
        Object temp = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return temp;
    }

    public ArrayList<Object> getList() {
        return list;
    }

    @Override
    public String toString() {
        return "stack: " + list;
    }

    //Deep copy
    @Override
    public Object clone() throws CloneNotSupportedException {
        Object o = super.clone();
        MyStack my2 = new MyStack();
        for (Object value : list) {
            my2.push(value);
        }
        return my2;
    }

    /*
    //Shallow copy
    @Override
    public Object clone() {
        try {
            return super.clone();
        }
        catch (CloneNotSupportedException ex) {
            return null;
        }
    }
*/
}
