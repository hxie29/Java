// Test iterators in BST
package c25_BST_AVLTrees;

import java.util.Iterator;

public class E25L10 {
    public static void main(String[] args) {
        BST<String> tree = new BST<>();
        tree.insert("George");
        tree.insert("Michael");
        tree.insert("Tom");
        tree.insert("Adam");
        tree.insert("Jones");
        tree.insert("Peter");
        tree.insert("Daniel");

        tree.forEach(e -> System.out.print(e.toUpperCase() + " "));
        System.out.println();
        Iterator<String> iteratorEfficient = tree.iteratorEfficient();
        while (iteratorEfficient.hasNext())
            System.out.print(iteratorEfficient.next().toUpperCase() + " ");
    }
}
