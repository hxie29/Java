package c23_Sorting;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

public class HeapPane extends Pane {
    private final Heap<Integer> heap = new Heap<>();
    private double vGap = 25;

    public HeapPane() {
    }

    public HeapPane(int[] list) {
        this();
        for (int i: list)
            heap.add(i);
        displayHeap();
    }

    private void displayHeap() {
        this.getChildren().clear();
        if (heap.getSize() != 0) {
            displayHeap(0, getWidth() / 2, 50, getWidth()/4);
        }
    }

    public void displayHeap(int index, double x, double y, double hGap) {
        if (index >= 0 && index < heap.list.size()) {
            // display left subtree
            if (heap.leftChildIndex(index) < heap.list.size()) {
                this.getChildren().add(new Line(x-hGap, y + vGap, x, y));
                displayHeap(heap.leftChildIndex(index), x - hGap, y + vGap, hGap /2);
            }
            //display right subtree
            if (heap.rightChildIndex(index) < heap.list.size()) {
                this.getChildren().add(new Line(x + hGap, y + vGap, x, y));
                displayHeap(heap.rightChildIndex(index), x + hGap, y + vGap, hGap /2);
            }
            // create this node bubble
            Circle circle = new Circle(x, y,20);
            circle.setFill(Color.WHITE);
            circle.setStroke(Color.BLACK);
            this.getChildren().addAll(circle, new Text(x-4, y + 4, heap.list.get(index) + ""));
        }
    }

    public void insert(int key) {
        heap.add(key);
        displayHeap();
    };
    public void remove(int key) {
        heap.remove(key);
        displayHeap();
    };

    @Override
    protected void setWidth(double v) {
        super.setWidth(v);
        displayHeap();
    }

    @Override
    protected void setHeight(double v) {
        super.setHeight(v);
    }
}
