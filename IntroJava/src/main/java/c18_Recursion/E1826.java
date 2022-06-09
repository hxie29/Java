/*(Create a maze) Write a program that will find a path in a maze, as shown in
Figure 18.13a. The maze is represented by a 9 * 9 board. The path must meet the
following conditions:
■■ The program enables the user to place or remove a mark on a cell. A path
consists of adjacent unmarked cells. Two cells are said to be adjacent if they
are horizontal or vertical neighbors, but not if they are diagonal neighbors.
■■ The path does not contain cells that form a square. The path in Figure 18.13b,
for example, does not meet this condition. (The condition makes a path easy
to identify on the board.)*/
package c18_Recursion;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class E1826 extends Application {
    @Override
    public void start (Stage primaryStage) {
        BorderPane pane = new BorderPane();
        MazePane maze = new MazePane();
        Text result = new Text("Click find path");
        pane.setCenter(maze);
        pane.setTop(result);
        BorderPane.setAlignment(maze, Pos.CENTER);
        BorderPane.setAlignment(result, Pos.CENTER);

        HBox controlPanel = new HBox(10);
        controlPanel.setAlignment(Pos.CENTER);
        Button btFind = new Button("Find Path");
        Button btClear = new Button("Clear Path");
        controlPanel.getChildren().addAll(btFind, btClear);
        pane.setBottom(controlPanel);
        BorderPane.setAlignment(controlPanel, Pos.CENTER);

        btFind.setOnAction(e -> {
            if (maze.findPath())
                result.setText("Path found.");
            else
                result.setText("Path not found.");
        });
        btClear.setOnAction(e -> {
            maze.reset();
            result.setText("Click find path");
        });

        Scene scene = new Scene(pane, 550,600);
        primaryStage.setTitle("Find path in maze");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
