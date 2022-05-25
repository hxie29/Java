package chap15;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;

public class E15L15 extends Application {
    @Override
    public void start(Stage primaryStage) {   
        BorderPane pane = new BorderPane();
        pane.setPadding(new Insets(10, 10, 10, 10));
        Text text = new Text(200,200,"Programming is fun");
        text.setFont(new Font(60));
        text.setStroke(Color.AQUA);
        pane.setCenter(new Pane(text));

        //Create a handler for changing text --> this is not working if wrong eventhandler class is imported
        EventHandler<ActionEvent> handler = e -> {
            if (text.getText().length() != 0) text.setText("");
            else text.setText("Programming is fun");
        };

        //Create a timeline animation for alternating text
        Timeline a = new Timeline(new KeyFrame(Duration.millis(500), handler));
        a.setCycleCount(Timeline.INDEFINITE);
        a.play();

        text.setOnMouseClicked(e -> {
            if (a.getStatus() == Animation.Status.PAUSED) a.play();
            else a.pause();
        });
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Timeline demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args ){
        launch(args);
    }  
}
