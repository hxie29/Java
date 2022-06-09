/* 
(Geometry: pendulum) Write a program that animates a pendulum swinging,
as shown in Figure 15.37. Press the up arrow key to increase the speed, and the
down arrow key to decrease it. Press the S key to stop animation of and the R
key to resume it.
 */
package c15_EventsAnimations;

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
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;

public class E1531 extends Application {

    @Override
    public void start(Stage primaryStage) {
        Pane pane = new Pane();
        Arc arc = new Arc(600,200,200,100,210,120);
        arc.setStroke(Color.TRANSPARENT);
        arc.setType(ArcType.OPEN);
        arc.setFill(Color.TRANSPARENT);
        Circle hook = new Circle(arc.getCenterX(),50,5);
        hook.setFill(Color.BLACK);
        Line rope = new Line(hook.getCenterX(), hook.getCenterY(), 0, 0);
        rope.setStroke(Color.BLACK);
        rope.setStrokeWidth(2);
        Circle c = new Circle(10);
        c.setFill(Color.RED);
        /* 
        public final DoubleProperty translateXProperty() Defines the x coordinate of the translation that is added to this Node's transform.
        The node's final translation will be computed as layoutX + translateX, where layoutX establishes the node's stable position and translateX optionally makes dynamic adjustments to that position.
        This variable can be used to alter the location of a node without disturbing its layoutBounds, which makes it useful for animating a node's location.
         */
        rope.endXProperty().bind(c.translateXProperty().add(c.centerXProperty()));
        rope.endYProperty().bind(c.translateYProperty().add(c.centerYProperty()));

        
        pane.getChildren().addAll(arc,rope,c,hook);
        //Create path transition 
        PathTransition path = new PathTransition();
        path.setDuration(Duration.millis(4000));
        path.setPath(arc);
        path.setNode(c);
        path.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
        path.setCycleCount(Timeline.INDEFINITE);
        path.setAutoReverse(true);
        path.play();

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Pendulum with rope shown");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.setOnMousePressed(e -> path.pause());
        scene.setOnMouseReleased(e -> path.play());
    }

    
    public static void main(String[] args ){
        launch(args);
    }
}