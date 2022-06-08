package c11_InheritancePolymorphism;

import java.util.ArrayList;

class MyStack {
    private final ArrayList<Object> list;

    public MyStack(){
        list = new ArrayList<>();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public int getSize(){
        return list.size();
    }

    public Object peek() {
        return list.get(list.size() - 1);
    }

    public void push(Object o) {
        list.add(o);
    }

    public Object pop() {
        Object temp = peek();
        list.remove(list.size() - 1);
        return temp;
    }

    @Override
    public String toString(){
        return "stack: " + list;
    }
}
