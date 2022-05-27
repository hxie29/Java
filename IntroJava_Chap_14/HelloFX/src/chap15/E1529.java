/* 
(Racing car) Write a program that simulates car racing, as shown in
Figure 15.36a. The car moves from left to right. When it hits the right end, it
restarts from the left and continues the same process. You can use a timer to
control animation. Redraw the car with new base coordinates (x, y), as shown
in Figure 15.36b. Also let the user pause/resume the animation with a button
press/release and increase/decrease the car speed by pressing the up and down
arrow keys.
 */
package chap15;

import com.sun.prism.paint.Color;

import javafx.animation.KeyFrame;
import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


public class E1529 extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();
        pane.setStyle("-fx-border-stroke: black");;
        HBox controlPanel = new HBox(50);
        controlPanel.setPadding(new Insets(10,10,10,10));
        controlPanel.setAlignment(Pos.CENTER);
        Button pause = new Button("Pause");
        Button resume = new Button("Resume");
        Button speedUp = new Button("Speed up");
        Button speedDown = new Button("Speed down");
        controlPanel.getChildren().addAll(pause,resume,speedUp, speedDown);
        pane.setBottom(controlPanel);
        BorderPane.setAlignment(controlPanel, Pos.CENTER);

        Line path = new Line(30,0,0,0);
        path.startYProperty().bind(pane.heightProperty().subtract(15));
        path.endXProperty().bind(pane.widthProperty().subtract(30));
        path.endYProperty().bind(path.startYProperty());

        Gourp car = new Group();
        Rectangle r = new Rectangle(50,10);
        Circle wheel1 = new Circle(5);
        Circle wheel2 = new Circle(5);
        
        FanPane fan = new FanPane();
        pane.setCenter(fan);

        PathTransition animation = new PathTransition(Duration.seconds(10), path, car);
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
        
        pause.setOnAction(e -> animation.pause());
        resume.setOnAction(e -> animation.play());
        speedUp.setOnAction(e -> fan.speedUp());
        speedDown.setOnAction(e -> fan.speedUp());

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Spining fan");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    public static void main(String[] args ){
        launch(args);
    }
}