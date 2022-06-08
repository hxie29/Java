package c10_ObjectOrientedThinking;

public class StackOfIntegers {
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
        return (size != 0);
    }

    public int peek() {
        return elements[size - 1];
    }
}
