/*(Find the nonleaves) Add a method in the BST class to return the number of the
nonleaves as follows:
/** Return the number of nonleaf nodes
public int getNumberofNonLeaves()*/
package c25_BST;

public class E2507 {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.insert(60);
        tree.insert(55);
        tree.insert(100);
        tree.insert(45);
        tree.insert(57);
        tree.insert(67);
        tree.insert(107);

        System.out.println("Number of non leaves: " + tree.getNumberOfNonLeaves());
    }
}