package c25_BST_AVLTrees;

import java.util.ArrayList;

public class AVLTree<E extends Comparable<E>> extends BST<E> {

    public AVLTree(){
        super();
    }

    public AVLTree(E[] objects){
        super(objects);
    }

    @Override
    protected TreeNode<E> createNewNode(E e) {
        return new AVLTreeNode<>(e);
    }

    @Override
    public boolean insert(E e) {
        boolean value = super.insert(e);
        if (value) balancePath(e);
        return value;
    }

    @Override
    public boolean delete(E e) {
        TreeNode<E> parent = null;
        TreeNode<E> current = root;

        while (current != null) {
            if (e.compareTo(current.element) < 0) {
                parent = current;
                current = current.left;
            }
            else if (e.compareTo(current.element) > 0) {
                parent = current;
                current = current.right;
            }
            else break;
        }

        if (current == null) return false;
        // the node does not have left child, then connect the right child to parent
        if (current.left == null) {
            if (parent == null) {
                root = current.right;
                root.parent = null;
            }
            else {
                // check the node is left child or right child
                if (e.compareTo(parent.element) < 0) {
                    parent.left = current.right;
                    if (current.right != null)
                        parent.left.parent = parent;
                }
                else {
                    parent.right = current.right;
                    if (current.right != null)
                        parent.right.parent = parent;
                }
                balancePath(parent.element);
            }
        }
        else {
            //the current node has a left child
            // find the rightMost (the maximum element of the subtree) child of the node's left subtree and its parent
            // copy the rightMost to current position, and delete the rightMost
            TreeNode<E> rightMost = current.left;
            TreeNode<E> parentRightMost = current;
            // find the right most element of the left subtree of current node
            while (rightMost.right != null) {
                parentRightMost = rightMost;
                rightMost = rightMost.right;
            }
            // copy the right most element to position of current node
            current.element = rightMost.element;

            //delete the right most element
            if (parentRightMost.right == rightMost) {
                parentRightMost.right = rightMost.left;
                if (rightMost.left != null)
                    parentRightMost.right.parent = parentRightMost;
            }
            // if the right most is the current left, and the parent is current,
            else{
                parentRightMost.left = rightMost.left;
                if (rightMost.left != null)
                    parentRightMost.left.parent = parentRightMost;
            }
            balancePath(parentRightMost.element);
        }
        size--;
        return true;
    }

    private void updateHeight(AVLTreeNode<E> node) {
        if (node.left == null && node.right == null)
            node.height = 0;
        else if (node.left == null)
            node.height = 1 +  ((AVLTreeNode<E>)node.right).height;
        else if (node.right == null)
            node.height = 1 + ((AVLTreeNode<E>)node.left).height;
        else {
            node.height = 1 + Math.max(((AVLTreeNode<E>)node.right).height, ((AVLTreeNode<E>)node.left).height);
        }
    }

    private void balancePath(E e){
        ArrayList<TreeNode<E>> paths = path(e);
        for (int i = paths.size() - 1; i >= 0; i--) {
            AVLTreeNode<E> a = (AVLTreeNode<E>)(paths.get(i));
            AVLTreeNode<E> parentOfA = (i > 0) ? (AVLTreeNode<E>) (a.parent) : null;
            updateHeight(a);
            switch (balanceFactor(a)) {
                case -2 -> {
                    if (balanceFactor((AVLTreeNode<E>) a.left) <= 0)
                        balanceLL(a, parentOfA);
                    else balanceLR(a, parentOfA);
                    return;
                }
                case +2 -> {
                    if (balanceFactor((AVLTreeNode<E>) a.right) >= 0)
                        balanceRR(a, parentOfA);
                    else balanceRL(a, parentOfA);
                    return;
                }
            }
        }
    }

    private int balanceFactor(AVLTreeNode<E> node){
        if (node.right == null)
            return -node.height;
        else if (node.left == null)
            return node.height;
        else
            return ((AVLTreeNode<E>)node.right).height - ((AVLTreeNode<E>)node.left).height;
    }

