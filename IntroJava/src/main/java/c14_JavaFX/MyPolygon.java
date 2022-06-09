package c14_JavaFX;

import javafx.collections.ObservableList;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polygon;

class MyPolygon extends Pane {
    private void paint() {
        Polygon p = new Polygon();
        p.setFill(Color.WHITE);
        p.setStroke(Color.BLACK);
        ObservableList<Double> list = p.getPoints(); //here returns null
        double centerX = getWidth() / 2, centerY = getHeight() / 2;
        double radius = Math.min(getWidth(), getHeight() * 0.4);

        for (int i = 0; i < 6; i++) {
            list.add(centerX + radius * Math.cos(2 * Math.PI / 6 * i));
            list.add(centerY - radius * Math.sin(2 * Math.PI / 6 * i));
        }
        getChildren().clear();
        getChildren().add(p);
    }

    @Override
    public void setWidth(double width) {
        super.setWidth(width);
        paint();
    }

    @Override
    public void setHeight(double height) {
        super.setHeight(height);
        paint();
    }
}
