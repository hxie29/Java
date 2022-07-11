/*(Bubble-sort animation) Write a program that animates the bubble sort algorithm.
Create an array that consists of 25 distinct numbers from 1 to 25 in a
random order. The array elements are displayed in a histogram, as shown in
Figure 23.20b. Clicking the Step button causes the program to perform one comparison
in the algorithm and repaints the histogram for the new array. Color the
bar that represents the number being considered in the swap. When the algorithm
is finished, display a message to inform the user. Clicking the Reset button
creates a new random array for a new start. */
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

public class BubbleSortPane extends Pane {
    private final ArrayList<Integer> list = new ArrayList<>();
    private final ArrayList<Rectangle> rectangles = new ArrayList<>();
    private final ArrayList<Label> bars = new ArrayList<>();
    private static int step = 0;
    private static int sortedIndex;

    public BubbleSortPane() {
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
        if (sortedIndex != 0) {
            if (step == 0) {
                rectangles.get(sortedIndex).setFill(Color.WHITE);
                rectangles.get(sortedIndex - 1).setFill(Color.WHITE);
            }
            if (step < sortedIndex) { // sortedIndex <= list.size() -1;
                if (list.get(step) > list.get(step + 1)) {
                    swap();
                }
                rectangles.get(step).setFill(Color.RED);
                rectangles.get(step + 1).setFill(Color.YELLOW);

                if (step > 0)
                    rectangles.get(step - 1).setFill(Color.WHITE);

                step++;
                if (step == sortedIndex) {
                    rectangles.get(sortedIndex).setFill(Color.BLACK);
                    sortedIndex--;
                    step = 0;
                }
            }
        }
    }

    private void swap() {
        // swap the values
        int temp = list.get(step);
        list.set(step, list.get(step+1));
        list.set(step + 1, temp);
        //swap the bars
        bars.get(step).setText(list.get(step) + "");
        rectangles.get(step).setHeight(list.get(step) * 10);
        bars.get(step + 1).setText(list.get(step + 1) + "");
        rectangles.get(step + 1).setHeight(list.get(step + 1) * 10);
    }


    public void reset() {
        for (Rectangle rec: rectangles) {
            rec.setFill(Color.WHITE);
        }
        Collections.shuffle(list);
        setBars();
        step = 0;
        sortedIndex = list.size() - 1;
    }

    private void setBars() {
        for (int i = 0; i < list.size(); i++) {
            bars.get(i).setText(list.get(i) + "");
            rectangles.get(i).setHeight(list.get(i) * 10);
        }
    }
}
