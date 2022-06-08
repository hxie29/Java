/* 
(Change opacity) Rewrite Programming Exercise 15.24 so the ball’s opacity is
changed as it swings.
 */
package chap15;


import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.animation.PathTransition.OrientationType;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.shape.Line;
//import javafx.scene.shape.Circle;

public class E1527 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Text t = new Text("Welcome to Java");
        t.setFill(Color.BLUE);

        /* Circle c = new Circle(50);
        c.setFill(Color.TRANSPARENT); */

        Line line = new Line(0,100,300,100);
        line.setStroke(Color.TRANSPARENT);
        
        pane.getChildren().addAll(line,t);
        //line.endXProperty().bind(pane.widthProperty());
        
        //Create path transition 
        PathTransition path = new PathTransition();
        path.setDuration(Duration.millis(4000));
        path.setPath(line);
        path.setNode(t);
        path.setOrientation(OrientationType.NONE);
        path.setCycleCount(Timeline.INDEFINITE);
        path.setAutoReverse(false);
        path.play();

       /*  PathTransition path2 = new PathTransition();
        path2.setDuration(path.getDuration().divide(3));
        path2.setPath(c);
        path2.setNode(t);
        path2.setOrientation(OrientationType.NONE);
        path2.setCycleCount(Timeline.INDEFINITE);
        path2.setAutoReverse(false);
        path2.play(); */

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Moving text");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.setOnMousePressed(e -> {
            path.pause();
           /*  path2.pause(); */
        });
        scene.setOnMouseReleased(e -> {
            path.play();
            /* path2.play(); */
        });
    }

    
    public static void main(String[] args ){
        launch(args);
    }
}