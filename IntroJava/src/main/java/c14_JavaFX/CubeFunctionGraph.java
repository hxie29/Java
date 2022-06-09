package c14_JavaFX;

import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Polyline;
import javafx.scene.text.Text;

class CubeFunctionGraph extends Pane {
    private void paint() {

        Group group = new Group();

        Line axisX = new Line(0, getHeight() * 0.8, getWidth(), getHeight() * 0.8);
        axisX.setStroke(Color.BLACK);
        Line axisY = new Line(getWidth() / 2, getHeight(), getWidth() / 2, getHeight() * 0.1);
        axisY.setStroke(Color.BLACK);
        Double[] arrowPointsX = new Double[]{getWidth() - 20, getHeight() * 0.8 + 10, axisX.getEndX(), axisX.getEndY(), getWidth() - 20, getHeight() * 0.8 - 10};
        Polyline arrowX = new Polyline();
        arrowX.getPoints().addAll(arrowPointsX);
        arrowX.setStroke(Color.BLACK);
        Double[] arrowPointsY = new Double[]{getWidth() * 0.5 - 10, getHeight() * 0.1 + 20, axisY.getEndX(), axisY.getEndY(), getWidth() * 0.5 + 10, getHeight() * 0.1 + 20};
        Polyline arrowY = new Polyline();
        arrowY.getPoints().addAll(arrowPointsY);
        arrowY.setStroke(Color.BLACK);

        Text tX = new Text("X");
        tX.setX(axisX.getEndX() - 20);
        tX.setY(axisX.getEndY() - 20);
        tX.setFill(Color.BLACK);
        Text tY = new Text("Y");
        tY.setX(axisY.getEndX() - 20);
        tY.setY(axisY.getEndY() + 20);
        tY.setFill(Color.BLACK);

        group.getChildren().addAll(axisX, axisY, arrowX, arrowY, tX, tY);
        double originX = axisY.getEndX();
        double originY = axisX.getEndY();


        Polyline polyline = new Polyline();
        ObservableList<Double> list = polyline.getPoints();
        double scaleFactor = 0.0025;
        for (int x = -50; x <= 50; x++) {
            list.add(originX + x);
            list.add(originY - scaleFactor * x * x * x);
        }
        group.getChildren().add(polyline);

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
