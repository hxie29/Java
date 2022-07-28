/*(Dynamic graphs) Write a program that lets the users create a weighted graph
dynamically. The user can create a vertex by entering its name and location, as
shown in Figure 29.27. The user can also create an edge to connect two vertices.
To simplify the program, assume vertex names are the same as vertex indices.
You have to add the vertex indices 0, 1, . . . , and n, in this order. The user can
specify two vertices and let the program display their shortest path in red.*/
package c29_WeightedGraphs;

import c28_Graphs.City;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;

public class DynamicGraphPane extends BorderPane {
    private final WeightedGraph<City> graph = new WeightedGraph<>();
    private final WeightedGraphViewWithPath graphPane = new WeightedGraphViewWithPath(graph);

    public DynamicGraphPane() {
        this.setCenter(graphPane);
        BorderPane.setAlignment(graphPane, Pos.CENTER);

        BorderPane controlPane = new BorderPane();
        this.setBottom(controlPane);
        BorderPane.setAlignment(controlPane, Pos.CENTER);

        GridPane gridInput = new GridPane();
        gridInput.setPadding(new Insets(10,10,10,10));
        gridInput.setHgap(5);
        gridInput.setVgap(5);
        gridInput.setAlignment(Pos.CENTER_LEFT);

        Button btAddVertex = new Button("Add Vertex");
        Button btAddEdge = new Button("Add Edge");
        Button btFindPath = new Button("Shortest Path");
        TextField tfVname = new TextField();
        TextField tfVx = new TextField();
        TextField tfVy = new TextField();
        TextField tfEdgeU = new TextField();
        TextField tfEdgeV = new TextField();
        TextField tfWeight = new TextField();
        TextField tfStartIndex = new TextField();
        TextField tfEndIndex = new TextField();

        gridInput.add(new Text("Add a new vertex"), 0, 0);
        gridInput.add(new Text("Vertex name: "), 0, 1);
        gridInput.add(tfVname, 1, 1);
        gridInput.add(new Text("x-coordinate"), 0, 2);
        gridInput.add(tfVx, 1, 2);
        gridInput.add(new Text("y-coordinate"), 0, 3);
        gridInput.add(tfVy, 1, 3);
        gridInput.add(btAddVertex, 1, 4);

        gridInput.add(new Text("Add a new edge"), 2, 0);
        gridInput.add(new Text("Vertex u (index)"), 2, 1);
        gridInput.add(tfEdgeU, 3, 1);
        gridInput.add(new Text("Vertex v (index)"), 2, 2);
        gridInput.add(tfEdgeV, 3, 2);
        gridInput.add(new Text("Weight (int)"), 2, 3);
        gridInput.add(tfWeight, 3, 3);
        gridInput.add(btAddEdge, 3, 4);

        gridInput.add(new Text("Find shortest path"), 4, 0);
        gridInput.add(new Text("Starting vertex (index):"), 4, 1);
        gridInput.add(tfStartIndex, 5, 1);
        gridInput.add(new Text("Ending vertex (index)"), 4, 2);
        gridInput.add(tfEndIndex, 5, 2);
        gridInput.add(btFindPath, 5, 3);

        Button btClear = new Button("Start over (Clear Graph)");
        controlPane.setTop(gridInput);
        controlPane.setBottom(btClear);
        BorderPane.setAlignment(btClear, Pos.CENTER);
        BorderPane.setAlignment(gridInput, Pos.CENTER);

        btAddVertex.setOnAction(e -> {
            graph.addVertex(new City(tfVname.getText(), Double.parseDouble(tfVx.getText()), Double.parseDouble(tfVy.getText())));
            graphPane.repaintGraph();
        });

        btAddEdge.setOnAction(e -> {
            graph.addEdge(Integer.parseInt(tfEdgeU.getText()), Integer.parseInt(tfEdgeV.getText()),
                    Integer.parseInt(tfWeight.getText()));
            graph.addEdge(Integer.parseInt(tfEdgeV.getText()), Integer.parseInt(tfEdgeU.getText()),
                    Integer.parseInt(tfWeight.getText()));
            graphPane.repaintGraph();
        });

        btFindPath.setOnAction(e -> graphPane.paintPath(Integer.parseInt(tfStartIndex.getText()), Integer.parseInt(tfEndIndex.getText())));

        btClear.setOnAction(e -> {
            graph.clear();
            graphPane.repaintGraph();
        });
    }
}
