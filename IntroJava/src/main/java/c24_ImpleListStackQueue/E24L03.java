// Test my arraylist
package c24_ImpleListStackQueue;

public class E24L03 {
    public static void main(String[] args) {
        MyList<String> list = new MyArrayList<>();

        list.add("America");
        System.out.println("(1) " + list);

        list.add(0, "Canada"); // Add it to the beginning of the list
        System.out.println("(2) " + list);

        list.add("Russia"); // Add it to the end of the list
        System.out.println("(3) " + list);

        list.add("France"); // Add it to the end of the list
        System.out.println("(4) " + list);

        list.add(2, "Germany"); // Add it to the list at index 2
        System.out.println("(5) " + list);

        list.add(5, "Norway"); // Add it to the list at index 5
        System.out.println("(6) " + list);

        // Remove elements from the list
        list.remove("Canada"); // Same as list.remove(0) in this case
        System.out.println("(7) " + list);

        list.remove(2); // Remove the element at index 2
        System.out.println("(8) " + list);

        list.remove(list.size() - 1); // Remove the last element
        System.out.print("(9) " + list + "\n(10) ");

        for (String s: list)
            System.out.print(s.toUpperCase() + " ");
    }
}
