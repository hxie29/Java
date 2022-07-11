/*(Selection-sort animation) Write a program that animates the selection sort algorithm.
Create an array that consists of 25 distinct numbers from 1 to 25 in a random
order. The array elements are displayed in a histogram, as shown in Figure 23.20a.
Clicking the Step button causes the program to perform an iteration of the outer
loop in the algorithm and repaints the histogram for the new array. Color the last
bar in the sorted sub array. When the algorithm is finished, display a message to
inform the user. Clicking the Reset button creates a new random array for a new
start. (You can easily modify the program to animate the insertion algorithm.) */
package c23_Sorting;

import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.Collections;

public class SelectionSortPane extends Pane {
    private final ArrayList<Integer> list = new ArrayList<>();
    private final ArrayList<Rectangle> rectangles = new ArrayList<>();
    private final ArrayList<Label> bars = new ArrayList<>();
    private static int step = 0;

    public SelectionSortPane() {
        HBox barPane = new HBox(5);
        barPane.setAlignment(Pos.BOTTOM_CENTER);

        for (int i = 0; i < 25; i++) {
            list.add (i+1);
            Rectangle rec = new Rectangle(50,10);
            rec.setFill(Color.WHITE);
            rec.setStroke(Color.BLACK);
            rectangles.add(rec);
            Label lb = new Label(list.get(i) + "", rec);
            lb.setContentDisplay(ContentDisplay.BOTTOM);
            bars.add(lb);
            barPane.getChildren().add(lb);
        }
        getChildren().add(barPane);
        reset();
    }

    public void step() {
        if (step < list.size() - 1) {
            int min = list.get(step);
            int minIndex = step;
            for (int i = step + 1; i < list.size(); i++) {
                if (list.get(i) < min) {
                    min = list.get(i);
                    minIndex = i;
                }
            }

            if (minIndex != step) {
                list.set(minIndex, list.get(step));
                list.set(step, min);
            }
            setBars();
            rectangles.get(step).setFill(Color.RED);
            if (step > 0)
                rectangles.get(step - 1).setFill(Color.WHITE);
            step++;
        }
    }

    public void reset() {
        if (step > 0)
            rectangles.get(step - 1).setFill(Color.WHITE);
        Collections.shuffle(list);
        setBars();
        step = 0;
    }

    private void setBars() {
        for (int i = 0; i < list.size(); i++) {
            bars.get(i).setText(list.get(i) + "");
            rectangles.get(i).setHeight(list.get(i) * 10);
        }
    }
}
