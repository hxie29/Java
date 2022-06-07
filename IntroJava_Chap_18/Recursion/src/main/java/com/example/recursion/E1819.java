/*(Sierpinski triangle) Revise Listing 18.9 to develop a program that lets
the user use the +/- buttons, primary/secondary mouse buttons, and UP/
DOWN arrow keys to increase or decrease the current order by 1, as shown
in Figure 18.12a. The initial order is 0. If the current order is 0, the Decrease
button is ignored.*/
package com.example.recursion;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class E1819 extends Application {
    @Override
    public void start (Stage primaryStage) {
        BorderPane pane = new BorderPane();
        SierpinskiTrianglePane trianglePane = new SierpinskiTrianglePane(2);
        pane.setCenter(trianglePane);
        BorderPane.setAlignment(trianglePane, Pos.CENTER);

        HBox controlPanel = new HBox(10);
        controlPanel.setAlignment(Pos.CENTER);
        Button btSmaller = new Button("-");
        Button btBigger = new Button("+");
        controlPanel.getChildren().addAll(btSmaller, btBigger);
        pane.setBottom(controlPanel);
        BorderPane.setAlignment(controlPanel, Pos.CENTER);

        btSmaller.setOnAction(e -> trianglePane.decreaseOrder());
        btBigger.setOnAction(e -> trianglePane.increaseOrder());
        pane.widthProperty().addListener(ov -> trianglePane.paint());
        pane.heightProperty().addListener(ov -> trianglePane.paint());

        Scene scene = new Scene(pane, 400,500);
        primaryStage.setTitle("Sierpinski Triangle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
