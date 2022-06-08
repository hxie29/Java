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
import javafx.stage.Stage;

public class E15L03 extends Application {
    private CirclePane circlePane = new CirclePane();
    @Override
    public void start(Stage primaryStage) {
        HBox box = new HBox(10);
        box.setAlignment(Pos.CENTER);
        Button enlarge = new Button("Enlarge");
        Button shrink = new Button("Shrink");
        box.getChildren().addAll(enlarge, shrink);

        enlarge.setOnAction(new EnlargeHandler());
        shrink.setOnAction(new ShrinkHandler());
        
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        pane.setCenter(circlePane);
        pane.setBottom(box);
        BorderPane.setAlignment(box, Pos.CENTER);

        
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Control circle demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args ){
        launch(args);
    }

    class EnlargeHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            circlePane.enlarge();
        }
    }
    class ShrinkHandler implements EventHandler<ActionEvent> {
        @Override
        public void handle(ActionEvent e) {
            circlePane.shrink();
        }
    }
      
}