/* 
(Move a circle using keys) Write a program that moves a circle up, down, left,
or right using the arrow keys.
 */
package chap15;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;

public class E1511 extends Application {
    @Override
    public void start(Stage primaryStage) {

        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        Circle r = new Circle(50,50,50);
        pane.setCenter(new Pane(r));
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Move circle");
        primaryStage.setScene(scene);
        primaryStage.show();
        
        scene.setOnKeyPressed(e -> {
            if (e.getCode() == KeyCode.UP) 
                r.setCenterY(r.getCenterY() > r.getRadius() / 2 - 5 ? r.getCenterY() - 5 : r.getCenterY());
            else if (e.getCode() == KeyCode.DOWN) 
                r.setCenterY(r.getCenterY() < pane.getHeight() - r.getRadius() / 2 - 5 ? r.getCenterY()+ 5 : r.getCenterY());
            else if (e.getCode() == KeyCode.LEFT) 
                r.setCenterX(r.getCenterX() > 5 + r.getRadius() / 2 ? r.getCenterX() - 5 : r.getRadius() / 2);
            else if (e.getCode() == KeyCode.RIGHT) 
                r.setCenterX(r.getCenterX() < pane.getWidth() - 5 - r.getRadius() / 2 ? r.getCenterX() + 5 : pane.getWidth() - r.getRadius() / 2);
        });
      
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}
