package chap15;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class E15L04 extends Application {
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
        
        up.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent e) {
                text.setY(text.getY() > 10 ? text.getY() - 5 : 10);
            }
        });

        down.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent e) {
                text.setY(text.getY() < pane.getHeight() ? text.getY()+ 5 : 0);
            }
        });
        
        left.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent e) {
                text.setX(text.getX() > 5 ? text.getX() - 5 : 0);
            }
        });

        right.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle (ActionEvent e) {
                text.setX(text.getX() < pane.getWidth() - 10 ? text.getX() + 5 : pane.getWidth() - 10);
            }
        });
        
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Anonymous handler demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}
