package c15_EventsAnimations;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class E15L07 extends Application {
    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Text text = new Text("Programmiing is fun");
        pane.getChildren().add(text);
        text.setOnMouseDragged( e -> {
            text.setX(e.getX());
            text.setY(e.getY());
        });
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Mouse Event demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}
