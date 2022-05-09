/* Stacks have many applications. For example, the compiler uses a stack to process method
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

        while(!stack.empty()) {
            System.out.print(stack.pop() + " ");
        }
    }
}

class StackOfIntegers {
    // DATA fields
    private int[] elements;
    private int size;
    public static final int DEFAULT_CAPACITY = 16;

    // Constructors
    public StackOfIntegers() {
        this(DEFAULT_CAPACITY);
    }

    public StackOfIntegers(int capacity) {
        elements = new int[capacity];
    }

    public void push(int value){
        if (size >= elements.length) {
            int[] temp = new int[elements.length * 2];
            System.arraycopy(elements, 0, temp, 0, elements.length);
            elements = temp;
        }
        elements[size++] = value;
    }

    public int pop(){
        return elements[--size];
    }
    
    public int getSize() {
        return size;
    }

    public boolean empty() {
        return (size == 0);
    }

    public int peek() {
        return elements[size - 1];
    }
}
