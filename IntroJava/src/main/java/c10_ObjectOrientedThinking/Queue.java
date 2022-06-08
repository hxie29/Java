package c10_ObjectOrientedThinking;

public class Queue {
    private final int capacity = 8;
    private int[] elements = new int[capacity];
    private int size;

    //Constructor
    public Queue(){
    }

    public void enqueue(int v){
        if (size == elements.length){
            int[]temp = new int[elements.length * 2];
            System.arraycopy(elements, 0, temp, 0, elements.length);
            elements = temp;
        }
        elements[size] = v;
        size++;
    }

    public int dequeue(){
        int[]temp = new int[elements.length];
        System.arraycopy(elements, 1, temp, 0, elements.length - 1);
        int value = elements[0];
        elements = temp;
        size--;
        return value;
    }

    public boolean empty(){
        return size == 0;
    }

    public int getSize(){
        return size;
    }
}
