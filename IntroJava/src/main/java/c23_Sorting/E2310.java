/*(Heap visualization) Write a program that displays a heap graphically, as shown
in Figure 23.10. The program lets you insert and delete an element from the heap. */
package c23_Sorting;

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

public class E2310 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();
        Text text = new Text("Usage: Enter an integer key and click the Insert button to insert the key into the heap.\nClick the Remove the root button to remove the root from the heap.");
        pane.setTop(text);
        int[] list = {1, 2, 3, 4, 5};
        HeapPane heapPane = new HeapPane(list);
        pane.setCenter(heapPane);

        TextField tfInput = new TextField();
        tfInput.setPrefColumnCount(4);
        Label lbInput = new Label("Enter a key:", tfInput);
        lbInput.setContentDisplay(ContentDisplay.RIGHT);
        Button btInsert = new Button("Insert");
        Button btRemove = new Button("Remove");
        HBox controlPanel = new HBox(10);
        controlPanel.getChildren().addAll(lbInput, btInsert,btRemove);
        controlPanel.setAlignment(Pos.CENTER);
        pane.setBottom(controlPanel);

        BorderPane.setAlignment(text, Pos.CENTER);
        BorderPane.setAlignment(controlPanel, Pos.CENTER);
        BorderPane.setAlignment(heapPane, Pos.CENTER);

        btInsert.setOnAction(e -> heapPane.insert(Integer.parseInt(tfInput.getText())));
        btRemove.setOnAction(e -> heapPane.remove(Integer.parseInt(tfInput.getText())));

        Scene scene = new Scene(pane, 500, 250);
        stage.setTitle("Heap visualization");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {Application.launch(args);}
}
