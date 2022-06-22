package c22_EfficientAlgorithms;


import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SearchAnimatePane extends HBox {
    private final List<Integer> array = new ArrayList<>();
    private final Label[] labels = new Label[25];
    private final Rectangle[] rectangles = new Rectangle[25];
    private final int BAR_WIDTH = 10;
    private final int UNIT_HEIGHT = 3;
    private static int key;
    private static int index;

    public SearchAnimatePane() {
        for (int i = 1; i <= 25; i++)
            array.add(i);
        Collections.shuffle(array);
        setAlignment(Pos.BOTTOM_CENTER);

        for (int i = 0; i < rectangles.length; i++) {
            rectangles[i] = new Rectangle(BAR_WIDTH, UNIT_HEIGHT * array.get(i));
            rectangles[i].setFill(Color.TRANSPARENT);
            rectangles[i].setStroke(Color.BLACK);

            labels[i] = new Label("" + array.get(i), rectangles[i]);
            labels[i].setContentDisplay(ContentDisplay.BOTTOM);
            getChildren().add(labels[i]);
        }
    }

    public void reset() {
        rectangles[index].setFill(Color.TRANSPARENT);
        index = 0;
        key = 0;
        Collections.shuffle(array);
        for (int i = 0; i < rectangles.length;i++) {
            rectangles[i].setHeight(UNIT_HEIGHT * array.get(i));
            labels[i].setText(array.get(i) + "");
        }
    }

    public void search(int n) {
        key = n;
        nextStep();
    }

    public int nextStep() {
        if (index < array.size()) {
           if (index > 0 )
                rectangles[index -1].setFill(Color.TRANSPARENT);

           rectangles[index].setFill(Color.RED);

           if (array.get(index) == key)
                return index;
           else
                index++;
        }
        return -1;
    }
}
