package chap15;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.animation.PathTransition.OrientationType;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

public class E15L12 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();

        Rectangle r = new Rectangle(0,0, 25, 50);
        r.setFill(Color.BLUE);
        Circle c = new Circle(125,100,50);
        c.setFill(Color.WHITE);
        c.setStroke(Color.RED);

        pane.getChildren().addAll(c, r);

        //Create path transition 
        PathTransition path = new PathTransition();
        path.setDuration(Duration.millis(4000));
        path.setPath(c);
        path.setNode(r);
        path.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
        path.setCycleCount(Timeline.INDEFINITE);
        path.setAutoReverse(true);
        path.play();

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Path Transition Demo");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.setOnMousePressed(e -> path.pause());
        scene.setOnMouseReleased(e -> path.play());
    }

    
    public static void main(String[] args ){
        launch(args);
    }
}