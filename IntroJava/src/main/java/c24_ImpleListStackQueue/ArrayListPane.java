package c24_ImpleListStackQueue;

import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

public class ArrayListPane extends Pane {
    protected final MyArrayList<Integer> list = new MyArrayList<>();
    protected final MyArrayList<ArrayBox> boxes = new MyArrayList<>();
    protected final HBox arrayBox = new HBox();
    protected final HBox emptyLine = new HBox();
    public ArrayListPane() {
        VBox pane = new VBox(20);
        for (int i = 0; i < list.getCapacity(); i++) {
            boxes.add(new ArrayBox());
        }
        getChildren().add(pane);
        Text summary = new Text("array list is empty; size = " + list.size() + " capacity is " + list.getCapacity());
        pane.getChildren().addAll(summary, emptyLine,arrayBox);
        paint();
    }

    public int search(Integer key) {
        return list.indexOf(key);
    }

    public void delete(int index) {
        if (index >= 0 && index < list.size()) {
            list.remove(index);
            boxes.remove(index);
            paint();
        }
    }

    public void insert(int value) {
        insert(list.size(), value);
    }

    public void insert(int index, int value) {
        list.add(index, value);
        paint();
    }

    public void trim() {
        list.trimToSize();
        while (list.getCapacity() - boxes.size() < 0)
            boxes.remove(boxes.size() -1);
        paint();
    }

    protected void paint() {
        if (list.getCapacity() != boxes.size()) {
            while (list.getCapacity() > boxes.size())
                boxes.add(new ArrayBox());
            while (list.getCapacity() < boxes.size())
                boxes.add(new ArrayBox());
        }
        for (int i = 0; i < list.size(); i++) {
            boxes.get(i).setValue(list.get(i));
        }
        arrayBox.getChildren().clear();
        arrayBox.getChildren().addAll(boxes);
    }
}
