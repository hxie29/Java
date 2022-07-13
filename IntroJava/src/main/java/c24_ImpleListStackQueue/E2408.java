/*(Animation: array list) Write a program to animate search, insertion, and deletion
in an array list, as shown in Figure 24.1a. The Search button searches the specified
value in the list. The Delete button deletes the specified value from the list.
The Insert button appends the value into the list if the index is not specified;
otherwise, it inserts the value into the specified index in the list.*/
package c24_ImpleListStackQueue;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class E2408 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);
        ArrayListPane arrayPane = new ArrayListPane();
        arrayPane.setStyle("-fx-border-color: black");
        Text text = new Text("This is animation for array list.");

        TextField tfValue = new TextField();
        TextField tfIndex = new TextField();
        tfValue.setPrefColumnCount(5);
        tfIndex.setPrefColumnCount(5);
        Label lbValue = new Label("Enter a value: ", tfValue);
        Label lbIndex = new Label("Enter an index: ", tfIndex);
        lbValue.setContentDisplay(ContentDisplay.RIGHT);
        lbIndex.setContentDisplay(ContentDisplay.RIGHT);

        Button btSearch = new Button("Search");
        Button btInsert = new Button("Insert");
        Button btDelete = new Button("Delete");
        Button btTrim = new Button("Trim to size");

        HBox controlPanel = new HBox(10);
        controlPanel.setAlignment(Pos.CENTER);
        controlPanel.getChildren().addAll(lbValue, lbIndex, btSearch, btInsert, btDelete, btTrim);

        pane.getChildren().addAll(text, arrayPane, controlPanel);

        btSearch.setOnAction(e -> {
            if (tfValue.getText() != null)
                tfIndex.setText(arrayPane.search(Integer.parseInt(tfValue.getText())) + "");
        });
        btInsert.setOnAction(e -> {
            if (isDigit(tfIndex.getText()) && isDigit(tfValue.getText()))
                arrayPane.insert(Integer.parseInt(tfIndex.getText()), Integer.parseInt(tfValue.getText()));
            else if (isDigit(tfValue.getText()))
                arrayPane.insert(Integer.parseInt(tfValue.getText()));
        });
        btDelete.setOnAction(e -> {
            if (isDigit(tfIndex.getText()))
                arrayPane.delete(Integer.parseInt(tfIndex.getText()));
        });
        btTrim.setOnAction(e -> arrayPane.trim());

        Scene scene = new Scene(pane);
        stage.setTitle("Array list visualization");
        stage.setScene(scene);
        stage.show();
    }

    private static boolean isDigit(String s) {
        if (s.length() == 0)
            return false;
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isDigit(s.charAt(i)))
                return false;
        }
        return true;
    }

    public static void main(String[] args){Application.launch(args);}
}
