package c25_BST;

public class TreeNode<E> {
    protected E element;
    protected TreeNode<E> left;
    protected TreeNode<E> right;
    protected TreeNode<E> parent;

    public TreeNode(E e) {
        element = e;
    }
}
