/*(Data compression: Huffman coding animation) Write a program that enables
the user to enter text and displays the Huffman coding tree based on the text, as
shown in Figure 25.21a. Display the weight of the subtree inside the subtree’s
root circle. Display each leaf node’s character. Display the encoded bits for
the text in a label. When the user clicks the Decode Text button, a bit string is
decoded into text displayed in the label, as shown in Figure 25.21b.*/

package c25_BST_AVLTrees;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import java.util.HashMap;

public class HuffmanTreeView extends Pane {
    private String text = "";
    private String code = "";
    private HuffmanTree huffmanTree;
    private HashMap<Character, String> keyMap = new HashMap<>();
    private final double VGAP = 50;
    public HuffmanTreeView() {
        setMinSize(400,400);
    }

    public void displayTree(String text) {
        createTree(text);
        if (huffmanTree.root != null)
            displayTree(huffmanTree.root, getWidth()/2, VGAP, getWidth()/4);
    }

    private void displayTree(HuffmanNode root, double x, double y, double hGap) {
        //Display left subtree
        if (root.left != null) {
            getChildren().add(new Line(x - hGap, y+ VGAP, x, y));
            getChildren().add(new Text(x - hGap/2 - 5, y + VGAP/2 -5, "0"));
            displayTree(root.left, x - hGap, y+ VGAP, hGap/2);
        }

        //Display right subtree
        if (root.right != null) {
            getChildren().add(new Line(x + hGap, y+ VGAP, x, y));
            getChildren().add(new Text(x + hGap/2 + 5, y + VGAP/2 -5, "1"));
            displayTree(root.right, x + hGap, y+ VGAP, hGap/2);
        }

        // Display root
        final double RADIUS = 15;
        Circle c = new Circle(x, y, RADIUS);
        c.setStroke(Color.BLACK);
        c.setFill(Color.WHITE);
        getChildren().addAll(c, new Text(x-4, y+4, root.weight + ""));

        // final leaf to add char at the bottom of circle
        if (root.left == null && root.right == null)
            getChildren().add(new Text(x-2, y + RADIUS + 10, root.element + ""));
    }

    public String decode (String code) {
        StringBuilder bits = new StringBuilder();
        StringBuilder text = new StringBuilder();
        bits.append(code);
        while (bits.length() > 0 ) {
            HuffmanNode current = huffmanTree.root;
            boolean isLeaf = false;
            while(!isLeaf) {
                char bit = bits.charAt(0);
                bits.deleteCharAt(0);
                if (bit == '0')
                    current = current.left;
                else if (bit == '1')
                    current = current.right;

                if (current.left == null && current.right == null) {
                    text.append(current.element);
                    isLeaf = true;
                }
            }
        }
        return text.toString();
    }

    public void createTree(String text) {
        this.text = text;
        int[] counts = HuffmanEncoding.countChar(text);
        huffmanTree = HuffmanEncoding.getHuffmanTree(counts);
        HuffmanEncoding.assignCodes(huffmanTree.root);
        keyMap = HuffmanEncoding.getKeyMap(huffmanTree);
    }

    public String getCodes() {
        if (text.length() > 0) {
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < text.length(); i++) {
                str.append(charToCode(text.charAt(i)));
            }
            code = str.toString();
        }
        return code;
    }

    private String charToCode(char c) {
        return keyMap.get(c);
    }

}
