/*(Display sets of connected circles) Modify Listing 28.10, ConnectedCircles.
java to display sets of connected circles in different colors. That is, if two
circles are connected, they are displayed using the same color; otherwise,
they are not in same color, as shown in Figure 28.25. (Hint: See Programming
Exercise 28.4.)*/
package c28_Graphs;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import java.util.ArrayList;
import java.util.List;

public class CirclePaneDifferentColor extends Pane {
    private final ArrayList<Circle> circles = new ArrayList<>();
    private final Color[] colors = {Color.RED, Color.YELLOW, Color.BLUE, Color.GREEN, Color.PURPLE};
    public CirclePaneDifferentColor() {
        this.setOnMouseClicked(e -> {
            if (!isInsideCircle(e.getX(), e.getY())) {
                Circle c = new Circle(e.getX(), e.getY(), 20);
                circles.add(c);
                getChildren().add(c);
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
            UnweightedGraph<Node> graph = new UnweightedGraph<>(getChildren(), edges);
            List<List<Integer>> connectedIndex = graph.getConnectedComponents();
            for (List<Integer> group: connectedIndex) {
                Color color = colors[(int)(Math.random() * colors.length)];
                for (Integer index: group)
                    circles.get(index).setFill(color);
            }
        }
    }

    private boolean overlaps(Circle circle1, Circle circle2) {
        return new Point2D(circle1.getCenterX(), circle1.getCenterY()).
                distance(circle2.getCenterX(), circle2.getCenterY()) <=
                circle1.getRadius() + circle2.getRadius();
    }
}
