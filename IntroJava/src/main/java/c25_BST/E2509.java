/*(Tree clone and equals) Implement the clone and equals methods in the
BST class. Two BST trees are equal if they contain the same elements. The clone
method returns an identical copy of a BST.*/
package c25_BST;

public class E2509 {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.insert(60);
        tree.insert(55);
        tree.insert(100);
        tree.insert(45);
        tree.insert(57);
        tree.insert(67);
        tree.insert(107);

        BST<Integer> tree2 = tree.clone();

        System.out.println("\nPostorder original with recursion:");
        tree.postorder();
        System.out.println("\nPostorder copy with recursion:");
        tree2.postorder();

        System.out.println("\nClone equals? " + tree.equals(tree2));
        tree2.insert(167);
        System.out.println("\nAfter adding 167, equals? " + tree.equals(tree2));
    }
}