package c10_ObjectOrientedThinking;/* Stacks have many applications. For example, the compiler uses a stack to process method
invocations. When a method is invoked, its parameters and local variables are pushed into a
stack. When a method calls another method, the new method’s parameters and local variables
are pushed into the stack. When a method finishes its work and returns to its caller, its associated
space is released from the stack.
You can define a class to model stacks. For simplicity, assume the stack holds the int
values. Thus, name the stack class StackOfIntegers. */

public class E10L07 {
    public static void main(String[] args) {
        StackOfIntegers stack = new StackOfIntegers();
        for (int i = 0; i < 10; i++) {
            stack.push(i);
        }

        while(stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}
