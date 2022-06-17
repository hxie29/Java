/*(Use Comparator) Write the following generic method using selection sort
and a comparator:
public static <E> void selectionSort(E[] list,
Comparator<? super E> comparator)
Write a test program that creates an array of 10 GeometricObjects and
invokes this method using the GeometricObjectComparator introduced in
Listing 20.5 to sort the elements. Display the sorted elements. Use the following
statement to create the array:
GeometricObject[] list1 = {new Circle(5), new Rectangle(4, 5),
new Circle(5.5), new Rectangle(2.4, 5), new Circle(0.5),
new Rectangle(4, 65), new Circle(4.5), new Rectangle(4.4, 1),
new Circle(6.5), new Rectangle(4, 5)};
*/
/*Also in the same program, write the code that sorts six strings by their last
character. Use the following statement to create the array:
String[] list2 = {"red", "blue", "green", "yellow", "orange",
"pink"};*/
package c20_ListStackQueue;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class E2021 {
    public static void main(String[] args) {
        String[] list = {"red", "blue", "green", "yellow", "orange", "pink"};
        selectionSort(list, new StringComparator());
        System.out.println(Arrays.toString(list));
    }

    public static <E> void selectionSort(E[] list, Comparator<? super E> comparator) {
        ArrayList<E> array = new ArrayList<>(Arrays.asList(list));
        array.sort(comparator);
        for (int i = 0; i < list.length; i++) {
            list[i] = array.get(i);
        }
    }
    private static class StringComparator implements Comparator<String> {

        @Override
        public int compare(String o1, String o2) {
            return o1.charAt(o1.length() -1) - o2.charAt(o2.length()-1);
        }
    }
}
