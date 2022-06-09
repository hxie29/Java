package c14_JavaFX;


import java.util.ArrayList;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

public class BeanMachine extends Pane {
    private int row = 7;

    public BeanMachine() {
        paint();
    }

    public BeanMachine(int row) {
        this.row = row;
        paint();
    }

    private void paint() {
        double centerX = getWidth() / 2, centerY = getHeight() / 2;
        double hDis = Math.min(getHeight(), getWidth()) / (row * 2 + 1);
        double vDis = hDis * Math.pow(3, 0.5) / 2;
        double radius = hDis * 0.2;
        double bottomLength = vDis * 3;

        Group group = new Group();

        //Draw all the circles and lines connected to circles at the last row
        double x;
        double y = centerY - (row + 1) / 2.0 * vDis;

        //First find all the points for circles and lines connected to circles
        ArrayList<Double> circlePoints = new ArrayList<>();
        ArrayList<Double> linePoints = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < i + 1; j++) {
                x = centerX - hDis * ((i + 1) / 2.0 - j);
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
        Line top1 = new Line (oblique1.getEndX(), oblique1.getEndY(), oblique1.getEndX(), oblique1.getEndY() - vDis);
        Line top2 = new Line (oblique2.getEndX(), oblique2.getEndY(), oblique2.getEndX(), oblique2.getEndY() - vDis);
        top1.setStroke(Color.RED);
        top2.setStroke(Color.RED);
        group.getChildren().addAll(bottomL, vLine1, vLine2, oblique1, oblique2, top1, top2);

        getChildren().clear();
        getChildren().add(group);
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
