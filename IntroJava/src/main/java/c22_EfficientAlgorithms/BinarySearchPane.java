/*(Binary search animation) Write a program that animates the binary search
algorithm. Create an array with numbers from 1 to 25 in this order. The array
elements are displayed in a histogram, as shown in Figure 22.13. You need to(Binary search animation) Write a program that animates the binary search
algorithm. Create an array with numbers from 1 to 25 in this order. The array
elements are displayed in a histogram, as shown in Figure 22.13. You need to
enter a search key in the text field. Clicking the Step button causes the program
to perform one comparison in the algorithm. Use a light-gray color to paint
the bars for the numbers in the current search range and use a black color to
paint the bar indicating the middle number in the search range. The Step button
also freezes the text field to prevent its value from being changed. When the
algorithm is finished, display the status in a label at the top of a border pane.
Clicking the Reset button enables a new search to start. This button also makes
the text field editable.*/
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

public class BinarySearchPane extends HBox {
    private final List<Integer> array = new ArrayList<>();
    private final Rectangle[] rectangles = new Rectangle[25];
    private final int BAR_WIDTH = 10;
    private final int UNIT_HEIGHT = 3;
    private int key;
    private int index = -1, low = 0, high = 24;

    public BinarySearchPane() {
        for (int i = 1; i <= 25; i++)
            array.add(i);
        setAlignment(Pos.BOTTOM_CENTER);

        for (int i = 0; i < rectangles.length; i++) {
            rectangles[i] = new Rectangle(BAR_WIDTH, UNIT_HEIGHT * array.get(i));
            rectangles[i].setFill(Color.YELLOW);
            rectangles[i].setStroke(Color.BLACK);
            Label[] labels = new Label[25];
            labels[i] = new Label("" + array.get(i), rectangles[i]);
            labels[i].setContentDisplay(ContentDisplay.BOTTOM);
            getChildren().add(labels[i]);
        }
    }

    public void reset() {
        key = 0;
        index = -1;
        low = 0;
        high = 24;
        for (Rectangle rectangle : rectangles)
            rectangle.setFill(Color.YELLOW);
    }

    public void search(int n) {
        key = n;
        nextStep();
    }

    public int nextStep() {
        if (index >= 0)
         rectangles[index].setFill(Color.TRANSPARENT);

        if (low <= high) {
            index = (low + high) / 2;

            if (array.get(index) == key) {
                rectangles[index].setFill(Color.RED);
                return index;
            }
            else {
                rectangles[index].setFill(Color.BLUE);
                if (array.get(index) > key) {
                    for (int i = index + 1; i <= high; i++)
                        rectangles[i].setFill(Color.TRANSPARENT);
                    high = index - 1;
                }
                else {
                    for (int i = low; i <= index -1; i++)
                        rectangles[i].setFill(Color.TRANSPARENT);
                    low = index + 1;
                }
            }
        }
        return -1;
    }
}
