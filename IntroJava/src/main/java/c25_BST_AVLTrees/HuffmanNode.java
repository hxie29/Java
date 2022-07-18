package c25_BST_AVLTrees;

public class HuffmanNode {
    char element;
    int weight;
    HuffmanNode left;
    HuffmanNode right;
    String code = "";

    public HuffmanNode(){}

    public HuffmanNode(int weight, char element) {
        this.weight = weight;
        this.element = element;
    }
}
