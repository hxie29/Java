/* 
(Animation: ball on curve) Write a program that animates a ball moving along
a cosine curve, as shown in Figure 15.34. When the ball gets to the right border,
it starts over from the left. Enable the user to resume/pause the animation with
a click on the left/right mouse button.
 */
package chap15;

import javafx.animation.PathTransition;
import javafx.animation.Timeline;
import javafx.animation.PathTransition.OrientationType;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.collections.ObservableList;

public class E1525 extends Application {
    private Pane pane = new Pane();
    private static final double WIDTH = 1000;
    private static final double HEIGHT = 500;
    private static final double originX = WIDTH / 2;
    private static final double originY = HEIGHT / 2;
    private int scaleFactor = 50;

    @Override
    public void start(Stage primaryStage) {
        pane.setPadding(new Insets(10,10,10,10));
        drawAxis();
       
        Polyline cosineLine = new Polyline();
        ObservableList<Double> list1 = cosineLine.getPoints();
        for (int x = -500; x <= 500; x++) {
            list1.add(x + originX);
            list1.add(originY - scaleFactor * Math.cos(x * 1.0 / scaleFactor));
        }
        cosineLine.setStroke(Color.BLACK);
        
        Circle c = new Circle(10);
        c.setFill(Color.RED);
        pane.getChildren().addAll(cosineLine,c);
        
        
        //Create path transition 
        PathTransition path = new PathTransition();
        path.setDuration(Duration.millis(4000));
        path.setPath(cosineLine);
        path.setNode(c);
        path.setOrientation(OrientationType.ORTHOGONAL_TO_TANGENT);
        path.setCycleCount(Timeline.INDEFINITE);
        path.setAutoReverse(true);
        path.play();

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Circle travel through cosine graph");
        primaryStage.setScene(scene);
        primaryStage.show();

        scene.setOnMousePressed(e -> path.pause());
        scene.setOnMouseReleased(e -> path.play());
    }

    private void drawAxis() {
        Line axisX = new Line(0,HEIGHT * 0.5, WIDTH, HEIGHT * 0.5);
        axisX.setStroke(Color.BLACK);
        Line axisY = new Line(WIDTH/2, HEIGHT, WIDTH / 2, 0);
        axisY.setStroke(Color.BLACK);
        Double[] arrowPointsX = new Double[] {WIDTH - 20, HEIGHT * 0.5 -10, axisX.getEndX(), axisX.getEndY(), WIDTH-20, HEIGHT * 0.5 + 10};
        Polyline arrowX = new Polyline();
        arrowX.getPoints().addAll(arrowPointsX);
        arrowX.setStroke(Color.BLACK);
        Double[] arrowPointsY = new Double[] {WIDTH * 0.5 - 10, HEIGHT * 0.1 + 20, axisY.getEndX(), axisY.getEndY(), WIDTH * 0.5 + 10, HEIGHT * 0.1 + 20};
        Polyline arrowY = new Polyline();
        arrowY.getPoints().addAll(arrowPointsY);
        arrowY.setStroke(Color.BLACK);

        Text tX = new Text("X");
        tX.setX(axisX.getEndX() - 20);
        tX.setY(axisX.getEndY() - 20);
        tX.setFill(Color.BLACK); 
        Text tY = new Text("Y");
        tY.setX(axisY.getEndX() - 20);
        tY.setY(axisY.getEndY() + 20);
        tY.setFill(Color.BLACK);

        Text p1 = new Text(originX - Math.PI * 2 * scaleFactor , originY + 20, "-2\u03c0");
        Text p2 = new Text(originX - Math.PI * scaleFactor, originY + 20, "-\u03c0");
        Text p3 = new Text(originX -10 , originY + 20, "0");
        Text p4 = new Text(originX + Math.PI * scaleFactor, originY + 20, "\u03c0");
        Text p5 = new Text(originX + 2 * Math.PI * scaleFactor, originY + 20, "2\u03c0");

        pane.getChildren().addAll(axisX,axisY,arrowX,arrowY, tX, tY, p1,p2,p3,p4,p5);
    }

    
    public static void main(String[] args ){
        launch(args);
    }

}