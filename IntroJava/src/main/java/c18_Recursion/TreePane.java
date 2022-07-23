package c18_Recursion;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class TreePane extends Pane {
    private int order = 0;
    public TreePane(){
        setMinHeight(400);
        setMinWidth(400);
        display(getWidth()/2, getHeight() - 100);
    }

    public void setOrder(int order) {
        this.order = order;
        display(getWidth()/2, getHeight() - 100);
    }

    public void drag(double x, double y) {
        display(x, y + getHeight()/2 - 100);
    }

    private void display(double x, double y) {
        getChildren().clear();
        drawH(x, y, getHeight()/3, Math.PI / 2, 0);
    }

    private void drawH(double x, double y, double length, double angle, int currentLevel) {
        Line l1 = new Line(x, y, x + length * Math.cos(angle), y - length * Math.sin(angle));
        this.getChildren().add(l1);
        if (currentLevel < order) {
            drawH(l1.getEndX(), l1.getEndY(), length/2, angle + Math.PI / 6, currentLevel+1);
            drawH(l1.getEndX(), l1.getEndY(), length/2, angle - Math.PI / 6, currentLevel+1);
        }
    }
}
