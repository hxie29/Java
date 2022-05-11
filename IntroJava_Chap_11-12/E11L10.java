import java.util.ArrayList;

public class E11L10 {
    public static void main(String[] args) {

    }
}

class MyStack{
    private ArrayList<Obeject> list = new ArrayList<>();

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

    @Override
    public String toString(){
        return "stack: " + list.toString();
    }
}
