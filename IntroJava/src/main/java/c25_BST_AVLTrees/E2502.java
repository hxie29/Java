/*(Test perfect binary tree) A perfect binary tree is a complete binary tree with
all levels fully filled. Add a method in the BST class to return true if the tree is
a perfect binary tree. (Hint: The number of nodes in a nonempty perfect binary
tree is 2height - 1)

* Returns true if the tree is a perfect binary tree
boolean isPerfectBST()*/

package c25_BST_AVLTrees;

public class E2502 {
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
        System.out.println("\nIs the tree perfect BST? " + tree.isPerfectBST());
    }
}
