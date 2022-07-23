package c18_Recursion;

import javafx.scene.layout.Pane;
import javafx.scene.shape.Line;

public class HTreePane extends Pane {
    private int order = 0;
    public HTreePane() {
        setMinHeight(400);
        setMinWidth(400);
        display();
    }

    public void setOrder(int n) {
        order = n;
        display();
    }

    private void display() {
        getChildren().clear();
        drawH(getWidth() /2, getHeight()/2, getHeight()/3, 0);
    }

    private void drawH(double x, double y, double length, int currentLevel) {
        Line l1 = new Line(x - length/2, y, x + length/2, y);
        Line l2 = new Line(l1.getStartX(), y - length/2, l1.getStartX(), y + length/2);
        Line l3 = new Line(l1.getEndX(), y - length/2, l1.getEndX(), y + length/2);
        this.getChildren().addAll(l1, l2, l3);
        if (currentLevel < order) {
            drawH(l2.getStartX(), l2.getStartY(), length/2, currentLevel+1);
            drawH(l2.getEndX(), l2.getEndY(), length/2, currentLevel+1);
            drawH(l3.getStartX(), l3.getStartY(), length/2, currentLevel+1);
            drawH(l3.getEndX(), l3.getEndY(), length/2, currentLevel+1);
        }
    }
}
