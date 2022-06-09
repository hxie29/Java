package c14_JavaFX;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

class BarChart extends Pane {
    private final String title;
    private final double percent;
    private final Color color;

    public BarChart() {
        this("Default", 0, Color.BLACK);
    }

    public BarChart(String title, double percent, Color color) {
        this.title = title;
        this.percent = percent;
        this.color = color;
    }

    private void paint() {
        Text t = new Text(title + " -- " + percent + "%");
        t.setFill(color);
        Rectangle r = new Rectangle();
        r.setFill(color);
        r.setWidth(100);
        r.setHeight(200 * percent / 100.0);
        r.setY(getHeight() - r.getHeight());
        r.setX(0);
        t.xProperty().bind(r.xProperty());
        t.yProperty().bind(r.yProperty().subtract(20));

        getChildren().clear();
        getChildren().addAll(t, r);
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
