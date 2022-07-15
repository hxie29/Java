package c25_BST;

public class NodeHuffman {
    char element;
    int weight;
    NodeHuffman left;
    NodeHuffman right;
    String code = "";

    public NodeHuffman(){}

    public NodeHuffman(int weight, char element) {
        this.weight = weight;
        this.element = element;
    }
}
