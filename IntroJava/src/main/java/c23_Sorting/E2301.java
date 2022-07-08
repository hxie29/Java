/* (see BubbleSort class)
(Generic bubble sort) Write the following two generic methods using bubble
sort. The first method sorts the elements using the Comparable interface, and
the second uses the Comparator interface.
public static <E extends Comparable<E>>
void bubbleSort(E[] list)
public static <E> void bubbleSort(E[] list,
Comparator<? super E> comparator) */
package c23_Sorting;

import c13_AbstractClassesInterfaces.Circle;

public class E2301 {
    public static void main(String[] args) {
        Circle[] circles = new Circle[5];
        for (int i = 0; i < circles.length; i++) {
            circles[i] = new Circle(100 - i * 5);
        }
        BubbleSort.bubbleSort(circles);
        for (Circle c: circles) {
            System.out.println(c);
        }

        System.out.println();

        Circle[] circles2 = new Circle[6];
        for (int i = 0; i < circles2.length; i++) {
            circles2[i] = new Circle(200 - i * 10);
        }
        BubbleSort.bubbleSort(circles2, new CircleComparator());
        for (Circle c: circles2) {
            System.out.println(c);
        }

    }
}
