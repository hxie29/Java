package chap15;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class E15L05 extends Application {
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
        Text text = new Text("Programming is fun");
        pane.setCenter(new Pane(text));
        pane.setBottom(box);
        BorderPane.setAlignment(box, Pos.CENTER);
        
        up.setOnAction((ActionEvent e) -> {
                text.setY(text.getY() > 10 ? text.getY() - 5 : 10);
            } );

        down.setOnAction((e) -> {
                text.setY(text.getY() < pane.getHeight() ? text.getY()+ 5 : 0);
            });
        
        left.setOnAction(e -> {
                text.setX(text.getX() > 5 ? text.getX() - 5 : 0);
            });

        right.setOnAction(e -> 
                text.setX(text.getX() < pane.getWidth() - 10 ? text.getX() + 5 : pane.getWidth() - 10) // no ; needed in the end
            );
        
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Lambda Handler demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}
