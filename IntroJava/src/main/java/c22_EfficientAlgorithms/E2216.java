/*(Linear search animation) Write a program that animates the linear search
algorithm. Create an array that consists of 25 distinct numbers from 1 to 25
in a random order. The array elements are displayed in a histogram, as shown
in Figure 22.12. You need to enter a search key in the text field. Clicking the
Step button causes the program to perform one comparison in the algorithm
and repaints the histogram with a bar indicating the search position. This button
also freezes the text field to prevent its value from being changed. When the
algorithm is finished, display the status in the label at the top of the border pane
to inform the user. Clicking the Reset button creates a new random array for a
new start. This button also makes the text field editable.*/
package c22_EfficientAlgorithms;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class E2216 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();
        Text result = new Text(" ");
        SearchAnimatePane searchPane = new SearchAnimatePane();
        pane.setTop(result);
        pane.setCenter(searchPane);
        BorderPane.setAlignment(result, Pos.CENTER);
        BorderPane.setAlignment(searchPane, Pos.CENTER);

        HBox controlBar = new HBox(10);
        controlBar.setAlignment(Pos.BOTTOM_CENTER);
        TextField tfKey = new TextField();
        Label lbKey = new Label("Key(in double)", tfKey);
        lbKey.setContentDisplay(ContentDisplay.RIGHT);
        Button btStep = new Button("Step");
        Button btReset = new Button("Reset");
        controlBar.getChildren().addAll(lbKey, btStep, btReset);
        pane.setBottom(controlBar);
        BorderPane.setAlignment(controlBar, Pos.CENTER);

        tfKey.setOnAction(e -> {
            searchPane.search(Integer.parseInt(tfKey.getText()));
        });
        btStep.setOnAction(e -> {
            tfKey.setEditable(false);
            int index = searchPane.nextStep();
            if (index > -1)
                result.setText("The key is found in the array at index " + index);
        });
        btReset.setOnAction(e -> {
            tfKey.setEditable(true);
            tfKey.clear();
            searchPane.reset();
        });

        Scene scene = new Scene(pane, 500,500);
        stage.setTitle("Linear Search Animation");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
