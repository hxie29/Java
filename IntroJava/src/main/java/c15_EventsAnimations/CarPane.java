package c15_EventsAnimations;

import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.animation.Timeline;
import javafx.animation.KeyFrame;
import javafx.util.Duration;

public class CarPane extends Pane {
    private final double height = 50;
    private final double width = 500;
    private final double baseX = 0;
    private final double baseY = height;
    private int step = 5;

    private final Circle wheelLeft = new Circle(5);
    private final Circle wheelRight = new Circle(5);
    private final Rectangle body = new Rectangle(50,10);
    private final Polygon head = new Polygon();
    private Double[] points;

    private final Timeline animate = new Timeline(new KeyFrame(Duration.millis(20), e -> move(step)));

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

    public void play() {   
        animate.setCycleCount(Timeline.INDEFINITE);
        animate.play();
    }

    public void pause() {
        animate.pause();
    }

    public void setSpeed(int n) {
        if (n <= 100 && n > 0) step = n;
    }

    public int getSpeed() {
        return step;
    }

    private void move(int step) {
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