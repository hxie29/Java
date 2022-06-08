/*
(Move a rectangle using mouse) Write a program that displays a rectangle.
You can point the mouse inside the rectangle and drag (i.e., move with mouse
pressed) the rectangle wherever the mouse goes. The mouse point becomes the
center of the rectangle. 
 */
package chap15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class E1518 extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        double width = 200;
        double height = 100;
        Rectangle r = new Rectangle(20,20,width,height);
        r.setStroke(Color.BLACK);
        r.setFill(Color.TRANSPARENT);
        pane.getChildren().add(r);
        r.setOnMouseDragged( e -> {
            r.setX(e.getX() - width / 2);
            r.setY(e.getY() - height / 2);
        });
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Drag a rectangle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}
