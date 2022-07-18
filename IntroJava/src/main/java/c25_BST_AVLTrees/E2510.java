/*(Inorder iterator) Add the following method in the BST class that returns an
iterator for traversing the elements in a BST in inorder.
/** Returns an iterator for traversing the elements in inorder
java.util.Iterator<E> inorderIterator()*/
package c25_BST_AVLTrees;

import java.util.Iterator;

public class E2510 {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.insert(60);
        tree.insert(55);
        tree.insert(100);
        tree.insert(45);
        tree.insert(57);
        tree.insert(67);
        tree.insert(107);

        System.out.println("\nPreorder with preorder method:");
        tree.preorder();
        System.out.println("\nPreorder with efficient iterator of preorder sequence:");
        Iterator<Integer> iterator = tree.preorderIteratorEfficient();
        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");

        System.out.println("\nPreorder with iterator of preorder sequence:");
        Iterator<Integer> iterator2 = tree.preorderIterator();
        while (iterator2.hasNext())
            System.out.print(iterator2.next() + " ");
    }
}