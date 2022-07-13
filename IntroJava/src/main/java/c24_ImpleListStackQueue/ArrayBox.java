package c24_ImpleListStackQueue;

import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;

public class ArrayBox extends StackPane {
    private Integer value = null;
    private final Label lbValue = new Label();
    private final Line line = new Line(0,0,0,0);

    public ArrayBox() {
        Rectangle rectangle = new Rectangle(30, 15);
        rectangle.setStroke(Color.BLACK);
        rectangle.setFill(Color.TRANSPARENT);
        line.setStroke(Color.BLACK);
        line.startYProperty().bind(rectangle.heightProperty());
        line.endXProperty().bind(rectangle.widthProperty());
        getChildren().addAll(rectangle, line);
    }

    public ArrayBox(int value) {
        this();
        setValue(value);
    }

    public void setValue(int value) {
        this.value = value;
        lbValue.setText(value + "");
        getChildren().remove(line);
        if (!getChildren().contains(lbValue))
            getChildren().add(lbValue);
    }
}
