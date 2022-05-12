/* (Implement MyStack using inheritance) In Listing 11.10, MyStack is implemented
using composition. Define a new stack class that extends ArrayList.
Draw the UML diagram for the classes then implement MyStack. Write a test program
that prompts the user to enter five strings and displays them in reverse order.
*/
import java.util.ArrayList;
import java.util.Scanner;
public class E11L10 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        MyStack list = new MyStack();
        System.out.println("Enter 5 strings:");
        for (int i = 0; i < 5; i++) {
            list.push(input.nextLine());
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(list.pop());
        }
    }
}

class MyStack extends ArrayList{
    private ArrayList<Object> list = new ArrayList<>();

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
        return "stack: " + list.toString();
    }
}
