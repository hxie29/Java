package c18_Recursion;

import javafx.geometry.Point2D;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class SierpinskiTrianglePane extends Pane {
    private int order;
    public SierpinskiTrianglePane() {
        this(0);
    }

    public SierpinskiTrianglePane(int order) {
        this.order = order;
        setHeight(400);
        setWidth(400);
        paint();
    }

    public void increaseOrder() {
        setOrder(order +1);
    }

    public void decreaseOrder() {
        if (order > 0)
            setOrder(order -1);
    }
    public void setOrder(int order) {
        this.order = order;
        paint();
    }

    protected void paint() {
        Point2D p1 = new Point2D(getWidth() / 2, 10);
        Point2D p2 = new Point2D(10, getHeight() - 10);
        Point2D p3 = new Point2D(getWidth() - 10, getHeight() - 10);

        this.getChildren().clear();
        display(order, p1, p2, p3);
    }

    protected void display(int order, Point2D p1, Point2D p2, Point2D p3) {
        if (order >= 0) {
            if (order == 0) {
                    Polygon triangle = new Polygon();
                    triangle.getPoints().addAll(p1.getX(), p1.getY(), p2.getX(), p2.getY(), p3.getX(), p3.getY());
                    triangle.setStroke(Color.BLACK);
                    triangle.setFill(Color.WHITE);
                    this.getChildren().add(triangle);
                }
            else {
                Point2D p12 = p1.midpoint(p2);
                Point2D p23 = p2.midpoint(p3);
                Point2D p13 = p1.midpoint(p3);

                display(order -1, p1, p12, p13);
                display(order -1, p2, p23, p12);
                display(order -1, p3, p23, p13);
            }

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
}
