package c20_ListStackQueue;

import javafx.beans.property.DoubleProperty;
import javafx.scene.Node;
import javafx.scene.shape.Circle;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.util.Duration;

public class MultipleBallPane extends Pane {
    private final Timeline animation;

    public MultipleBallPane() {
        animation = new Timeline(new KeyFrame(Duration.millis(50), e -> moveBall()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();
    }

    public void add() {
        Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
        Ball ball = new Ball(30, 30, 30, color);
        getChildren().add(ball);
    }

    public void remove() {
        if (getChildren().size() > 0)
            getChildren().remove(getChildren().size() -1);
    }

    public void play() {
        animation.play();
    }

    public void pause() {
        animation.pause();
    }

    public void speedUp() {
        animation.setRate(animation.getRate() + 0.1);
    }

    public void speedDown() {
        animation.setRate(animation.getRate() - 0.1);
    }

    public DoubleProperty rateProperty() {
        return animation.rateProperty();
    }
    private void moveBall() {
        for (Node node: this.getChildren()) {
            Ball c = (Ball) node;

            //Check boundaries
            if (c.getCenterX() < c.getRadius() || c.getCenterX() > getWidth() - c.getRadius()) {
                c.dx *= -1;
            }

            if (c.getCenterY() < c.getRadius() || c.getCenterY() > getHeight() - c.getRadius()) {
                c.dy *= -1;
            }

            c.setCenterX(c.getCenterX() + c.dx);
            c.setCenterY(c.getCenterY() + c.dy);
        }
    }

    @Override
    protected void setWidth(double v) {
        super.setWidth(v);
    }

    @Override
    protected void setHeight(double v) {
        super.setHeight(v);
    }

    static class Ball extends Circle{
        private double dx = 1, dy = 1;

        Ball(double x, double y, double radius, Color color) {
            super(x,y,radius);
            this.setFill(color);
        }
    }

}
