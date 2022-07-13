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
public class QueuePane extends BorderPane {
    protected final LinkedList<Integer> list = new LinkedList<>();
    protected final LinkedList<ArrayBox> boxes = new LinkedList<>();
    private final HBox centerView = new HBox();
    protected final VBox headGroup = new VBox();
    protected final VBox tailGroup = new VBox();
    public QueuePane() {
        setCenter(centerView);
        BorderPane.setAlignment(centerView, Pos.CENTER);
        centerView.setAlignment(Pos.BOTTOM_LEFT);
        centerView.setPadding(new Insets(10,10,10,10));

        // CREATE head arrow label
        Line line = new Line(10,10, 10,60);
        Line a1 = new Line(5,50,10,60);
        Line a2 = new Line(15,50,10,60);
        Group arrow1 = new Group(line, a1, a2);
        Label lbHead = new Label("Head");
        lbHead.setGraphic(arrow1);
        lbHead.setContentDisplay(ContentDisplay.BOTTOM);

        // CREATE tail arrow label
        Line line2 = new Line(8,10, 0,60);
        Line a3 = new Line(0,50,0,60);
        Line a4 = new Line(15,50,0,60);
        Group arrow2 = new Group(line2, a3, a4);
        Label lbTail = new Label("Tail");
        lbTail.setGraphic(arrow2);
        lbTail.setContentDisplay(ContentDisplay.BOTTOM);

        headGroup.getChildren().add(lbHead);
        tailGroup.getChildren().add(lbTail);
    }

    public void enqueue(Integer value) {
        list.addLast(value);
        boxes.addLast(new ArrayBox(value));
        paint();
    }

    public int dequeue() {
        int value = list.removeFirst();
        boxes.removeFirst();
        paint();
        return value;
    }

    public void reset() {
        list.clear();
        paint();
    }

    protected void paint() {
        centerView.getChildren().clear();
        headGroup.getChildren().removeIf(e -> e instanceof ArrayBox);
        tailGroup.getChildren().removeIf(e -> e instanceof ArrayBox);
        if (list.size() == 1 ){
            headGroup.getChildren().add(boxes.get(0));
            centerView.getChildren().addAll(headGroup, tailGroup);
        }
        else if (list.size() > 1) {
            headGroup.getChildren().add(boxes.getFirst());
            centerView.getChildren().addAll(headGroup);
            for (int i = 1; i < list.size() - 1; i++) {
                centerView.getChildren().add(boxes.get(i));
            }
            tailGroup.getChildren().add(boxes.getLast());
            centerView.getChildren().addAll(tailGroup);
        }
    }
}
