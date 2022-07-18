package c25_BST_AVLTrees;

import java.util.*;

public class BST<E extends Comparable<E>> implements Tree<E>, Cloneable{
    protected TreeNode<E> root;
    protected int size = 0;

    public BST(){}

    public BST(E[] objects) {
        for (E e: objects)
            insert(e);
    }

    protected TreeNode<E> createNewNode(E e){
        return new TreeNode<>(e);
    }

    @Override
    public boolean search(E e) {
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0)
                current = current.left;
            else if (e.compareTo(current.element) > 0)
                current = current.right;
            else
                return true;
        }
        return false;
    }

    @Override
    public boolean insert(E e) {
        if (root == null)
            root = createNewNode(e);
        else{
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
                else
                    return false;
            }
            if (e.compareTo(parent.element) < 0) {
                parent.left = new TreeNode<>(e);
                parent.left.parent = parent;
            }
            else {
                parent.right = new TreeNode<>(e);
                parent.right.parent = parent;
            }
        }
        size++;
        return true;
    }

    public int height() {
        return (size == 0) ? -1 : height(root);
    }

    public boolean isPerfectBST() {
        return size == (int)Math.pow(2, height() + 1) -1;
    }

    protected int height(TreeNode<E> root) {
        int leftHeight = 0, rightHeight = 0;
        if (root.left != null)
            leftHeight = height(root.left) + 1;
        if (root.right != null)
            rightHeight = height(root.right) + 1;
        return Math.max(leftHeight, rightHeight);
    }

    // non recursive method of getting number of leaves
    public int getNumberOfLeaves() {
        if (size == 0) return 0;
        else {
            int count = 0;
            Stack<TreeNode<E>> stack = new Stack<>();
            stack.push(root);
            TreeNode<E> node;
            while (!stack.isEmpty()) {
                node = stack.pop();
                if (node.left == null && node.right == null)
                    count++;
                else {
                    if (node.left != null)
                        stack.push(node.left);
                    if (node.right != null)
                        stack.push(node.right);
                }
            }
            return count;
        }
    }
    // recursive method of get number of leaves
    protected int getNumberOfLeaves(TreeNode<E> root) {
        if (root == null) return 0;
        else
            return (root.left == null && root.right == null) ? 1
                    : getNumberOfLeaves(root.left) + getNumberOfLeaves(root.right);
    }

    public int getNumberOfNonLeaves() {
        return size - getNumberOfLeaves();
    }

    @Override
    public void inorder() {
        Iterator<E> iterator = new InOrderIteratorEfficient();
        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");
    }

    public List<E> inorderList() {
        Iterator<E> iterator = new InOrderIteratorEfficient();
        ArrayList<E> list = new ArrayList<>();
        while (iterator.hasNext())
            list.add(iterator.next());
        return list;
    }

    @Override
    public void postorder() {
        Iterator<E> iterator = new PostOrderIteratorEfficient();
        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");
    }

    public List<E> postorderList() {
        Iterator<E> iterator = new PostOrderIteratorEfficient();
        ArrayList<E> list = new ArrayList<>();
        while (iterator.hasNext())
            list.add(iterator.next());
        return list;
    }

    @Override
    public void preorder() {
        Iterator<E> iterator = new PreOrderIteratorEfficient();
        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");
    }

    public List<E> preorderList() {
        Iterator<E> iterator = new PostOrderIteratorEfficient();
        ArrayList<E> list = new ArrayList<>();
        while (iterator.hasNext())
            list.add(iterator.next());
        return list;
    }
    public void breadthFirstTraversal(){
        if (root != null) {
            LinkedList<TreeNode<E>> roots = new LinkedList<>();
            roots.add(root);
            breadthFirstTraversal(roots);
        }
    }

    protected void breadthFirstTraversal(LinkedList<TreeNode<E>> roots){
        while (roots.size() > 0) {
            System.out.print(roots.getFirst().element + " ");
            if (roots.getFirst().left != null)
                roots.add(roots.getFirst().left);
            if (roots.getFirst().right != null)
                roots.add(roots.getFirst().right);
            roots.removeFirst();
        }
    }

    @Override
    public int getSize() {
        return size;
    }

    public TreeNode<E> getRoot() {return root;}

    public ArrayList<TreeNode<E>> path(E e) {
        ArrayList<TreeNode<E>> list = new ArrayList<>();
        TreeNode<E> current = root;
        while (current != null) {
            list.add(current);
            if (e.compareTo(current.element) < 0)
                current = current.left;
            else if (e.compareTo(current.element) > 0)
                current = current.right;
            else
                break;
        }
        return list;
    }

    /** Return the path of elements from the specified element
     * to the root in an array list. */
    public ArrayList<E> getPath(E e) {
        ArrayList<E> list = new ArrayList<>();
        TreeNode<E> current = root;
        while (current != null) {
            list.add(current.element);
            if (e.compareTo(current.element) < 0)
                current = current.left;
            else if (e.compareTo(current.element) > 0)
                current = current.right;
            else
                break;
        }
        return list;
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
        }
        size--;
        return true;
    }
    @Override
    public void clear() {
        root = null;
        size = 0;
    }
    @Override
    public Iterator<E> iterator() {
        return new InorderIterator();
    }
    public Iterator<E> inorderIterator() {
        return new InorderIterator();
    }
    public Iterator<E> preorderIterator() {return new PreorderIterator();}
    public Iterator<E> postorderIterator() {return new PostorderIterator();}
    public Iterator<E> iteratorEfficient() {return new InOrderIteratorEfficient();
    }
    public Iterator<E> preorderIteratorEfficient() {
        return new PreOrderIteratorEfficient();
    }
    public Iterator<E> postrderIteratorEfficient() {
        return new PostOrderIteratorEfficient();
    }
    @Override
    public BST<E> clone() {
        BST<E> tree = new BST<>();
        return clone(tree, root);
    }
    // Recursively adding nodes from sub nodes to main tree
    private BST<E> clone(BST<E> parentTree, TreeNode<E> root) {
        if (root != null){
            parentTree.insert(root.element);
            parentTree =clone(parentTree,root.left);
            parentTree =clone(parentTree,root.right);
        }
        return parentTree;
    }
    public boolean equals(BST<E> tree) {
        if (size == tree.size()) {
            if (root != null)
                return equals(root, tree.getRoot());
            else
                return true;
        }
        return false;
    }
    protected boolean equals(TreeNode<E> root1, TreeNode<E> root2) {
        if (root1 != null && root2 != null) {
            if (root1.element == root2.element)
                return equals(root1.left, root2.left) && equals(root1.right, root2.right);
            return false;
        }
        else return root1 == null && root2 == null;
    }
    /** Return the node for the specified element.
     * Return null if the element is not in the tree. */
    protected TreeNode<E> getNode(E e) {
        TreeNode<E> current = root;
        while (current != null) {
            if (e.compareTo(current.element) < 0)
                current = current.left;
            else if (e.compareTo(current.element) > 0)
                current = current.right;
            else
                return current;
        }
        return null;
    }
    /** Return true if the node for the element is a leaf */
    protected boolean isLeaf(E e) {
        TreeNode<E> node = getNode(e);
        return node != null && node.left == null && node.right == null;
    }
