package c14_JavaFX;

import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;

class GridLines extends Pane {
    private void paint() {

        Group group = new Group();

        for (int i = 0; i < 3; i++) {
            Line l = new Line(0, 0, getWidth(), 0);
            l.setStroke(Color.BLUE);
            l.setStartY(getHeight() / 4 * (i + 1));
            l.setEndY(getHeight() / 4 * (i + 1));
            group.getChildren().add(l);
        }

        for (int i = 0; i < 3; i++) {
            Line l = new Line(0, 0, 0, getHeight());
            l.setStroke(Color.RED);
            l.setStartX(getWidth() / 4 * (i + 1));
            l.setEndX(getWidth() / 4 * (i + 1));
            group.getChildren().add(l);
        }

        getChildren().clear();
        getChildren().add(group);
    }

    @Override
    protected void setWidth(double arg0) {
        super.setWidth(arg0);
        paint();
    }

    @Override
    protected void setHeight(double arg0) {
        super.setHeight(arg0);
        paint();
    }
}
