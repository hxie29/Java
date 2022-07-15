/*(Implement postorder traversal without using recursion) Implement the
postorder method in BST using a stack instead of recursion. Write a test
program that prompts the user to enter 15 integers, stores them in a BST, and
invokes the postorder method to display the elements.*/
package c25_BST;

import java.util.Stack;

public class E2505 {
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

        System.out.println("Postorder without recursion:");
        postorder(tree.root);
        System.out.println("\nPostorder with recursion:");
        tree.postorder();
    }

    public static <E extends Comparable<E>> void postorder(TreeNode<E> root) {
        Stack<TreeNode<E>> stack1 = new Stack<>();
        Stack<TreeNode<E>> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            TreeNode<E> parent = stack1.pop();
            stack2.push(parent);
            if (parent.left != null)
                stack1.push(parent.left);
            if (parent.right != null)
                stack1.push(parent.right);
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().element + " ");
        }
    }
}