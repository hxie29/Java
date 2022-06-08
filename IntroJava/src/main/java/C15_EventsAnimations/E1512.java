/* 
(Geometry: inside a circle?) Write a program that draws a fixed circle centered
at (100, 60) with radius 50. Whenever the mouse is moved, display a message
indicating whether the mouse point is inside the circle at the mouse point or
outside of it, as shown in Figure 15.29a.
 */
package chap15;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;

public class E1512 extends Application {
    @Override
    public void start(Stage primaryStage) {

        Pane pane = new Pane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        Circle r = new Circle(500,500,500);
        r.setFill(Color.WHITE);
        r.setStroke(Color.BLACK);
        Text text = new Text();
        text.setFill(Color.BLACK);
        pane.getChildren().addAll(r,text);
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Show if mouse if in the circle");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.setOnMouseMoved(e -> {
            text.setX(e.getX());
            text.setY(e.getY());
            text.setText("Mouse point is" + ((r.contains(e.getX(), e.getY())) ? " inside the circle" : " outside the circle"));
        });
        
        
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}
