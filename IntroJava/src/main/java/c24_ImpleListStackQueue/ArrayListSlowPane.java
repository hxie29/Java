package c24_ImpleListStackQueue;

import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class ArrayListSlowPane extends ArrayListPane{

    @Override
    public void delete(int index){
        if (index >= 0 && index < list.size()) {
            list.remove(index);
            boxes.remove(index);
            paint();
        }
    }

    private static class EmptyBox extends StackPane {
        public EmptyBox(double width, double height) {
            Rectangle rectangle = new Rectangle(width, height);
            rectangle.setFill(Color.TRANSPARENT);
            rectangle.setStroke(Color.TRANSPARENT);
            getChildren().add(rectangle);
        }
    }
}
