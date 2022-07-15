/*(Preorder iterator) Add the following method in the BST class that returns an
iterator for traversing the elements in a BST in preorder.
/** Return an iterator for traversing the elements in preorder
java.util.Iterator<E> preorderIterator()*/
package c25_BST;

import java.util.Iterator;

public class E2511 {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.insert(60);
        tree.insert(55);
        tree.insert(100);
        tree.insert(45);
        tree.insert(57);
        tree.insert(67);
        tree.insert(107);

        System.out.println("\nInorder with preorder method:");
        tree.inorder();
        System.out.println("\nInorder with iterator of preorder sequence:");
        Iterator<Integer> iterator = tree.inorderIterator();
        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");
    }
}