/*(Add new methods in BST) Add the following new methods in BST.
* Display the nodes in a breadth-first traversal
public void breadthFirstTraversal()
* Return the height of this binary tree
public int height()*/

package c25_BST_AVLTrees;

public class E2501 {
    // see BST class
    public static void main(String[] args){
        BST<Integer> tree = new BST<>();
        tree.insert(60);
        tree.insert(55);
        tree.insert(100);
        tree.insert(45);
        tree.insert(57);
        tree.insert(67);
        tree.insert(107);

        System.out.println("Height of the tree " + tree.height());
        System.out.println("Breadth first traversal: ");
        tree.breadthFirstTraversal();
    }
}
