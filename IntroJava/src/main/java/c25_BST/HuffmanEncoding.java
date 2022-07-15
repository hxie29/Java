package c25_BST;

import c23_Sorting.MinHeap;

import java.util.Scanner;

public class HuffmanEncoding {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a text: ");
        String text = input.nextLine();
        input.close();

        // Count the frequency
        int[] counts = new int[256]; //256 ASCII characters
        for (int i = 0; i < text.length(); i++) {
            counts[text.charAt(i)]++;
        }

        // Create Huffman tree from frequency and characters
        MinHeap<HuffmanTree> treeMinHeap = new MinHeap<>();
        // create a root for each character that has frequency > 0
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0)
                treeMinHeap.add(new HuffmanTree(counts[i], (char)i));
        }
        // combine subtrees into one tree
        while (treeMinHeap.getSize() > 1) {
            HuffmanTree newTree = new HuffmanTree(treeMinHeap.remove(), treeMinHeap.remove());
            treeMinHeap.add(newTree);
        }
        //pop out the final huffman tree
        HuffmanTree huffmanTree = treeMinHeap.remove();

        // now assign codes to the tree leaves
        String[] codes = new String[256];
        assignCodes(huffmanTree.root, codes);

        System.out.printf("%-15s%-15s%-15s%-15s\n", "ASCII Code", "Character", "Frequency", "Code");
        for (int i = 0; i < codes.length; i++) {
            if (counts[i] > 0){
                System.out.printf("%-15d%-15s%-15d%-15s\n", i, (char)i, counts[i], codes[i]);
            }
        }
    }

    private static void assignCodes(NodeHuffman root, String[] codes) {
        if (root.left != null) {
            root.left.code = root.code + "0";
            assignCodes(root.left, codes);
            root.right.code = root.code + "1";
            assignCodes(root.right, codes);
        }
        else codes[root.element] = root.code;
    }
}
