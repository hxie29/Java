/* 
(Rotate a Ellipse) Write a program that rotates a Ellipse when the Rotate
button is clicked, as shown in Figure 15.26b.
 */
package chap15;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;


public class E1502 extends Application {
    
    @Override
    public void start(Stage primaryStage) { 
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10,10,10,10));
        Ellipse ellipse = new Ellipse();
        ellipse.setRadiusX(200);
        ellipse.setRadiusY(100);
        ellipse.setStroke(Color.BLACK);
        ellipse.setFill(Color.WHITE);
        pane.setCenter(ellipse);

        Button rotate = new Button("Rotate");
        pane.setBottom(rotate);
        BorderPane.setAlignment(rotate, Pos.CENTER);

        rotate.setOnAction(e -> ellipse.setRotate(ellipse.getRotate() + 5));

        Scene scene = new Scene(pane, 500,500);
        primaryStage.setTitle("Rotating ellipse");
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    public static void main(String[] args ){
        launch(args);
    }  
}
