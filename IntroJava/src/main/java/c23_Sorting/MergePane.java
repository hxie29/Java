/*(Merge animation) Write a program that animates the merge of two sorted lists. Create
two arrays, list1 and list2, each of which consists of 8 random numbers from
1 to 999. The array elements are displayed, as shown in Figure 23.22a. Clicking the
Step button causes the program to move an element from list1 or list2 to temp.
Clicking the Reset button creates two new random arrays for a new start. When the
algorithm is finished, clicking the Step button displays a message to inform the user.*/
package c23_Sorting;

import javafx.geometry.Pos;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import java.util.Arrays;

public class MergePane extends Pane {
    private final int[] list1 = new int[5];
    private final int[] list2 = new int[5];

    private int current1, current2, current3;
    private final TextField[] textFieldsInput = new TextField[10];
    private final TextField[] textFieldsMerge = new TextField[10];
    public MergePane() {
        setPrefSize(800,800);

        //General two lists
        for (int i = 0; i < list1.length; i++) {
            list1[i]= (int)(Math.random() * 1000);
            list2[i]= (int)(Math.random() * 1000);
        }
        Arrays.sort(list1);
        Arrays.sort(list2);

        //create 3 lines of number boxes
        HBox list1Pane = new HBox(5);
        HBox list2Pane = new HBox(5);
        HBox list3Pane = new HBox(5);
        list1Pane.setAlignment(Pos.CENTER);
        list2Pane.setAlignment(Pos.CENTER);
        list3Pane.setAlignment(Pos.CENTER);

        // fill numbers in two lines of input array boxes
        for (int i = 0 ; i < textFieldsInput.length; i++) {
           TextField tf = new TextField();
           tf.setText((i <= 4) ? list1[i] + "" : list2[i - 5] + "");
           tf.setEditable(false);
           tf.setAlignment(Pos.CENTER);
           tf.setPrefColumnCount(3);
           tf.setStyle("-fx-border-color: black");
           textFieldsInput[i] = tf;
           if (i <= 4) {
               list1Pane.getChildren().add(tf);
           }
           else list2Pane.getChildren().add(tf);
        }

        //initiate temp line of merged list with empty text fields
        for (int i = 0; i < textFieldsMerge.length; i++) {
            TextField tf = new TextField();
            textFieldsMerge[i] = tf;
            tf.setEditable(false);
            tf.setAlignment(Pos.CENTER);
            tf.setPrefWidth(50);
            tf.setStyle("-fx-border-color: black");
            list3Pane.getChildren().add(tf);
        }

        // order them in VBox
        Label lbList1 = new Label("list1", list1Pane);
        lbList1.setContentDisplay(ContentDisplay.RIGHT);
        Label lbList2 = new Label("list2", list2Pane);
        lbList2.setContentDisplay(ContentDisplay.RIGHT);
        Label lbList3 = new Label("temp:", list3Pane);
        lbList3.setContentDisplay(ContentDisplay.RIGHT);

        HBox inputPane = new HBox(50);
        inputPane.getChildren().addAll(lbList1, lbList2);
        inputPane.setAlignment(Pos.CENTER);

        VBox pane = new VBox(50);
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(inputPane, lbList3);
        getChildren().add(pane);

    }

    public void step() {
        if (current3 == 0) {
            textFieldsInput[current1].setStyle("-fx-background-color: yellow");
            textFieldsInput[current2 + 5].setStyle("-fx-background-color: yellow");
        }
        if (current1 < list1.length && current2 < list2.length) {
            if (list1[current1] < list2[current2]) {
                textFieldsMerge[current3++].setText(list1[current1] + "");
                textFieldsInput[current1++].setStyle("-fx-background-color: white");
                if (current1 < 5)
                    textFieldsInput[current1].setStyle("-fx-background-color: yellow");
            }
            else {
                textFieldsMerge[current3++].setText(list2[current2] + "");
                textFieldsInput[5 + current2++].setStyle("-fx-background-color: white");
                if (current2 < 5)
                    textFieldsInput[current2 + 5].setStyle("-fx-background-color: yellow");
            }
        }
        else if (current1 < list1.length) {
            textFieldsMerge[current3++].setText(list1[current1] + "");
            textFieldsInput[current1++].setStyle("-fx-background-color: white");
            if (current1 < 5)
                textFieldsInput[current1].setStyle("-fx-background-color: yellow");
        }
        else if (current2 < list2.length) {
            textFieldsMerge[current3++].setText(list2[current2] + "");
            textFieldsInput[5 + current2++].setStyle("-fx-background-color: white");
            if (current2 < 5)
                textFieldsInput[5 + current2].setStyle("-fx-background-color: yellow");
        }
    }


    public void reset() {
        for (int i = 0; i < list1.length; i++) {
            list1[i]= (int)(Math.random() * 1000);
            list2[i]= (int)(Math.random() * 1000);
        }
        Arrays.sort(list1);
        Arrays.sort(list2);
        for (int i = 0; i < textFieldsInput.length; i++) {
            if (i < 5) {
                textFieldsInput[i].setText(list1[i] + "");
                textFieldsInput[i].setStyle("-fx-border-color: black");
            }
            else {

                textFieldsInput[i].setText(list2[i - 5] + "");
                textFieldsInput[i].setStyle("-fx-border-color: black");
            }
        }
        for (TextField tf: textFieldsMerge) {
            tf.setText("");
        }
        current1 = 0;
        current2 = 0;
        current3 = 0;
        getChildren().removeIf(e -> e instanceof Arrow);
    }
}
