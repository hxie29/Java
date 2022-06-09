/* 
(Change color using a mouse) Write a program that displays the color of a circle
as red when the mouse button is pressed and as blue when the mouse button
is released.
 */
package c15_EventsAnimations;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;


public class E1507 extends Application {
    
    @Override
    public void start(Stage primaryStage) { 
        Circle c = new Circle(100);
        Color[] colors = {Color.RED, Color.BLUE};
        c.setFill(colors[0]);
       
        BorderPane pane = new BorderPane();
        pane.setCenter(c);

        Scene scene = new Scene(pane, 500,500);
        primaryStage.setTitle("Change circle colors");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.setOnMouseClicked(e -> change(c, colors));
    }

    public static void main(String[] args ){
        launch(args);
    }  

    public void change(Circle c, Color[] colors) {
        if (c.getFill().equals(colors[0])) c.setFill(colors[1]);
        else c.setFill(colors[0]);
    }
}
