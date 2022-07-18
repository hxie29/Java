/*(Implement preorder traversal without using recursion) Implement the
preorder method in BST using a stack instead of recursion. Write a test program
that prompts the user to enter 15 integers, stores them in a BST, and
invokes the preorder method to display the elements.*/
package c25_BST_AVLTrees;

import java.util.Stack;
import c25_BST_AVLTrees.BST.TreeNode;

public class E2504 {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.insert(60);
        tree.insert(55);
        tree.insert(100);
        tree.insert(45);
        tree.insert(57);
        tree.insert(67);
        tree.insert(107);
        tree.insert(3);
        tree.insert(123);

        System.out.println("Preorder without recursion:");
        preorder(tree.root);
        System.out.println("\nPreorder with recursion:");
        tree.preorder();
    }

    public static <E extends Comparable<E>> void preorder(TreeNode<E> root) {
        Stack<TreeNode<E>> roots = new Stack<>();
        while (!roots.isEmpty() || root != null) {
            if (root != null) {
                System.out.print(root.element + " ");
                if (root.right != null)
                    roots.push(root.right);
                root = root.left;
            } else {
                root = roots.pop();
            }
        }
    }
}