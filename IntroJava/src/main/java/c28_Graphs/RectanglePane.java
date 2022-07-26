package c28_Graphs;

import javafx.scene.Node;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

public class RectanglePane extends Pane {
    public RectanglePane() {
        this.setOnMouseClicked(e -> {
            if (!isInsideRec(e.getX(), e.getY())) {
                getChildren().add(new Rectangle(e.getX()-25, e.getY()-25, 50,50));
                colorIfConnected();
            }
            //Remove a circle if click on the circle
            else {
                getChildren().remove(getRec(e.getX(),e.getY()));
                colorIfConnected();
            }
        });
        //Allow rectangles to be dragged
        this.setOnMouseDragged(e -> {
            if (isInsideRec(e.getX(), e.getY())) {
                Rectangle c = (Rectangle) getRec(e.getX(), e.getY());
                if (c != null) {
                    c.setX(e.getX()-25);
                    c.setY(e.getY()-25);
                }
                colorIfConnected();
            }
        });
    }

    private boolean isInsideRec(double x, double y) {
        for (Node node: getChildren()) {
            if (node.contains(x, y))
                return true;
        }
        return false;
    }

    private Node getRec(double x, double y) {
        for (Node node: getChildren()) {
            if (node.contains(x, y))
                return node;
        }
        return null;
    }

    private void colorIfConnected() {
        if (getChildren().size() != 0) {
            List<Edge> edges = new ArrayList<>();
            for (int i = 0; i < getChildren().size(); i++)
                for (int j = i + 1; j < getChildren().size(); j++) {
                    if (overlaps((Rectangle)(getChildren().get(i)), (Rectangle) (getChildren().get(j)))) {
                        edges.add(new Edge(i, j));
                        edges.add(new Edge(j, i));
                    }
                }
            Graph<Node> graph = new UnweightedGraph<>(getChildren(), edges);
            UnweightedGraph<Node>.SearchTree tree = graph.dfs(0);
            if (getChildren().size() == tree.getNumberOfVerticesFound()) {
                for (Node node: getChildren()) {
                    ((Rectangle)node).setFill(Color.RED);
                    ((Rectangle)node).setStroke(Color.TRANSPARENT);
                }
            }
            else
                for (Node node: getChildren()) {
                    ((Rectangle)node).setFill(Color.WHITE);
                    ((Rectangle)node).setStroke(Color.BLACK);
                }
        }
    }

    private boolean overlaps(Rectangle rec1, Rectangle rec2) {
        return Math.abs(rec1.getX() - rec2.getX()) < 50 && Math.abs(rec1.getY() - rec2.getY()) < 50;
    }
}
