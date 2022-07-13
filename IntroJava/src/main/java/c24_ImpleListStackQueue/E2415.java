/*(Test MyArrayList) Design and write a complete test program to test if the
MyArrayList class in Listing 24.2 meets all requirements.*/
package c24_ImpleListStackQueue;

import java.util.Iterator;

public class E2415 {
    public static void main(String[] args) {
        Integer[] numbers = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29,
                        283, 293,307, 311, 313, 317, 331, 337, 347, 349};

        MyList<Integer> list1 = new MyArrayList<>(numbers); // constructor
        System.out.println("(0) " + list1);

        MyArrayList<String> list = new MyArrayList<>();
        list.add("America");
        System.out.println("(1) " + list);

        list.add(0, "Canada"); // Add it to the beginning of the list
        System.out.println("(2) " + list + " Size: " + list.size());
        System.out.println("(3) List contains Canada? : " + list.contains("Canada"));

        list.add(1, "Japan");
        System.out.println("(5) index of Canada is " + list.indexOf("Canada"));

        list.add(3, "Norway");
        System.out.println("(6) " + list + " last index of Canada is " + list.lastIndexOf("Canada"));

        list.remove(0);
        System.out.println("(7) After removal of first element: " + list);

        list.set(0, "Iceland");
        System.out.println("(8) Set first element to Iceland: " + list);

        list.trimToSize();
        System.out.println("(9) trim to size: " + list.size());

        Iterator<String> iterator = list.iterator();
        System.out.println("(10) Iterator of list: " + iterator);
        System.out.print("(11) Iterating elements : ");
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
            iterator.remove();
        }
        System.out.println("\n(12) Iterator removing all elements: " + list.size());

        list.add("Iceland");
        list.clear(); // Clear and print list
        System.out.println("(13) " + list.size() + " list: " + list);
    }
}
