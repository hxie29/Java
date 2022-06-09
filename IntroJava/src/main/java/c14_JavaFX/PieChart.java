package c14_JavaFX;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcType;
import javafx.scene.text.Text;

class PieChart extends Pane {
    private final String[] title;
    private final double[] percent;
    private final Color[] color;

    public PieChart(String[] title, double[] percent, Color[] color) {
        this.title = title;
        this.percent = percent;
        this.color = color;
    }

    private void paint() {
        double begin = 0;
        double radius = 200;
        getChildren().clear();
        for (int i = 0; i < title.length; i++) {
            Text t = new Text(title[i] + " -- " + percent[i] + "%");
            t.setFill(Color.BLACK);

            Arc r = new Arc();
            r.setType(ArcType.ROUND);
            r.setFill(color[i]);
            r.centerXProperty().bind(widthProperty().divide(2));
            r.centerYProperty().bind(heightProperty().divide(2));
            r.setRadiusX(radius);
            r.setRadiusY(radius);
            r.setStartAngle(begin / 100.0 * 360);
            r.setLength(percent[i] / 100.0 * 360);

            double x = radius / 1.2 * Math.cos((2 * begin + percent[i]) / 2 / 100.0 * 2 * Math.PI);
            double y = radius / 1.2 * Math.sin((2 * begin + percent[i]) / 2 / 100.0 * 2 * Math.PI);
            t.xProperty().bind(widthProperty().divide(2).add(x));
            t.yProperty().bind(heightProperty().divide(2).subtract(y));
            getChildren().addAll(r, t);

            begin += percent[i];
        }
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
