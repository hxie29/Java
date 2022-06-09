package c15_EventsAnimations;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.FadeTransition;
import javafx.animation.Timeline;

public class E15L14 extends Application {

    @Override
    public void start(Stage primaryStage) {
        ImageView flag = new ImageView (new Image("http://s3.amazonaws.com/pix.iemoji.com/images/emoji/apple/ios-12/256/rainbow-flag.png"));

        Pane pane = new Pane();
        pane.getChildren().add(flag);

        //Create fade transition 
        FadeTransition fade = new FadeTransition(Duration.millis(4000), flag);
        fade.setFromValue(1);
        fade.setToValue(0.1);
        fade.setAutoReverse(true);                                                
        fade.setCycleCount(Timeline.INDEFINITE);
        fade.play();

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Fade transition");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.setOnMousePressed(e -> fade.pause());
        scene.setOnMouseReleased(e -> fade.play());
    }

    
    public static void main(String[] args ){
        launch(args);
    }
}