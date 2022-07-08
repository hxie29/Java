/*(Generic quick sort) Write the following two generic methods using quick sort.
The first method sorts the elements using the Comparable interface, and the
second uses the Comparator interface.
public static <E extends Comparable<E>> Void quickSort(E[] list)
public static <E> void quickSort(E[] list, Comparator<? super E> comparator)*/
package c23_Sorting;

import c13_AbstractClassesInterfaces.Circle;

import java.util.Comparator;

public class E2303 {
    public static void main(String[] args) {
        Circle[] circles = new Circle[5];
        for (int i = 0; i < circles.length; i++) {
            circles[i] = new Circle(100 - i * 5);
        }
        quickSort(circles);
        for (Circle c: circles) {
            System.out.println(c);
        }

        System.out.println();

        Circle[] circles2 = new Circle[6];
        for (int i = 0; i < circles2.length; i++) {
            circles2[i] = new Circle(200 - i * 10);
        }
        quickSort(circles2, new CircleComparator());
        for (Circle c: circles2) {
            System.out.println(c);
        }
    }

    public static <E extends Comparable<E>> void quickSort(E[] list) {
        quickSort(list, 0, list.length -1);
    }

    public static <E extends Comparable<E>> void quickSort(E[] list, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            quickSort(list, first, pivotIndex - 1);
            quickSort(list,pivotIndex + 1, last);
        }
    }

    public static <E extends Comparable<E>> int partition(E[] list, int first, int last) {
        E pivot = list[first];
        int low = first + 1;
        int high = last;
        while (high > low) {
            while (low <= high && list[low].compareTo(pivot) <= 0) {
                low++;
            }

            while (low <= high && list[high].compareTo(pivot) >0) {
                high--;
            }

            if (high > low) {
                E temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while (high > first && list[high].compareTo(pivot) >=0)
            high--;

        if (list[high].compareTo(pivot) <0) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        }
        else return first;
    }

    public static <E> void quickSort(E[] list, Comparator<? super E> comparator) {
        quickSort(list, 0, list.length -1, comparator);
    }


    public static <E> void quickSort(E[] list, int first, int last, Comparator<? super E> comparator) {
        if (last > first) {
            int pivotIndex = partition(list, first, last, comparator);
            quickSort(list, first, pivotIndex - 1, comparator);
            quickSort(list,pivotIndex + 1, last, comparator);
        }
    }

    public static <E> int partition(E[] list, int first, int last, Comparator<? super E> comparator) {
        E pivot = list[first];
        int low = first + 1;
        int high = last;
        while (high > low) {
            while (low <= high && comparator.compare(list[low],pivot) <= 0) {
                low++;
            }

            while (low <= high && comparator.compare(list[high], pivot) >0) {
                high--;
            }

            if (high > low) {
                E temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }

        while (high > first && comparator.compare(list[high], pivot) >= 0)
            high--;

        if (comparator.compare(list[high], pivot) <0) {
            list[first] = list[high];
            list[high] = pivot;
            return high;
        }
        else return first;
    }

}
