package c23_Sorting;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class Arrow extends Pane {
    private Text text = new Text();
    private boolean pointDown = true;
    private int unitHorizontal = 10;
    private int verticalHorizontal = 10;
    private int arrowLength = 50;
    private double x = 100, y= 100;
    private final Line l1 = new Line(0,0,0, -arrowLength);
    private final Line l2 = new Line(0,0,-30, arrowLength - 30);
    private final Line l3 = new Line(0,0,30, arrowLength - 30);

    public Arrow() {
        this("", true);
    }

    public Arrow(String title) {
        this(title, true);

    }

    public Arrow(String title, boolean pointDown) {
        this.pointDown = pointDown;
        int direction = (pointDown) ? 1 : -1;

        l1.setStroke(Color.BLACK);
        l2.setStroke(Color.BLACK);
        l3.setStroke(Color.BLACK);

        l1.endXProperty().bind(l1.startXProperty());
        l1.endYProperty().bind(l1.startYProperty().subtract(arrowLength * direction));

        l2.startXProperty().bind(l1.startXProperty());
        l2.endXProperty().bind(l2.startXProperty().subtract(30));
        l2.startYProperty().bind(l1.startYProperty());
        l2.endYProperty().bind(l1.startYProperty().subtract(30 * direction));

        l3.startXProperty().bind(l1.startXProperty());
        l3.endXProperty().bind(l2.startXProperty().add(30));
        l3.startYProperty().bind(l1.startYProperty());
        l3.endYProperty().bind(l2.endYProperty());

        text.xProperty().bind(l2.endXProperty());
        text.yProperty().bind(l2.endYProperty());

        setTitle(title);
        getChildren().addAll(l1, l2, l3, text);

    }

    public void setInitialPosition(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public void setTitle (String title) {
        text.setText(title);
    }

    public void setArrowLength(int length) {arrowLength = length;}

    public void setUnitHorizontal(int unit) {unitHorizontal = unit;}
    public void setUnitVertical(int unit) { verticalHorizontal = unit;}

    public void moveRight() {
        l1.setStartX(l1.getStartX() + unitHorizontal);
    }

    public void moveLeft() {
        l1.setStartX(l1.getStartX() - unitHorizontal);
    }

    public void moveUp() {

    }

    public void reset() {
        l1.setStartX(x);
        l1.setStartY(y);
    }
}
