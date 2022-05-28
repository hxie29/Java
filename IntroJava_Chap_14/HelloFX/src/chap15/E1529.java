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

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;


public class E1529 extends Application {
    int step = 5;

    @Override
    public void start(Stage primaryStage) {
        VBox pane = new VBox();
        pane.setAlignment(Pos.CENTER);

        //Set up control panel
        HBox controlPanel = new HBox(50);
        controlPanel.setPadding(new Insets(10,10,10,10));
        controlPanel.setAlignment(Pos.CENTER);
        Button pause = new Button("Pause");
        Button resume = new Button("Resume");
        Button speedUp = new Button("Speed up");
        Button speedDown = new Button("Speed down");
        controlPanel.getChildren().addAll(pause,resume,speedUp, speedDown);

        CarPane car = new CarPane();
        pane.getChildren().addAll(car, controlPanel);
        
        Timeline animate = new Timeline(new KeyFrame(Duration.millis(20), e -> car.move(step)));
        animate.setCycleCount(Timeline.INDEFINITE);
        animate.play();

        pause.setOnAction(e -> animate.pause());
        resume.setOnAction(e -> animate.play());
        speedUp.setOnAction(e -> step++);
        speedDown.setOnAction(e -> {
            if (step >0) step--;
            else step = 1;
        });

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Spining fan");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    public static void main(String[] args ){
        launch(args);
    }
}

class CarPane extends Pane {
    private double height = 200;
    private double width = 500;
    private double baseX = 0;
    private double baseY = height;

    private Circle wheelLeft = new Circle(5);
    private Circle wheelRight = new Circle(5);
    private Rectangle body = new Rectangle(50,10);
    private Polygon head = new Polygon();
    private Double[] points;
    public CarPane() {
        setMinHeight(height);
        setMinWidth(width);
        paint();
    }

    private void paint() {
        //Set up wheel left
        wheelLeft.setFill(Color.BLACK);
        wheelLeft.setCenterX(baseX + 15);
        wheelLeft.setCenterY(baseY - wheelLeft.getRadius());
        
        //Set up wheel right
        wheelRight.setFill(Color.BLACK);
        wheelRight.centerXProperty().bind(wheelLeft.centerXProperty().add(20));
        wheelRight.centerYProperty().bind(wheelLeft.centerYProperty());

        //Set up car body
        body.setFill(Color.BLUE);
        body.setX(baseX);
        body.setY(baseY - wheelLeft.getRadius() * 2 - body.getHeight());

        //Set up head
        head.setFill(Color.RED);
        resetPoints();
        head.getPoints().addAll(points);

        getChildren().clear();
        getChildren().addAll(wheelLeft,wheelRight,body,head);
    }

    public void move(int step) {
        if (wheelLeft.getCenterX() < width - 45) {
            //wheels
            wheelLeft.setCenterX(wheelLeft.getCenterX() + step);
            //body
            body.setX(body.getX() + step);
            //head
            for (int i = 0; i < points.length; i++) {
                if (i % 2 == 0) points[i] +=step;
            }
            head.getPoints().clear();
            head.getPoints().addAll(points);
        }
        else {   
        wheelLeft.setCenterX(baseX + 15);
        body.setX(baseX);

        resetPoints();
        head.getPoints().clear();
        head.getPoints().addAll(points);
        }
    }

    private void resetPoints() {
        points = new Double[]{baseX + 10, baseY - 20,
            baseX + 20, baseY - 20 - 10,
            baseX + 30, baseY - 20 - 10,
            baseX + 40, baseY - 20};
    }

    @Override
    protected void setHeight(double arg0) {
        super.setHeight(arg0);
    }

    @Override
    protected void setWidth(double arg0) {
        super.setWidth(arg0);
    }
}