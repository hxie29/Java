/* (see InsertionSort class)
* (Generic insertion sort) Write the following two generic methods using insertion
* sort. The first method sorts the elements using the Comparable interface and the
* second uses the Comparator interface.
* public static <E extends Comparable<E>> void insertionSort (E[] list)
* public static <E void insertionSort(E[] list, Comparator<?super E> comparator)*/
package c23_Sorting;

import c13_AbstractClassesInterfaces.Circle;

public class E2306 {
    public static void main(String[] args) {
        Circle[] circles = new Circle[5];
        for (int i = 0; i < circles.length; i++) {
            circles[i] = new Circle(100 - i * 5);
        }

        InsertionSort.insertionSort(circles);
        for (Circle c: circles) {
            System.out.println(c);
        }
    }
}
