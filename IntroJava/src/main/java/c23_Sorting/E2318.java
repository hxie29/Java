/*(Merge animation) Write a program that animates the merge of two sorted lists. Create
two arrays, list1 and list2, each of which consists of 8 random numbers from
1 to 999. The array elements are displayed, as shown in Figure 23.22a. Clicking the
Step button causes the program to move an element from list1 or list2 to temp.
Clicking the Reset button creates two new random arrays for a new start. When the
algorithm is finished, clicking the Step button displays a message to inform the user.*/
package c23_Sorting;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class E2318 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();
        MergePane sortPane = new MergePane();

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
