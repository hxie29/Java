/*(Store numbers in a linked list) Write a program that lets the user enter numbers
from a graphical user interface and displays them in a text area, as shown
in Figure 20.17a. Use a linked list to store the numbers. Do not store duplicate
numbers. Add the buttons Sort, Shuffle, and Reverse to sort, shuffle, and
reverse the list.*/
package c20_ListStackQueue;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

import java.util.Collections;
import java.util.LinkedList;

public class E2002 extends Application {
    @Override
    public void start(Stage primaryStage) {
        LinkedList<Integer> list = new LinkedList<>();

        BorderPane pane = new BorderPane();

        TextField tf = new TextField();
        Label lbInput = new Label("Enter a number: ", tf);
        lbInput.setContentDisplay(ContentDisplay.RIGHT);
        pane.setTop(lbInput);
        BorderPane.setAlignment(lbInput, Pos.CENTER);

        HBox controlPanel = new HBox(10);
        Button btSort = new Button("Sort");
        Button btShuffle = new Button("Shuffle");
        Button btReverse = new Button("Reverse");
        controlPanel.getChildren().addAll(btSort, btShuffle, btReverse);
        controlPanel.setAlignment(Pos.CENTER);
        pane.setBottom(controlPanel);
        BorderPane.setAlignment(controlPanel, Pos.CENTER);

        TextArea ta = new TextArea();
        pane.setCenter(ta);

        tf.setOnAction(e -> {
            String input = tf.getText();
            if (isNumber(input)) {
                Integer in = Integer.parseInt(input);
                if (!list.contains(in))
                    list.push(in);
            }
            ta.setText(toText(list));
        });

        btSort.setOnAction(e -> {
            Collections.sort(list);
            ta.setText(toText(list));
        });

        btShuffle.setOnAction(e -> {
            Collections.shuffle(list);
            ta.setText(toText(list));
        });

        btReverse.setOnAction(e -> {
            Collections.reverse(list);
            ta.setText(toText(list));
        });

        Scene scene = new Scene(pane, 300,300);
        primaryStage.setTitle("Store and display numbers");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private String toText(LinkedList<Integer> list) {
        StringBuilder s = new StringBuilder();
        list.forEach(e -> s.append(e).append(" "));
        return s.toString();
    }

    private boolean isNumber(String s) {
        for (int i = 0; i< s.length(); i++) {
            if (!Character.isDigit(s.charAt(i)))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
