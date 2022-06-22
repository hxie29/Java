/*(Binary search animation) Write a program that animates the binary search
algorithm. Create an array with numbers from 1 to 25 in this order. The array
elements are displayed in a histogram, as shown in Figure 22.13. You need to(Binary search animation) Write a program that animates the binary search
algorithm. Create an array with numbers from 1 to 25 in this order. The array
elements are displayed in a histogram, as shown in Figure 22.13. You need to
enter a search key in the text field. Clicking the Step button causes the program
to perform one comparison in the algorithm. Use a light-gray color to paint
the bars for the numbers in the current search range and use a black color to
paint the bar indicating the middle number in the search range. The Step button
also freezes the text field to prevent its value from being changed. When the
algorithm is finished, display the status in a label at the top of a border pane.
Clicking the Reset button enables a new search to start. This button also makes
the text field editable.*/
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


public class E2218 extends Application {
    @Override
    public void start(Stage stage) throws Exception {
        BorderPane pane = new BorderPane();
        Text result = new Text(" ");
        BinarySearchPane searchPane = new BinarySearchPane();
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

        Scene scene = new Scene(pane, 500,200);
        stage.setTitle("Linear Search Animation");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }
}
