/* 
(Draw lines using the arrow keys) Write a program that draws line segments
using the arrow keys. The line starts from (100, 100) in the pane and draws
toward east, north, west, or south when the right-arrow key, up-arrow key, leftarrow
key, or down-arrow key is pressed, as shown in Figure 15.28b.
 */
package chap15;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;


public class E1509 extends Application {
    
    @Override
    public void start(Stage primaryStage) { 
        double[] location = {100,100};
        Pane pane = new Pane();

        Scene scene = new Scene(pane, 500,500);
        primaryStage.setTitle("Mouse position");
        primaryStage.setScene(scene);
        primaryStage.show();

        // scene does not required requestFocus
        scene.setOnKeyPressed(e -> draw(location, pane,e));
    }

    public static void main(String[] args ){
        launch(args);
    }  

    public void draw (double[] location, Pane pane, KeyEvent e) {
        double dx = 0, dy = 0;
        if (e.getCode() == KeyCode.UP) dy = -100;
        else if (e.getCode() == KeyCode.DOWN) dy = 100;
        else if (e.getCode() == KeyCode.LEFT) dx = -100;
        else if (e.getCode() == KeyCode.RIGHT) dx = 100;
        Line l = new Line (location[0], location[1], location[0] + dx, location[1] + dy);
        l.setStroke(Color.BLACK);
        l.setStrokeWidth(2);
        pane.getChildren().add(l);
        location[0] = l.getEndX();
        location[1] = l.getEndY();
    }
}
