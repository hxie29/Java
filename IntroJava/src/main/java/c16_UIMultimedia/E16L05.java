package c16_UIMultimedia;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;

public class E16L05 extends E16L04 {

    @Override
    protected BorderPane getPane() {
        BorderPane pane = super.getPane();

        BorderPane paneTextfiled = new BorderPane();
        paneTextfiled.setPadding(new Insets(5,5,5,5));
        pane.setStyle("-fx-border-color: green");
        paneTextfiled.setLeft(new Label("Enter a new message:  "));

        TextField tf = new TextField();
        tf.setAlignment(Pos.BOTTOM_RIGHT);
        paneTextfiled.setCenter(tf);

        pane.setTop(paneTextfiled);

        tf.setOnAction(e -> text.setText(tf.getText()));
       
        return pane;
    }
    //Start method is inherited

    public static void main(String[] args ){
        launch(args);
    }
    
}