    private void balanceLL(TreeNode<E> a, TreeNode<E> parentOfA) {
        /*Perform LL rotation of A:
         * B = left child of A
         * if A is the root,
         *   then let root be B
         * else
         *   find parent of A called parent
         *   if A is left child, then let parent.left child be B
         *   else let parent.right child be B
         *
         * find B's right child, let it be left child of A
         * let A be right child of B
         * update the height of B and A
         */
        AVLTreeNode<E> b = (AVLTreeNode<E>)a.left;
        if (a == root) {
            root = b;
            b.parent = null;
        }
        else {
            if (a == parentOfA.left)
                parentOfA.left = b;
            else
                parentOfA.right = b;
            b.parent = parentOfA;
        }

        a.left = b.right;
        b.right.parent = a;
        b.right = a;
        a.parent = b;
        updateHeight((AVLTreeNode<E>)a);
        updateHeight(b);
    }


    private void balanceRR(TreeNode<E> a, TreeNode<E> parentOfA) {
    /*Perform RR rotation of A:
     * B = right child of A
     * if A is the root,
     *   then let root be B
     * else
     *   find parent of A called parent
     *   if A is left child, then let parent.left child be B
     *   else let parent.right child be B
     *
     * find B's left child, let it be right child of A
     * let A be left child of B
     * update the height of B and A
     */
        AVLTreeNode<E> b = (AVLTreeNode<E>)a.right;
        if (a == root){
            root = b;
            b.parent = null;
        }
        else {
            if (a == parentOfA.left)
                parentOfA.left = b;
            else
                parentOfA.right = b;
            b.parent = parentOfA;
        }

        a.right = b.left;
        b.left.parent = a;
        b.left = a;
        a.parent = b;
        updateHeight((AVLTreeNode<E>)a);
        updateHeight(b);
    }

    private void balanceLR(TreeNode<E> a, TreeNode<E> parentOfA) {
        /*Perform LR rotation A (reusing code):
         * B = left child of A
         * performing a RR rotation of B
         * performing a LL rotation of A
         */

        /*Perform LR rotation A (efficient):
         * B = left child of A
         * C = right child of B
         * if A is the root, then let root be C
         * else
         *      find A's parent
         *      if A is left child, let parent's left child be C
         *      else let parent's right child be C
         *
         * let C's left child be B's right child
         * let C's right child be A's left child
         * let A be C's right child
         * let B be C's left child
         * update the height of A, B, C
         */

        AVLTreeNode<E> b = (AVLTreeNode<E>)a.left;
        AVLTreeNode<E> c = (AVLTreeNode<E>)b.right;
        if (a == root){
            root = c;
            c.parent = null;
        }
        else {
            if (a == parentOfA.left)
                parentOfA.left = c;
            else
                parentOfA.right = c;
            c.parent = parentOfA;
        }

        b.right = c.left;
        c.left.parent = b;
        a.left = c.right;
        c.right.parent = a;
        c.right = a;
        a.parent = c;
        c.left = b;
        c.parent = c;
        updateHeight((AVLTreeNode<E>)a);
        updateHeight(b);
        updateHeight(c);
    }

    private void balanceRL(TreeNode<E> a, TreeNode<E> parentOfA) {
        /* Perform RL rotation A:
         * B = right child of A
         * (performing a LL rotation of B):
         *      let C be left child of B
         *      let C be the right child of A
         *      let C's right child be the left child of B
         *      let B be right child of C
         * performing a RR rotation of A
         */

        /*Perform RL rotation A (efficient):
         * B = right child of A
         * C = left child of B
         * if A is the root, then let root be C
         * else
         *      find A's parent
         *      if A is left child, let parent's left child be C
         *      else let parent's right child be C
         *
         * let C's left child be A's right child
         * let C's right child be B's left child
         * let A be C's left child
         * let B be C's right child
         * update the height of A, B, C
         */
        AVLTreeNode<E> b = (AVLTreeNode<E>)a.right;
        AVLTreeNode<E> c = (AVLTreeNode<E>)b.left;
        if (a == root) {
            root = c;
            c.parent = null;
        }
        else {
            if (a == parentOfA.left)
                parentOfA.left = c;
            else
                parentOfA.right = c;
            c.parent = parentOfA;
        }

        a.right = c.left;
        c.left.parent = a;
        b.left = c.right;
        c.right.parent = b;
        c.right = b;
        b.parent = c;
        c.left = a;
        a.parent = c;
        updateHeight((AVLTreeNode<E>)a);
        updateHeight(b);
        updateHeight(c);
    }

    protected static class AVLTreeNode<E> extends TreeNode<E> {
        protected int height = 0;
        public AVLTreeNode(E element) {
            super(element);
        }
    }
}
