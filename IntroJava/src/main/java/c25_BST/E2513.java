//BST animation
package c25_BST;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import java.util.Iterator;

public class E2513 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BST<Integer> tree = new BST<>();
        BorderPane pane = new BorderPane();
        BTView view = new BTView(tree);

        TextField tfValue = new TextField();
        tfValue.setPrefColumnCount(5);
        tfValue.setAlignment(Pos.BASELINE_RIGHT);
        Label lbValue = new Label("Enter a key: ", tfValue);
        lbValue.setContentDisplay(ContentDisplay.RIGHT);
        Button btInsert = new Button("Insert");
        Button btDelete = new Button("Delete");
        Button btInorder = new Button("Show Inorder");
        Button btPreorder = new Button("Show Preorder");
        Button btPostorder = new Button("Show Postorder");
        HBox controlPanel = new HBox(10);
        controlPanel.setAlignment(Pos.CENTER);
        controlPanel.getChildren().addAll(lbValue, btInsert, btDelete, btInorder, btPreorder, btPostorder);

        Text tShowOrder = new Text(" ");
        pane.setTop(tShowOrder);
        pane.setBottom(controlPanel);
        pane.setCenter(view);
        BorderPane.setAlignment(tShowOrder, Pos.CENTER);
        BorderPane.setAlignment(controlPanel, Pos.CENTER);
        BorderPane.setAlignment(view, Pos.CENTER);

        btInsert.setOnAction(e -> {
            int key = Integer.parseInt(tfValue.getText());
            if (tree.search(key)) {
                view.setStatus(key + " is already in the tree");
            }
            else {
                tree.insert(key);
                view.displayTree();
                view.setStatus(key + " is inserted in the tree");
            }
        });

        btDelete.setOnAction(e -> {
            int key = Integer.parseInt(tfValue.getText());
            if (!tree.search(key)) {
                view.setStatus(key + " is not in the tree");
            }
            else {
                tree.delete(key);
                view.displayTree();
                view.setStatus(key + " is deleted from the tree");
            }
        });

        btInorder.setOnAction(e -> {
            Iterator<Integer> iterator = tree.inorderIterator();
            tShowOrder.setText("Inorder: " + iterator);
        });

        btPreorder.setOnAction(e -> {
            Iterator<Integer> iterator = tree.preorderIterator();
            tShowOrder.setText("Preorder: " + iterator);
        });

        btPostorder.setOnAction(e -> {
            Iterator<Integer> iterator = tree.postorderIterator();
            tShowOrder.setText("Postorder: " + iterator);
        });

        Scene scene = new Scene(pane, 450, 250);
        stage.setTitle("Binary tree visualization");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){Application.launch(args);}
}
