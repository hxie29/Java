// Test BST class
package c25_BST;

import java.util.ArrayList;

public class E25L05 {
    public static void main(String[] args) {
        BST<String> tree = new BST<>();
        tree.insert("George");
        tree.insert("Michael");
        tree.insert("Tom");
        tree.insert("Adam");
        tree.insert("Jones");
        tree.insert("Peter");
        tree.insert("Daniel");

        System.out.print("Inorder (sorted): ");
        tree.inorder();

        System.out.print("\nPostorder (sorted): ");
        tree.postorder();

        System.out.print("\nPreorder (sorted): ");
        tree.preorder();

        System.out.print("\nIs Peter in the tree? " + tree.contains("Peter"));

        System.out.print("\nA path from the root to Peter is : ");
        ArrayList<TreeNode<String>> path = tree.path("Peter");
        if (path != null) path.forEach(e -> System.out.print(e.element + " "));

        Integer[] numbers = {2, 4, 3, 1, 8, 5, 6, 7};
        BST<Integer> intTree = new BST<>(numbers);
        System.out.print("\nInteger tree inorder (sorted): ");
        intTree.inorder();
        System.out.print("\nPostorder (sorted): ");
        intTree.postorder();
        System.out.print("\nPreorder (sorted): ");
        intTree.preorder();
    }
}
