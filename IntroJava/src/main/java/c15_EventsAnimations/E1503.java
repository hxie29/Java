/* 
(Move the rectangle) Write a program that moves the rectangle in a pane.
You should define a pane class for displaying the ball and provide the methods
for moving the Rectangle left, right, up, and down, as shown in Figure 15.26c.
Check the boundary to prevent the ball from moving out of sight completely.
 */
package c15_EventsAnimations;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class E1503 extends Application {
    @Override
    public void start(Stage primaryStage) {
        HBox box = new HBox(20);
        box.setAlignment(Pos.CENTER);
        Button up = new Button("up");
        Button down = new Button("down");
        Button left = new Button("left");
        Button right = new Button("right");
        box.getChildren().addAll(up, down, left, right);

        
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        Rectangle r = new Rectangle(50, 50);
        pane.setCenter(new Pane(r));
        pane.setBottom(box);
        BorderPane.setAlignment(box, Pos.CENTER);
        
        up.setOnAction(e -> r.setY(r.getY() > r.getHeight() / 2 - 5 ? r.getY() - 5 : r.getY()));

        down.setOnAction(e -> r.setY(r.getY() < pane.getHeight() - r.getHeight() / 2 - 5 ? r.getY()+ 5 : r.getY()));
        
        left.setOnAction(e -> r.setX(r.getX() > 5 + r.getWidth() / 2 ? r.getX() - 5 : r.getWidth() / 2));

        right.setOnAction(e -> r.setX(r.getX() < pane.getWidth() - 5 - r.getWidth() / 2 ? r.getX() + 5 : pane.getWidth() - r.getWidth() / 2));
        
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Move box");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}
