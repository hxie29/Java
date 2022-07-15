//Testing BST deletion
package c25_BST;

public class E25L07 {
    public static void main(String[] args) {
        Integer[] numbers = {2, 4, 3, 1, 8, 5, 6, 7};
        BST<Integer> intTree = new BST<>(numbers);
        System.out.print("\nInteger tree (sorted): ");
        System.out.print("\nInorder: ");
        intTree.inorder();
        System.out.print("\nPostorder: ");
        intTree.postorder();
        System.out.print("\nPreorder: ");
        intTree.preorder();

        intTree.delete(2);
        System.out.println("\n\nAfter deleting 2:");
        System.out.print("Inorder: ");
        intTree.inorder();
        System.out.print("\nPostorder: ");
        intTree.postorder();
        System.out.print("\nPreorder: ");
        intTree.preorder();

        intTree.delete(5);
        System.out.println("\n\nAfter deleting 5:");
        System.out.print("Inorder: ");
        intTree.inorder();
        System.out.print("\nPostorder: ");
        intTree.postorder();
        System.out.print("\nPreorder: ");
        intTree.preorder();
    }
}
