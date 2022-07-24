package c28_Graphs;

import javafx.scene.Group;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;
import javafx.scene.text.Text;

import java.util.List;

public class GraphView extends BorderPane {
    private final Graph<? extends Displayable> graph;
    private final Group group = new Group();

    public GraphView(Graph<? extends Displayable> graph) {
        this.graph = graph;
        this.setCenter(group);
        repaintGraph();
    }

    public void repaintGraph() {
        group.getChildren().clear();
        List<? extends Displayable> vertices = graph.getVertices();
        for (int i = 0; i < graph.getSize(); i++) {
            double x = vertices.get(i).getX();
            double y = vertices.get(i).getY();

            group.getChildren().add(new Circle(x, y, 16));
            group.getChildren().add(new Text(x-8, y-18, vertices.get(i).getName()));
        }

        for (int i = 0; i < graph.getSize(); i++) {
            List<Integer> neighbors = graph.getNeighbors(i);
            for (Integer n: neighbors)
                group.getChildren().add(new Line(graph.getVertex(i).getX(), graph.getVertex(i).getY(),
                        graph.getVertex(n).getX(), graph.getVertex(n).getY()));
        }
    }
}
