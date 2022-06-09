package c15_EventsAnimations;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;

public class E15L02 extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        
        Circle circle = new Circle(50);
        circle.setStroke(Color.BLACK);
        circle.setFill(Color.WHITE);
        pane.setCenter(circle);
        
        HBox box = new HBox(10);
        box.setAlignment(Pos.CENTER);
        Button enlarge = new Button("Enlarge");
        Button shrink = new Button("Shrink");
        box.getChildren().addAll(enlarge, shrink);
        pane.setBottom(box);
        BorderPane.setAlignment(box, Pos.CENTER);
        
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Control Circle without event");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
