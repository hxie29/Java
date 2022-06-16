package c20_ListStackQueue;

import javafx.scene.paint.Color;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MultipleBallBigPane extends MultipleBallPane{
    private final PriorityQueue<Ball> balls = new PriorityQueue<>(100, new BallComparator());
    @Override
    public void add() {
            Color color = new Color(Math.random(), Math.random(), Math.random(), 0.5);
            Ball ball = new Ball(30, 30, 2 + 18 * Math.random(), color);
            balls.add(ball);
            getChildren().clear();
            getChildren().addAll(balls);
    }

    @Override
    public void remove() {
        if (balls.size() > 0) {
            balls.poll();
            getChildren().clear();
            getChildren().addAll(balls);
        }
    }

    static class BallComparator implements Comparator<Ball> {
        @Override
        public int compare(Ball o1, Ball o2) {
            return (int)(o2.getRadius() - o1.getRadius());
        }
    }
}
