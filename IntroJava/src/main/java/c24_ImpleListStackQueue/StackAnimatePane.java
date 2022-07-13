/*(Animation: stack) Write a program to animate push and pop in a stack, as shown
in Figure 24.20a.*/
package c24_ImpleListStackQueue;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Line;

import java.util.LinkedList;
import java.util.Stack;

public class StackAnimatePane extends BorderPane {
    protected final Stack<Integer> list = new Stack<>();
    protected final LinkedList<ArrayBox> boxes = new LinkedList<>();
    protected final VBox arrayBox = new VBox();

    public StackAnimatePane() {
        HBox centerView = new HBox();
        centerView.setAlignment(Pos.TOP_CENTER);
        centerView.setPadding(new Insets(10,10,10,10));
        Line line = new Line(10,10, 60,10);
        Line a1 = new Line(40,5,60,10);
        Line a2 = new Line(40,15,60,10);
        Group arrowGroup = new Group(line, a1, a2);
        Label lbTop = new Label("Top", arrowGroup);
        lbTop.setContentDisplay(ContentDisplay.RIGHT);
        centerView.getChildren().addAll(lbTop, arrayBox);
        setCenter(centerView);
        BorderPane.setAlignment(centerView, Pos.CENTER);
    }

    public void push(Integer value) {
        list.push(value);
        boxes.add(0, new ArrayBox(value));
        paint();
    }

    public int pop() {
        int value = list.pop();
        boxes.remove(0);
        paint();
        return value;
    }

    public int peek() {
        return list.peek();
    }

    protected void paint() {
        arrayBox.getChildren().clear();
        arrayBox.getChildren().addAll(boxes);
    }
}
