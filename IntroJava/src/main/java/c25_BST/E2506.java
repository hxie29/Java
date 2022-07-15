/*(Find the leaves) Add a method in the BST class to return the number of the
leaves as follows:
* Return the number of leaf nodes
public int getNumberOfLeaves()*/
package c25_BST;

public class E2506 {
    public static void main(String[] args) {
        BST<Integer> tree = new BST<>();
        tree.insert(60);
        tree.insert(55);
        tree.insert(100);
        tree.insert(45);
        tree.insert(57);
        tree.insert(67);
        tree.insert(107);

        System.out.println("Number of leaves: " + tree.getNumberOfLeaves());
    }
}