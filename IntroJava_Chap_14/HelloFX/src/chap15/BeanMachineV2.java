package chap15;


import java.util.ArrayList;
import java.util.Arrays;

import javafx.animation.PathTransition;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.util.Duration;

public class BeanMachineV2 extends Pane {
    private int row = 7;
    private double radius = 10;
    private double hDis = radius * 4.5;
    private double vDis =  hDis * Math.pow(3, 0.5) / 2;
    private double width = 800;
    private double height = 800;
    private double startX = width / 2;
    private double startY = 100;
    private int[] slots = new int[row + 1];
    private ArrayList<Circle> balls = new ArrayList<>();
    private double bottomLength = vDis * 3;
    private ArrayList<Double> circlePoints = new ArrayList<>();
    private ArrayList<Double> linePoints = new ArrayList<>();
    private ArrayList<PathTransition> mPathTransitions = new ArrayList<>();
    private int round = 0;

    public BeanMachineV2() {
        paint();
        Arrays.fill(slots, 0);
    }

    public BeanMachineV2(int row) {
        this.row = row;
        paint(); 
        Arrays.fill(slots, 0);
    }

    private void paint() {
        setMinHeight(height);
        setMinWidth(width);
        
        Group group = new Group();
        
        //Draw all the circles and lines connected to circles at the last row
        double x = startX;
        double y = startY;
        
        //First find all the points for circles and lines connected to circles
   
        for (int i = 0; i < row; i++) {
            x = startX - hDis * (i + 2) / 2.0;
            y += vDis;
            for (int j = 0; j < i + 1; j++) {
                x += hDis;
                circlePoints.add(x);
                circlePoints.add(y);
                Circle c = new Circle(x, y, radius);
                c.setFill(Color.BLACK);
                group.getChildren().add(c);
                if (i == row - 1) {
                    linePoints.add(x);
                    linePoints.add(y);
                    linePoints.add(x);
                    linePoints.add(y + bottomLength);
                }
            }
        }
        
        for (int i = 0; i < linePoints.size(); i+=4) {
            Line l = new Line(linePoints.get(i), linePoints.get(i+1), linePoints.get(i + 2), linePoints.get(i + 3));
            l.setStroke(Color.BLACK);
            group.getChildren().add(l);
        }

        getChildren().add(group);
        drawOutline();
    }

    private void drawOutline() {
        //DrawOutline
        Line bottomL = new Line(linePoints.get(0) - hDis, linePoints.get(3), linePoints.get(linePoints.size() - 2) + hDis, linePoints.get(3));
        bottomL.setStroke(Color.RED);
        Line vLine1 = new Line(bottomL.getStartX(), bottomL.getStartY(), bottomL.getStartX(), bottomL.getStartY() - bottomLength);
        Line vLine2 = new Line(bottomL.getEndX(), bottomL.getEndY(), bottomL.getEndX(), bottomL.getEndY() - bottomLength);
        vLine1.setStroke(Color.RED);
        vLine2.setStroke(Color.RED);
        Line oblique1 = new Line(vLine1.getEndX(), vLine1.getEndY(), vLine1.getEndX() + hDis * row / 2.0, vLine1.getEndY() - hDis * row / 2 * Math.pow(3, 0.5));
        Line oblique2 = new Line(vLine2.getEndX(), vLine2.getEndY(), oblique1.getEndX() + hDis, oblique1.getEndY());
        oblique1.setStroke(Color.RED);
        oblique2.setStroke(Color.RED);
        Line top1 = new Line (oblique1.getEndX(), oblique1.getEndY(), oblique1.getEndX(), startY / 2);
        Line top2 = new Line (oblique2.getEndX(), oblique2.getEndY(), oblique2.getEndX(), startY / 2);
        top1.setStroke(Color.RED);
        top2.setStroke(Color.RED);
        getChildren().addAll(bottomL, vLine1, vLine2, oblique1, oblique2, top1, top2);
    }

    public void restart() {
        getChildren().removeAll(balls);
        balls.clear();
        Arrays.fill(slots, 0);
        mPathTransitions.clear();
        round = 0;
    }

    public void play(int n) {
        while (round < n) {
            throwBall();
            round++;
        }
    }

    private void throwBall() {
        Circle c = new Circle(startX, startY, radius);
        c.setFill(Color.BLUE);
        balls.add(c);
        
        Polyline path = new Polyline();
        path.getPoints().addAll(generatePath()); 
        path.setStroke(Color.TRANSPARENT);
        getChildren().addAll(path, c); 

        PathTransition ballFall = new PathTransition();
        ballFall.setNode(c);
        ballFall.setPath(path);
        ballFall.setDuration(Duration.seconds(4));
        mPathTransitions.add(ballFall);
        ballFall.setDelay(Duration.seconds(mPathTransitions.size() - 1).multiply(4));
        ballFall.play();

    }
    
    private ArrayList<Double> generatePath() {
        ArrayList<Double> path = new ArrayList<>();
        double x = startX, y = startY;
        path.add(x);
        path.add(y);
        int dislocation = 0;
        int direction;
        for (int i = 0; i < row; i++) {
            direction = ((int)(Math.random() + 0.5) == 0) ? -1 : 1;
            dislocation += direction;
            x += direction * hDis / 2.0;
            y += vDis;
            path.add(x);
            path.add(y);
        }
        //final straight fall
        y = linePoints.get(linePoints.size() - 1) - radius - 2 * radius * slots[findSlots(dislocation)];
        path.add(x);
        path.add(y);
        slots[findSlots(dislocation)]++;

        return path;
    } 

    private int findSlots(int n) {
        return (n + row) / 2;
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
