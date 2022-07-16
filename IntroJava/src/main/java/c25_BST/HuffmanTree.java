package c25_BST;

public class HuffmanTree implements Comparable<HuffmanTree>{
    HuffmanNode root;

    // create node from a single character, as leaf at the bottom
    public HuffmanTree(int weight, char element){
        root = new HuffmanNode();
        root.weight = weight;
        root.element = element;
    }
    // create a tree by combining two trees
    public HuffmanTree(HuffmanTree t1, HuffmanTree t2) {
        root = new HuffmanNode();
        root.weight = t1.root.weight + t2.root.weight;
        root.left = t1.root;
        root.right = t2.root;
    }

    @Override
    public int compareTo(HuffmanTree o) {

        return root.weight - o.root.weight;
    }
}
