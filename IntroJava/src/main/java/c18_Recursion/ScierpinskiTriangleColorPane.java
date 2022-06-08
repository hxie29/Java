package com.example.recursion;

import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

public class ScierpinskiTriangleColorPane extends SierpinskiTrianglePane {
    private Color color;
    public ScierpinskiTriangleColorPane() {
        super();
    }

    public ScierpinskiTriangleColorPane(Color color) {
        this.color = color;
    }

    @Override
    protected void display(int order, Point2D p1, Point2D p2, Point2D p3) {
        if (order >= 0) {
            if (order == 0) {
                Polygon triangle = new Polygon();
                triangle.getPoints().addAll(p1.getX(), p1.getY(), p2.getX(), p2.getY(), p3.getX(), p3.getY());
                triangle.setStroke(Color.BLACK);
                triangle.setFill(color);
                this.getChildren().add(triangle);
            } else {
                Point2D p12 = p1.midpoint(p2);
                Point2D p23 = p2.midpoint(p3);
                Point2D p13 = p1.midpoint(p3);

                display(order - 1, p1, p12, p13);
                display(order - 1, p2, p23, p12);
                display(order - 1, p3, p23, p13);
            }
        }
    }
}

