/*(Selection-sort animation) Write a program that animates the selection sort algorithm.
Create an array that consists of 25 distinct numbers from 1 to 25 in a random
order. The array elements are displayed in a histogram, as shown in Figure 23.20a.
Clicking the Step button causes the program to perform an iteration of the outer
loop in the algorithm and repaints the histogram for the new array. Color the last
bar in the sorted sub array. When the algorithm is finished, display a message to
inform the user. Clicking the Reset button creates a new random array for a new
start. (You can easily modify the program to animate the insertion algorithm.) */
package c23_Sorting;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class E2315 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();
        SelectionSortPane sortPane = new SelectionSortPane();

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
