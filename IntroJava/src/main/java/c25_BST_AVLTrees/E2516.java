/*(Data compression: Huffman coding) Write a program that prompts the user to
enter a file name, then displays the frequency table of the characters in the file
and the Huffman code for each character.*/
package c25_BST_AVLTrees;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class E2516 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter a file name: ");
        String fileName = input.next();
        input.close();

        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("File does not exist.");
            System.exit(1);
        }
        int[] counts = countChar(file);
        HuffmanTree huffmanTree = HuffmanEncoding.getHuffmanTree(counts);
        String[] codes = HuffmanEncoding.assignCodes(huffmanTree.root);
        HuffmanEncoding.printHuffmanCode(codes, counts);
    }

    public static int[] countChar(File file) {
        int[] counts = new int[256];
        try (Scanner input = new Scanner(file)) {
            while (input.hasNext()) {
                String text = input.next();
                for (int i = 0; i < text.length(); i++) {
                    counts[text.charAt(i)]++;
                }
            }
        }
        catch (IOException ex){
            ex.printStackTrace();
        }
        return counts;
    }
}
