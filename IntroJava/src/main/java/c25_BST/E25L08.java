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
import javafx.stage.Stage;

public class E25L08 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();
        BST<Integer> tree = new BST<>();
        BTView view = new BTView(tree);

        TextField tfValue = new TextField();
        tfValue.setPrefColumnCount(5);
        tfValue.setAlignment(Pos.BASELINE_RIGHT);
        Label lbValue = new Label("Enter a key: ", tfValue);
        lbValue.setContentDisplay(ContentDisplay.RIGHT);
        Button btInsert = new Button("Insert");
        Button btDelete = new Button("Delete");
        HBox controlPanel = new HBox(10);
        controlPanel.setAlignment(Pos.CENTER);
        controlPanel.getChildren().addAll(lbValue, btInsert, btDelete);

        pane.setBottom(controlPanel);
        pane.setCenter(view);
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

        Scene scene = new Scene(pane, 450, 250);
        stage.setTitle("Binary tree visualization");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args){Application.launch(args);}
}
