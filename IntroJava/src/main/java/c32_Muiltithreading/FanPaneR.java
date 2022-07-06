package c32_Muiltithreading;

import javafx.beans.property.DoubleProperty;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.shape.Circle;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class FanPaneR extends Pane implements Runnable{
    private double change = 1;
    private final Arc[] blades = new Arc[6];
    private boolean isRunning = true;
    private final Lock lock = new ReentrantLock();
    private final Condition canRun = lock.newCondition();

    public FanPaneR() {
        setMinHeight(400);
        setMinWidth(400);

        //Create boundary
        double radius = 200;
        Circle c = new Circle(radius * 1.2, radius * 1.2, radius + 20);
        c.setFill(Color.TRANSPARENT); 
        c.setStroke(Color.BLACK);
        getChildren().add(c);
        c.centerXProperty().bind(widthProperty().divide(2));
        c.centerYProperty().bind(heightProperty().divide(2));

        //Create blades
        double start = 30;
        for (int i = 0; i < blades.length; start+=60, i++) {
            blades[i] = new Arc(c.getCenterX(), c.getCenterY(), radius, radius, start, 30);
            blades[i].setType(ArcType.ROUND);
            blades[i].setFill((i % 2 == 0) ? Color.BLACK : Color.GREY);
            blades[i].centerXProperty().bind(c.centerXProperty());
            blades[i].centerYProperty().bind(c.centerYProperty());
        }
        getChildren().addAll(blades);
    }

    public void speedUp() {
        change *=2;
    }

    public void speedDown() {
        change /=2;
    }

    public void setSpeed(int n) {
        change = n;
    }

    public void setSpeed(DoubleProperty n) {
        change = n.doubleValue();
    }

    public void changeDirection() {
        change *= -1;
    }

    //Bug happens here!
    /* private void paint(double radius) {
        getChildren().clear();
    } */

    public void spinBlades() {
        for (Arc b: blades) {
            b.setStartAngle(b.getStartAngle() + change);
        }     
    }

    public void play() {
        canRun.signal();
        isRunning = true;
    }

    public void pause() {
        isRunning = false;
    }

    @Override
    protected void setWidth(double arg0) {
        super.setWidth(arg0);
        //paint(radius);
    }
    
    @Override
    protected void setHeight(double arg0) {
        super.setHeight(arg0);
        //paint(radius);
    }

    @Override
    public void run() {
        while (true) {
            try {
                while (!isRunning) {
                    canRun.await();
                }
                spinBlades();
                Thread.sleep(50);
            }
            catch (InterruptedException ex) {
                ex.printStackTrace();
            }
        }
    }
}
