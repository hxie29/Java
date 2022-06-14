// generic stack class
package c19_Generics;

public class E19L01 {
    public static void main(String[] args) {
        GenericStack<Integer> stack1 = new GenericStack<>();
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);

        GenericStack<String> stack2 = new GenericStack<>();
        stack2.push("London");
        stack2.push("Paris");
        stack2.push("Berlin");
    }
}
