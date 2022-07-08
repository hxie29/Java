/*
* (Generic Heap using Comparator) Revise Heap in Listing 23.9, using a generic
* parameter and a Comparator for comparing objects. Define the class as follows:
* class HeapWithComparator<E> {
    private Comparator<? super E> comparator; // For comparing elements
    public HeapWithComparator() {
        // Implement no−arg constructor by creating a comparator for natural order
    }
public HeapWithComparator(Comparator<? super E> comparator) {
    this.comparator = comparator;
}
// Implement all add, remove, and getSize method
} */
package c23_Sorting;

import c13_AbstractClassesInterfaces.Circle;

public class E2305 {
    public static void main(String[] args) {
        Circle[] circles = new Circle[5];
        for (int i = 0; i < circles.length; i++) {
            circles[i] = new Circle(100 - i * 5);
        }

        HeapWithComparator<Circle> heapCircle = new HeapWithComparator<>(circles, new CircleComparator());

        for (int i = circles.length - 1; i >= 0; i--) {
            circles[i] = heapCircle.remove();
        }

        for (Circle c: circles) {
            System.out.println(c);
        }
    }
}
