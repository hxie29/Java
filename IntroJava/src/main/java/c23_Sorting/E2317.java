/*(Radix-sort animation) Write a program that animates the radix sort algorithm. Create
an array that consists of 20 random numbers from 0 to 800. The array elements
are displayed, as shown in Figure 23.21. Clicking the Step button causes the program
to place a number in a bucket. The number that has just been placed is displayed in
red. Once all the numbers are placed in the buckets, clicking the Step button collects
all the numbers from the buckets and moves them back to the array. When the
algorithm is finished, clicking the Step button displays a message to inform the user.
Clicking the Reset button creates a new random array for a new start.*/
package c23_Sorting;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class E2317  extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();
        RadixSortPane sortPane = new RadixSortPane();

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
