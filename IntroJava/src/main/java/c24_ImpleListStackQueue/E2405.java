/*(Implement GenericQueue using inheritance) In Section 24.5, Stacks and
Queues, GenericQueue is implemented using composition. Define a new queue
class that extends java.util.LinkedList.*/
package c24_ImpleListStackQueue;

import java.util.LinkedList;

public class E2405 {
    public static void main(String[] args) {
        GenericQueueInheri<String> queue = new GenericQueueInheri<>();

        // Add elements to the queue
        queue.enqueue("Tom"); // Add it to the queue
        System.out.println("(7) " + queue);

        queue.enqueue("Susan"); // Add it to the queue
        System.out.println("(8) " + queue);

        queue.enqueue("Kim"); // Add it to the queue
        queue.enqueue("Michael"); // Add it to the queue
        System.out.println("(9) " + queue);

        // Remove elements from the queue
        System.out.println("(10) " + queue.dequeue());
        System.out.println("(11) " + queue.dequeue());
        System.out.println("(12) " + queue);
    }
    private static class GenericQueueInheri<E> extends LinkedList<E> {
        void enqueue(E e) {
            addLast(e);
        }

        E dequeue() {
            return removeFirst();
        }

        int getSize(){
            return size();
        }

        @Override
        public String toString() {
            return "Queue: " + super.toString();
        }

    }
}