/*Iterator classes */
    private class InorderIterator implements Iterator<E> {
        private final ArrayList<E> list = new ArrayList<>();
        private int current = 0;
        protected InorderIterator() {
            inorder();
        }

        private void inorder(){
            inorder(root);
        }

        private void inorder(TreeNode<E> root) {
            if (root != null) {
                inorder(root.left);
                list.add(root.element);
                inorder(root.right);
            }
        }

        @Override
        public boolean hasNext() {
            return current < list.size();
        }
        @Override
        public E next() {
            return list.get(current++);
        }
        @Override
        public void remove() {
            if (current == 0)
                throw new IllegalStateException();
            delete(list.get(--current));
            list.clear();
            inorder();
        }

        @Override
        public String toString() {
            return list.toString();
        }
    }
    private class InOrderIteratorEfficient implements Iterator<E> {
        private final Stack<E> stack = new Stack<>();
        protected InOrderIteratorEfficient() {
            inorder();
        }

        private void inorder(){
            inorder(root);
        }

        private void inorder(TreeNode<E> root) {
            if (root != null) {
                inorder(root.right);
                stack.push(root.element);
                inorder(root.left);
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }
        @Override
        public E next() {
            return stack.pop();
        }
        @Override
        public void remove() {
            throw new UnsupportedOperationException("Removing an element from the iterator is not supported.");
        }
    }
    private class PreorderIterator implements Iterator<E> {
        private final ArrayList<E> list = new ArrayList<>();
        private int current = 0;
        protected PreorderIterator() {
            preorder();
        }

        private void preorder(){
            preorder(root);
        }

        private void preorder(TreeNode<E> root) {
            if (root != null) {
                list.add(root.element);
                preorder(root.left);
                preorder(root.right);
            }
        }

        @Override
        public boolean hasNext() {
            return current < list.size();
        }
        @Override
        public E next() {
            return list.get(current++);
        }
        @Override
        public void remove() {
            if (current == 0)
                throw new IllegalStateException();
            delete(list.get(--current));
            list.clear();
            preorder();
        }

        @Override
        public String toString() {
            return list.toString();
        }
    }
    private class PreOrderIteratorEfficient implements Iterator<E> {
        private final Stack<E> stack = new Stack<>();
        protected PreOrderIteratorEfficient() {
            preorder();
        }
        private void preorder() {
            preorder(root);
        }

        private void preorder(TreeNode<E> root) {
            if (root != null) {
                preorder(root.right);
                preorder(root.left);
                stack.push(root.element);
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public E next() {
            return stack.pop();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Removing an element from the iterator is not supported.");
        }
    }
    private class PostorderIterator implements Iterator<E> {
        private final ArrayList<E> list = new ArrayList<>();
        private int current = 0;
        protected PostorderIterator() {
            postorder();
        }

        private void postorder(){
            postorder(root);
        }

        private void postorder(TreeNode<E> root) {
            if (root != null) {
                postorder(root.left);
                postorder(root.right);
                list.add(root.element);
            }
        }

        @Override
        public boolean hasNext() {
            return current < list.size();
        }
        @Override
        public E next() {
            return list.get(current++);
        }
        @Override
        public void remove() {
            if (current == 0)
                throw new IllegalStateException();
            delete(list.get(--current));
            list.clear();
            postorder();
        }

        @Override
        public String toString() {
            return list.toString();
        }
    }
    private class PostOrderIteratorEfficient implements Iterator<E> {
        private final Stack<E> stack = new Stack<>();
        protected PostOrderIteratorEfficient() {
            postorder();
        }
        private void postorder() {
            postorder(root);
        }

        private void postorder(TreeNode<E> root) {
            if (root != null) {
                stack.push(root.element);
                postorder(root.right);
                postorder(root.left);
            }
        }

        @Override
        public boolean hasNext() {
            return !stack.isEmpty();
        }

        @Override
        public E next() {
            return stack.pop();
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Removing an element from the iterator is not supported.");
        }
    }
    public static class TreeNode<E> {
        protected E element;
        protected TreeNode<E> left;
        protected TreeNode<E> right;
        protected TreeNode<E> parent;

        public TreeNode(E e) {
            element = e;
        }
    }
}
