package chap15;


import java.util.ArrayList;

import javafx.animation.PathTransition;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.util.Duration;

public class BeanMachineV2 extends Pane {
    private int row = 7;
    private double radius = 10;
    private double hDis = radius * 5;
    private double vDis =  hDis * Math.pow(3, 0.5) / 2;
    private double width = 800;
    private double height = 800;
    private double startX = width / 2;
    private double startY = 20;
    private ArrayList<Integer> slots;
    private ObservableList<Node> balls;
    private ArrayList<Double> circlePoints = new ArrayList<>();
    private ArrayList<Double> linePoints = new ArrayList<>();
    PathTransition ballFall = new PathTransition();

    public BeanMachineV2() {
        paint();
        resetSlots();
    }

    public BeanMachineV2(int row) {
        this.row = row;
        paint(); 
        resetSlots();
    }

    private void paint() {
        setMinHeight(height);
        setMinWidth(width);
        
        Group group = new Group();
        
        //Draw all the circles and lines connected to circles at the last row
        double x = startX;
        double y = startY + vDis;
        
        //First find all the points for circles and lines connected to circles
        double bottomLength = vDis * 3;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < i + 1; j++) {
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
                x = startX - hDis * ((i + 1) / 2.0 - j);
            }
            y += vDis;
        }
        
        for (int i = 0; i < linePoints.size(); i+=4) {
            Line l = new Line(linePoints.get(i), linePoints.get(i+1), linePoints.get(i + 2), linePoints.get(i + 3));
            l.setStroke(Color.BLACK);
            group.getChildren().add(l);
        }

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
        Line top1 = new Line (oblique1.getEndX(), oblique1.getEndY(), oblique1.getEndX(), startY);
        Line top2 = new Line (oblique2.getEndX(), oblique2.getEndY(), oblique2.getEndX(), startY);
        top1.setStroke(Color.RED);
        top2.setStroke(Color.RED);
        group.getChildren().addAll(bottomL, vLine1, vLine2, oblique1, oblique2, top1, top2);

        getChildren().clear();
        getChildren().add(group);
    }

    public void play(int round) {
        while (balls.size() < round) {
            throwBall();
        }
    }

    public void restart() {
        getChildren().removeAll(balls);
        balls.removeAll();
    }

    private void throwBall() {
        Circle c = new Circle(startX, startY, 10);
        c.setFill(Color.YELLOW);
        balls.add(c);
        getChildren().add(c);

        Polyline path = new Polyline();
        path.getPoints().addAll(generatePath());
        ballFall.setNode(c);
        ballFall.setPath(path);
        ballFall.setDuration(Duration.seconds(4));
        ballFall.setCycleCount(1);
        ballFall.play();
    }

    private void resetSlots() {
        slots.clear();
        for (int i = 0; i <= row; i++) {
            slots.add(0);
        }
    }


    private ArrayList<Double> generatePath() {
        ArrayList<Double> path = new ArrayList<>();
        double x = startX, y = startY;
        path.add(x);
        path.add(y);

        for (int i = 0; i < row; i++) {
            //fall straight till tangent
            y += vDis - 4 * radius;
            path.add(x);
            path.add(y);

            //Choose left write, fall diagonaly
            y += 2 * radius;
            x += (((int)(Math.random()+0.5) == 0) ? (-1) : 1) * 4 * radius /  Math.pow(3, 0.5) / 2;
            path.add(x);
            path.add(y);
        }
        //final straight fall -- not correct yet!!!!!
        int index = findSlot(x);
        y = linePoints.get(linePoints.size() - 1) - radius - 2 * radius * slots[index];
        path.add(x);
        path.add(y);

        return path;
    } 

    private int findSlots(double x) {
        
    }

    @Override
    protected void setHeight(double arg0) {
        super.setHeight(arg0);
        paint();
    }

    @Override
    protected void setWidth(double arg0) {
        super.setWidth(arg0);
        paint();
    }
}
