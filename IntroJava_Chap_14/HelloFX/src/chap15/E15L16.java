package chap15;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import chap14.ClockPane;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.util.Duration;

public class E15L16 extends Application {
    @Override
    public void start(Stage primaryStage) {   
        ClockPane clock = new ClockPane();

        EventHandler<ActionEvent> event = e -> {
            clock.setCurrentTiime();
        };

        Timeline animation = new Timeline (new KeyFrame(Duration.millis(1000), event));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
        
        Scene scene = new Scene(clock, 500,500);
        primaryStage.setTitle("Ticking Clock");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args ){
        launch(args);
    }  
}
