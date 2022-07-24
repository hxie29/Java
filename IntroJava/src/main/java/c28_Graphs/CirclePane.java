package c28_Graphs;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import java.util.ArrayList;
import java.util.List;

public class CirclePane extends Pane {
    public CirclePane() {
        this.setOnMouseClicked(e -> {
            if (!isInsideCircle(e.getX(), e.getY())) {
                getChildren().add(new Circle(e.getX(), e.getY(), 20));
                colorIfConnected();
            }
        });
    }

    private boolean isInsideCircle(double x, double y) {
        for (Node node: getChildren()) {
            if (node.contains(x, y))
                return true;
        }
        return false;
    }

    private void colorIfConnected() {
        if (getChildren().size() != 0) {
            List<Edge> edges = new ArrayList<>();
            for (int i = 0; i < getChildren().size(); i++)
                for (int j = i + 1; j < getChildren().size(); j++) {
                    if (overlaps((Circle)(getChildren().get(i)), (Circle) (getChildren().get(j)))) {
                        edges.add(new Edge(i, j));
                        edges.add(new Edge(j, i));
                    }
                }
            Graph<Node> graph = new UnweightedGraph<>(getChildren(), edges);
            UnweightedGraph<Node>.SearchTree tree = graph.dfs(0);
            if (getChildren().size() == tree.getNumberOfVerticesFound()) {
                for (Node node: getChildren())
                    ((Circle)node).setFill(Color.RED);
            }
            else
                for (Node node: getChildren()) {
                    ((Circle)node).setFill(Color.WHITE);
                    ((Circle)node).setStroke(Color.BLACK);
                }
        }
    }

    private boolean overlaps(Circle circle1, Circle circle2) {
        return new Point2D(circle1.getCenterX(), circle1.getCenterY()).
                distance(circle2.getCenterX(), circle2.getCenterY()) <=
                circle1.getRadius() + circle2.getRadius();
    }
}
