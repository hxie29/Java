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
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.text.Text;

public class E1519 extends Application {
    private int count = 0;
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Circle c = new Circle(100,200,10);
        c.setFill(new Color(Math.random(), Math.random(), Math.random(), 1));
        pane.getChildren().add(c);
        long startTime = System.currentTimeMillis();
        
        pane.setOnMouseClicked(e -> {
            if (c.contains(e.getX(), e.getY())) {
                count++; 
                if (count < 20) {
                    c.setCenterX(pane.getWidth() * Math.random()* 0.95);
                    c.setCenterY(pane.getHeight() * Math.random() * 0.95);
                    c.setFill(new Color(Math.random(), Math.random(), Math.random(), 1));
                }
                else {
                    long endTime = System.currentTimeMillis();
                    double duration = endTime - startTime;
                    pane.getChildren().remove(c);
                    Text text = new Text (100,100, "Time spent is " + duration + " milliseconds.");
                    pane.getChildren().add(text);
                }
            }
        });
        
        Scene scene = new Scene(pane, 800,800);
        primaryStage.setTitle("Drag a rectangle");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}
