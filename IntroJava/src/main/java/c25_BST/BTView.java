package c25_BST;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class BTView extends Pane {
    private final BST<Integer> tree;
    private final double VGAP = 50;
    private final Text status = new Text(20,20,"");
    public BTView(BST<Integer> tree) {
        this.tree = tree;
        getChildren().add(status);
        displayTree();
    }

    public void setStatus(String msg) {
        status.setText(msg);
    }

    public void displayTree() {
        getChildren().retainAll(status);
        if (tree.getRoot() != null)
            displayTree(tree.getRoot(), getWidth()/2, VGAP, getWidth()/4);
    }

    private void displayTree(TreeNode<Integer> root, double x, double y, double hGap) {
        //Display left subtree
        if (root.left != null) {
            getChildren().add(new Line(x - hGap, y+ VGAP, x, y));
            displayTree(root.left, x - hGap, y+ VGAP, hGap/2);
        }

        //Display right subtree
        if (root.right != null) {
            getChildren().add(new Line(x + hGap, y+ VGAP, x, y));
            displayTree(root.right, x + hGap, y+ VGAP, hGap/2);
        }

        // Display root
        final double RADIUS = 15;
        Circle c = new Circle(x, y, RADIUS);
        c.setStroke(Color.BLACK);
        c.setFill(Color.WHITE);
        getChildren().addAll(c, new Text(x-4, y+4, root.element + ""));
    }

}
