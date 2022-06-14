// Super wild demo (lower bound wildcard
package c19_Generics;

public class E19L09 {
    public static void main(String[] args) {
        GenericStack<String> stack1 =  new GenericStack<>();
        GenericStack<String> stack2 =  new GenericStack<>();
        stack2.push("Java");
        stack2.push("2");
        stack1.push("Sun");
        add(stack1, stack2);
    }
    public static <T> void add(GenericStack<T> stack1, GenericStack<? super T> stack2) {
        while (!stack1.isEmpty())
            stack2.push(stack1.pop());
    }
}
