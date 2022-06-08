// (Sierpinski triangle) Write a program that lets the user to enter the order and
//display the filled Sierpinski triangles as shown in Figure 18.18.
package com.example.recursion;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class E18L36 extends Application {
    @Override
    public void start (Stage primaryStage) {
        BorderPane pane = new BorderPane();
        ScierpinskiTriangleColorPane trianglePane = new ScierpinskiTriangleColorPane(Color.BLACK);

        TextField tf = new TextField();
        tf.setPrefColumnCount(4);
        Label lbInput = new Label("Enter an order: ", tf);
        lbInput.setContentDisplay(ContentDisplay.RIGHT);

        pane.setCenter(trianglePane);
        pane.setBottom(lbInput);
        BorderPane.setAlignment(lbInput, Pos.CENTER);
        BorderPane.setAlignment(trianglePane, Pos.CENTER);

        tf.setOnAction(e -> trianglePane.setOrder(Integer.parseInt(tf.getText())));
        pane.widthProperty().addListener(ov -> trianglePane.paint());
        pane.heightProperty().addListener(ov -> trianglePane.paint());

        Scene scene = new Scene(pane, 200,210);
        primaryStage.setTitle("Sierpinski Triangle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
