/*(Radix-sort animation) Write a program that animates the radix sort algorithm. Create
an array that consists of 20 random numbers from 0 to 800. The array elements
are displayed, as shown in Figure 23.21. Clicking the Step button causes the program
to place a number in a bucket. The number that has just been placed is displayed in
red. Once all the numbers are placed in the buckets, clicking the Step button collects
all the numbers from the buckets and moves them back to the array. When the
algorithm is finished, clicking the Step button displays a message to inform the user.
Clicking the Reset button creates a new random array for a new start.*/
package c23_Sorting;

import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import java.util.ArrayList;
import java.util.stream.IntStream;

public class RadixSortPane extends Pane {
    private final int[] list = new int[25];
    private final TextArea[] taBuckets = new TextArea[10];
    private final ArrayList<TextField> arrayBoxes = new ArrayList<>();
    private final  ArrayList<Integer>[] buckets = new ArrayList[10];
    private static int digit;
    private static int sortedDigit;

    public RadixSortPane() {
        VBox pane = new VBox(50);
        pane.setAlignment(Pos.CENTER);
        HBox barPane = new HBox(50);
        barPane.setAlignment(Pos.CENTER);
        HBox arrayPane = new HBox(2);
        arrayPane.setAlignment(Pos.CENTER);

        for (int i = 0; i < 25; i++) {
            list[i] = ((int)(Math.random() * 1000));
            TextField tf = new TextField();
            tf.setEditable(false);
            tf.setAlignment(Pos.CENTER);
            tf.setPrefColumnCount(3);
            tf.setStyle("-fx-border-color: black");
            arrayBoxes.add(tf);
            arrayPane.getChildren().add(tf);
        }

        for (int i = 0; i < 10; i++) {
            buckets[i] = new ArrayList<>();
            TextArea taBucket = new TextArea();
            taBucket.setEditable(false);
            taBucket.setStyle("-fx-border-color: black");
            taBucket.setPrefColumnCount(5);
            taBucket.setPrefRowCount(15);
            taBuckets[i] = taBucket;
            Label lb = new Label("bucket[" + i + "]", taBucket);
            lb.setContentDisplay(ContentDisplay.TOP);
            barPane.getChildren().add(lb);
        }
        reset();
        pane.getChildren().addAll(arrayPane, barPane);
        getChildren().add(pane);
    }

    public void step() {
        if (sortedDigit < digit) {
            for (ArrayList<Integer> b: buckets) {
                b.clear();
            }

            sortedDigit++;
            for (int k : list) {
                int key = k / (int)(Math.pow(10, sortedDigit -1)) % 10 ;
                buckets[key].add(k);
            }
            updateBucket();
            updateArray();
            displayArray();
        }
    }


    public void reset() {
        taBuckets[0].setText("");
        for (int i = 0; i < 25; i++) {
            list[i]= (int)(Math.random() * 1000);
        }
        getDigit();
        displayArray();
        sortedDigit = 0;
    }

    private void updateArray() {
        int index = 0;
        for (ArrayList<Integer> bucket : buckets) {
            if (!bucket.isEmpty()) {
                for (Integer integer : bucket) list[index++] = integer;
            }
        }
    }
    private void displayArray() {
        for (int i = 0; i < list.length; i++) {
            arrayBoxes.get(i).setText(list[i] + "");
        }
    }

    private void updateBucket() {
        for (int i = 0; i < buckets.length; i++) {
            if (buckets[i].isEmpty()) {
                taBuckets[i].setText("");
            }
            else {
                StringBuilder s = new StringBuilder();
                for (Integer n: buckets[i]) {
                    s.append(n).append("\n");
                }
                taBuckets[i].setText(s.toString());
            }
        }
    }

    private void getDigit() {
        int max = IntStream.of(list).max().getAsInt();
        digit = (int)Math.log(max) + 1;
    }
}
