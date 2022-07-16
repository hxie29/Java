/*(Parent reference for BST) Redefine TreeNode by adding a reference to a node’s
parent, Reimplement the insert and delete methods in the BST class to update the
parent for each node in the tree. Add the following new method in BST:
/** Return the node for the specified element.
* Return null if the element is not in the tree.
private TreeNode<E> getNode(E element)
/** Return true if the node for the element is a leaf
private boolean isLeaf(E element)
/** Return the path of elements from the specified element
 * to the root in an array list.
public ArrayList<E> getPath(E e)


Write a test program that prompts the user to enter 10 integers, adds them to
the tree, deletes the first integer from the tree, and displays the paths for all leaf
nodes. Here is a sample run:

Enter 10 integers: 45 54 67 56 50 45 23 59 23 67
[50, 54, 23]
[59, 56, 67, 54, 23] */

package c25_BST;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

public class E2515 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter 10 integers: ");
        Integer[] list = new Integer[10];
        for (int i = 0; i < list.length; i++) {
            list[i] = input.nextInt();
        }

        BST<Integer> tree = new BST<>(list);
        System.out.println("Complete tree inorder: \n");
        tree.inorder();
        tree.delete(tree.getRoot().element);
        System.out.println("After deleting the first integer, inorder\n");
        tree.inorder();

        Iterator<Integer> iterator = tree.iteratorEfficient();
        ArrayList<ArrayList<Integer>> paths = new ArrayList<>();
        while (iterator.hasNext()) {
            Integer e = iterator.next();
            if (tree.isLeaf(e)) {
                paths.add(tree.getPath(e));
            }
        }
        for (ArrayList<Integer> path: paths)
            System.out.println(path);
    }
}
