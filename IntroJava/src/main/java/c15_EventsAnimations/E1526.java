/* 
(Change opacity) Rewrite Programming Exercise 15.24 so the ball’s opacity is
changed as it swings.
 */
package c15_EventsAnimations;

import javafx.animation.FadeTransition;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.animation.PathTransition.OrientationType;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class E1526 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Arc arc = new Arc(600,200,200,100,210,120);
        arc.setStroke(Color.BLUE);
        arc.setType(ArcType.OPEN);
        arc.setFill(Color.TRANSPARENT);
        Circle c = new Circle(10);
        c.setFill(Color.RED);

        pane.getChildren().addAll(arc,c);

        //Create path transition 
        PathTransition path = new PathTransition();
        path.setDuration(Duration.millis(4000));
        path.setPath(arc);
        path.setNode(c);
        path.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
        path.setCycleCount(Timeline.INDEFINITE);
        path.setAutoReverse(true);
        path.play();

        FadeTransition fade = new FadeTransition();
        fade.setDuration(path.getDuration().multiply(0.5));
        fade.setNode(c);
        fade.setFromValue(1);
        fade.setToValue(0.1);
        fade.setCycleCount(Timeline.INDEFINITE);
        fade.setAutoReverse(true);
        fade.play();

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Pendulum");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.setOnMousePressed(e -> path.pause());
        scene.setOnMouseReleased(e -> path.play());
    }

    
    public static void main(String[] args ){
        launch(args);
    }
}