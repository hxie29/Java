/*(Use Comparator) Write the following generic method using selection sort
and a comparator:
public static <E> void selectionSort(E[] list,
Comparator<? super E> comparator)
Write a test program that creates an array of 10 GeometricObjects and
invokes this method using the GeometricObjectComparator introduced in
Listing 20.4 to sort the elements. Display the sorted elements. Use the following
statement to create the array:
GeometricObject[] list1 = {new Circle(5), new Rectangle(4, 5),
new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5),
new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
new Circle(6.5), new Rectangle(4, 5)};*/
package c20_ListStackQueue;

import c13_AbstractClassesInterfaces.Circle;
import c13_AbstractClassesInterfaces.GeometricObject;
import c13_AbstractClassesInterfaces.Rectangle;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class E2019 {
    public static void main(String[] args) {
        GeometricObject[] list1 = {new Circle(5), new Rectangle(4, 5),
                new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5),
                new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
                new Circle(6.5), new Rectangle(4, 5)};
        selectionSort(list1, new GeometricObjectComparator());
        System.out.println(Arrays.toString(list1));
    }

    public static <E> void selectionSort(E[] list, Comparator<? super E> comparator) {
        ArrayList<E> array = new ArrayList<>(Arrays.asList(list));
        array.sort(comparator);
        for (int i = 0; i < list.length; i++) {
            list[i] = array.get(i);
        }
    }
}
