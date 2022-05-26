package chap15;

//Used in E1517 and E1515
import javafx.scene.layout.Pane;
import javafx.scene.shape.Circle;
import javafx.scene.paint.Color;
import javafx.scene.Node;

import javafx.collections.ObservableList;

public class BubblePane extends Pane {
    private double radius = 10;

    public BubblePane() {
    }

    public double getRadius() {
        return radius;
    }
    public void regenerate(double x, double y) {
        paint(x, y);
    }

    private void paint(double x, double y) {
        if (inside(getChildren(), x, y) >= 0) {
            getChildren().remove(inside(getChildren(),x,y));
        }
        else {
            Circle c = new Circle(x, y, radius);
            c.setFill(Color.WHITE);
            c.setStroke(Color.BLACK);
            getChildren().add(c);
        }
    }

    @Override
    protected void setWidth(double arg0) {
        super.setWidth(arg0);
    }

    @Override
    protected void setHeight(double arg0) {
        super.setHeight(arg0);
    }

    private int inside(ObservableList<Node> list, double x, double y) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).contains(x, y)) return i;
        }
        return -1;
    }
    
}
