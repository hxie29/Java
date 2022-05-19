/*
(Revise the MyStack class) Rewrite the MyStack class in Listing 11.10 to perform
a deep copy of the list field.
*/
import java.util.ArrayList;

public class E1308 {
    public static void main(String[] args) {
        MyStack m = new MyStack();
        m.push(2);
        m.push(4.2);
        m.push(9);

        try {
            MyStack m2 = (MyStack) m.clone();
            System.out.println(m == m2);
            System.out.println(m.toString());
            System.out.println(m.getList() == m2.getList());
        } 
        catch (CloneNotSupportedException ex) {
            System.out.println(ex.getMessage());
        }

    }
}

class MyStack{
    private ArrayList<Object> list = new ArrayList<>();

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
        Object temp = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return temp;
    }

    public ArrayList<Object> getList() {
        return list;
    }

    @Override
    public String toString(){
        return "stack: " + list.toString();
    }

    //Deep copy
    @Override
    public Object clone() throws CloneNotSupportedException {
        MyStack my2 = new MyStack();
        for (int i = 0; i < list.size(); i++) {
            my2.push(list.get(i));
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
