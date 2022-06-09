package c18_Recursion;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;

class OvalPane extends StackPane {
    public OvalPane() {
        setHeight(400);
        setWidth(400);
        addShape();
    }

    private void addShape() {
        getChildren().clear();
        double x = getWidth() / 2 - 10;
        double y = getHeight() / 2 - 10;
        addShape(x, y);
    }

    private void addShape(double x, double y) {
        if (x > 0 && y > 0) {
            Ellipse c = new Ellipse();
            c.setStroke(Color.BLACK);
            c.setFill(Color.TRANSPARENT);
            c.setRadiusX(x);
            c.setRadiusY(y);
            getChildren().add(c);
            addShape(x - 10, y - 10);
        }
    }

    @Override
    protected void setHeight(double v) {
        super.setHeight(v);
        addShape();
    }

    @Override
    protected void setWidth(double v) {
        super.setWidth(v);
        addShape();
    }
}
