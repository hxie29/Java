/*(Implement inorder traversal without using recursion) Implement the inorder
method in BST using a stack instead of recursion. Write a test program that
prompts the user to enter 15 integers, stores them in a BST, and invokes the
inorder method to display the elements.*/
package c25_BST_AVLTrees;

import java.util.Stack;
import c25_BST_AVLTrees.BST.TreeNode;

public class E2503{
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.insert(60);
        tree.insert(55);
        tree.insert(100);
        tree.insert(45);
        tree.insert(57);
        tree.insert(67);
        tree.insert(107);

        System.out.print("Inorder 1 without recursion:");
        inorder(tree.root);
        System.out.print("\nInorder 2 without recursion:");
        inorder2(tree.root);
        System.out.print("\nInorder with recursion:");
        tree.inorder();
    }

    public static <E extends Comparable<E>> void inorder2(TreeNode<E> root) {
        Stack<TreeNode<E>> roots = new Stack<>();
        while (!roots.isEmpty() || root != null) {
            if (root != null) {
                roots.push(root);
                root = root.left;
            }
            else {
                root = roots.pop();
                System.out.print(root.element + " ");
                root = root.right;
            }
        }
    }


        public static <E extends Comparable<E>> void inorder(TreeNode<E> root) {
        Stack<TreeNode<E>> roots = new Stack<>();
        Stack<E> elements = new Stack<>();
        Stack<E> temp = new Stack<>();
        if (root != null) {
            roots.push(root);
            elements.push(root.element);
        }
        while (!roots.isEmpty()) {
            TreeNode<E> r = roots.pop();
            if (r.right != null) {
                roots.push(r.right);
                while (!elements.isEmpty() && elements.peek().compareTo(r.right.element) < 0) {
                    temp.push(elements.pop());
                }
                elements.push(r.right.element);
                while (!temp.isEmpty()) {
                    elements.push(temp.pop());
                }
            }
            if (r.left != null) {
                roots.push(r.left);
                while (!elements.isEmpty() && elements.peek().compareTo(r.left.element) < 0) {
                    temp.push(elements.pop());
                }
                elements.push(r.left.element);
                while (!temp.isEmpty()) {
                    elements.push(temp.pop());
                }
            }
        }
        while (!elements.isEmpty())
            System.out.print(elements.pop() + " ");
    }
}
