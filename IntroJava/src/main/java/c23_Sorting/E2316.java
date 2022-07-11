/*(Bubble-sort animation) Write a program that animates the bubble sort algorithm.
Create an array that consists of 25 distinct numbers from 1 to 25 in a
random order. The array elements are displayed in a histogram, as shown in
Figure 23.20b. Clicking the Step button causes the program to perform one comparison
in the algorithm and repaints the histogram for the new array. Color the
bar that represents the number being considered in the swap. When the algorithm
is finished, display a message to inform the user. Clicking the Reset button
creates a new random array for a new start. */
package c23_Sorting;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class E2316 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();
        BubbleSortPane sortPane = new BubbleSortPane();

        Button btStep = new Button("Step");
        Button btReset = new Button("Reset");
        HBox controlPanel = new HBox(10);
        controlPanel.getChildren().addAll(btStep, btReset);
        controlPanel.setAlignment(Pos.CENTER);
        pane.setBottom(controlPanel);
        pane.setCenter(sortPane);

        BorderPane.setAlignment(controlPanel, Pos.CENTER);
        BorderPane.setAlignment(sortPane, Pos.CENTER);

        btStep.setOnAction(e -> sortPane.step());
        btReset.setOnAction(e -> sortPane.reset());

        Scene scene = new Scene(pane);
        stage.setTitle("Heap visualization");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {Application.launch(args);}
}
