/* 
(Color and font) Write a program that displays five texts vertically, as shown in
Figure 14.44a. Set a random color and opacity for each text and set the font of
each text to Times Roman, bold, italic, and 24 pixels.
 */

package hellofx;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class E1404 extends Application {
    @Override
    public void start(Stage primaryStage) {
        HBox pane = new HBox(20);
        pane.setPadding(new Insets(20));
        pane.setAlignment(Pos.CENTER);
        String s = "JavaFX";

        for (int i = 0 ; i < 5; i++) {
            Text t = new Text(s);
            t.setRotate(90);
            t.setFont(Font.font("Times Roman", FontWeight.BOLD, FontPosture.ITALIC, 24));
            //To set text color use fill instead of stroke
            t.setFill(new Color(Math.random(), Math.random(), Math.random(),Math.random()));
            pane.getChildren().add(t);
        }


        Scene scene = new Scene(pane);
        primaryStage.setTitle("Text");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }
}
