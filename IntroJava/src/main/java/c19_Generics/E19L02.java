//Generic methods demo
package c19_Generics;

public class E19L02 {
    public static void main(String[]args) {
        Integer[] ints = {1, 2, 3, 4, 5};
        String[] strs = {"London", "Paris", "New York"};

        print(ints);
        print(strs);
    }
    // generic methods
    public static <E> void print(E[] list) {
        for (E e: list)
            System.out.print(e + " ");
        System.out.println();
    }
}
