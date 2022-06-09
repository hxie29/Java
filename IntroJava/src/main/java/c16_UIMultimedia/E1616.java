/* 
(Select a font) Write a program that can dynamically change the font of a text in
a label displayed on a stack pane. The text can be displayed in bold and italic at
the same time. You can select the font name or font size from combo boxes, as
shown in Figure 16.42a. The available font names can be obtained using Font
.getFontNames(). The combo box for the font size is initialized with numbers
from 1 to 100.
 */
package c16_UIMultimedia;

import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ContentDisplay;

public class E1616 extends Application {
    private final ComboBox<String> cbSelectionMode = new ComboBox<>();
    private final ListView<String> list = new ListView<>();
    private final Text text = new Text("Selected items:");

    @Override
    public void start(Stage primaryStage) {
        cbSelectionMode.getItems().addAll("Multiple", "Single");
        cbSelectionMode.setValue("Multiple");

        list.getItems().addAll("China", "Japn", "Korea", "India", "Malaysia", "Vietnam");
        list.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);
        Label lblDisplay = new Label("Choose Selection Mode:", cbSelectionMode);
        lblDisplay.setContentDisplay(ContentDisplay.RIGHT);

        pane.getChildren().addAll(lblDisplay,list,text);

        cbSelectionMode.setOnAction(e -> update());
        list.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> text.setText("Selected items: "+getText()));

        Scene scene = new Scene(pane, 450, 200);
        primaryStage.setTitle("ListView demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void update() {
        String direction = cbSelectionMode.getSelectionModel().getSelectedItem();
        list.getSelectionModel().setSelectionMode((direction.equals("Multiple")? SelectionMode.MULTIPLE : SelectionMode.SINGLE));
    }

    private String getText() {
        StringBuilder selection = new StringBuilder();
        ObservableList<String> list2 = list.getSelectionModel().getSelectedItems();
        for (String s : list2) {
            selection.append(s).append("; ");
        }
        return selection.toString();
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}