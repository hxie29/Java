/* 
(Display random 0 or 1) Write a program that displays a 10-by-10 square matrix,
as shown in Figure 14.45a. Each element in the matrix is 0 or 1, randomly generated.
Display each number centered in a text field. Use TextField’s setText
method to set value 0 or 1 as a string.
*/

package c14_JavaFX;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class E1407 extends Application {
    @Override
    public void start(Stage primaryStage) {
        GridPane pane = new GridPane();
        pane.setPadding(new Insets(10,10,10,10));
        pane.setAlignment(Pos.CENTER);
        pane.setHgap(5);
        pane.setVgap(5);

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                TextField t = new TextField("" + (int)(Math.random() + 0.5));
                t.setPrefSize(50,50);
                t.setAlignment(Pos.CENTER);
                pane.add(t, i, j);
            }
        }

        Scene scene = new Scene(pane, 300, 300);
        primaryStage.setTitle("Chess Board");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
