/* 
(Create a histogram for occurrences of letters) Write a program that reads a
file and displays a histogram to show the occurrences of each letter in the file,
as shown in Figure 16.40b. The file name is entered from a text field. Pressing
the Enter key on the text field causes the program to start to read, process the
file, and display the histogram. The histogram is displayed in the center of the
window. Define a class named Histogram that extends Pane. The class contains
the property counts that is an array of 26 elements. counts[0] stores the
number of A, counts[1] the number of B, and so on. The class also contains a
setter method for setting a new counts and displaying the histogram for the new
counts.
 */
package chap16;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class E1611 extends Application {
    private Histogram histogram = new Histogram();
    private TextField tfInput = new TextField();

    @Override
    public void start(Stage primaryStage) {
        tfInput.setPrefColumnCount(30);
        
        Button btView = new Button("View");
        
        HBox inputBox = new HBox();
        inputBox.getChildren().addAll(new Label("Filename"), tfInput, btView);
        
        int[] count = new int[26];
        for (int i = 0; i < count.length; i++) {
            count[i] = i;
        }

        
        VBox pane = new VBox();
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(histogram, inputBox);
        
        btView.setOnAction(e -> {
            histogram.setCounts(count);
            //histogram.setFile(tfInput.getText());
            histogram.draw();
        });

        Scene scene = new Scene(pane, 450, 200);
        primaryStage.setTitle("TextArea Demo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}