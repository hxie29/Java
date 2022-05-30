package chap15;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.util.Duration;
import javafx.beans.property.DoubleProperty;

public class BallPane extends Pane {
    public final double radius = 50;
    private double x = radius, y = radius;
    Circle ball = new Circle(x, y, 60);
    private double dx =1, dy = 1;
    private Timeline animation;
    
    public BallPane(){
        ball.setFill(Color.RED);
        getChildren().add(ball);
        animation = new Timeline(new KeyFrame(Duration.millis(50), e -> moveBall()));
        animation.setCycleCount(Timeline.INDEFINITE);
    }  

    public void play() {
        animation.play();
    }

    public void pause() {
        animation.pause();
    }

    public DoubleProperty getRateProperty() {
        return animation.rateProperty();
    }

    public void increaseSpeed() {
        animation.setRate(animation.getRate() + 0.1);
    }

    public void decreaseSpeed() {
        animation.setRate(animation.getRate() - 0.1);
    }

    protected void moveBall() {
        if (x < radius || x > getWidth() - radius) dx *= -1;
        if (y < radius ||  y > getHeight() - radius) dy *= -1;

        x += dx;
        y += dy;
        ball.setCenterX(x);
        ball.setCenterY(y);
    }
}
