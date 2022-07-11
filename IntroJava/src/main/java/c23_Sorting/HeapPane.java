package c23_Sorting;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import java.util.ArrayList;

public class HeapPane extends Pane {
    private final Heap<Integer> heap = new Heap<>();
    private final ArrayList<Circle> circles = new ArrayList<>();
    private final ArrayList<Text> texts = new ArrayList<>();

    public HeapPane() {
        setMinHeight(800);
        setMinWidth(2000);
    }

    public HeapPane(int[] list) {
        this();
        for (int i: list)
            heap.add(i);
        paint();
    }

    private void paint() {
        if (heap.getSize() != 0) {
            this.getChildren().clear();
            ArrayList<Integer> list = heap.getList();
            createBubbles(list);

            double stepH = 50;
            double stepW = 800;
            double x = getWidth() / 2;
            double y = 100;

            int currentLevel = 0;

            for (int i = 0; i < list.size(); i++) {
                if ((int)Math.pow(2, currentLevel) - 1 <= i) {
                    currentLevel++;
                    y += stepH;
                    stepW /= 2;
                    x = getWidth() / 2 - stepW * ((int)Math.pow(2, currentLevel) -1) / 2;// verify coordinates
                }
                else {
                    x += stepW;
                }
                circles.get(i).setCenterX(x);
                circles.get(i).setCenterY(y);
                //connection line
                if (i > 0) {
                    Line line = new Line(x, y, x, y);
                    double endX = x + ((i % 2 == 0) ? -1 : 1) * stepW / 2;
                    line.setEndX(endX); // verify coordinates
                    line.setEndY(y - stepH);
                    line.setStroke(Color.BLACK);
                    //add all the lines before adding the circles
                    this.getChildren().add(line);
                }
            }
            //add all the bubbles
            this.getChildren().addAll(circles);
            this.getChildren().addAll(texts);
        }
        else this.getChildren().clear();
    }

    private void createBubbles(ArrayList<Integer> list) {
        circles.clear();
        texts.clear();
        for (Integer n: list) {
            Text text = new Text(n+ "");
            Circle circle = new Circle(20);
            circle.setFill(Color.WHITE);
            circle.setStroke(Color.BLACK);
            text.xProperty().bind(circle.centerXProperty());
            text.yProperty().bind(circle.centerYProperty());
            texts.add(text);
            circles.add(circle);
        }
    }

    public void insert(int key) {
        heap.add(key);
        paint();
    };
    public void remove(int key) {
        heap.remove(key);
        paint();
    };

    @Override
    protected void setWidth(double v) {
        super.setWidth(v);
        paint();
    }

    @Override
    protected void setHeight(double v) {
        super.setHeight(v);
    }
}
