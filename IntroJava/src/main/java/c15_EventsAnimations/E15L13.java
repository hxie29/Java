package c15_EventsAnimations;

import javafx.animation.PathTransition;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class E15L13 extends Application {

    @Override
    public void start(Stage primaryStage) {
        ImageView flag = new ImageView (new Image("http://s3.amazonaws.com/pix.iemoji.com/images/emoji/apple/ios-12/256/rainbow-flag.png"));

        Pane pane = new Pane();
        pane.getChildren().add(flag);

        //Create path transition 
        PathTransition path = new PathTransition(Duration.millis(4000), 
                                                new Line(100,200,100,0), flag);
        path.setAutoReverse(false);                                                
        path.setCycleCount(5);
        path.play();

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Rising flag");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.setOnMousePressed(e -> path.pause());
        scene.setOnMouseReleased(e -> path.play());
    }

    
    public static void main(String[] args ){
        launch(args);
    }
}