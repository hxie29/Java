/*(Display circles) Write a Java program that displays ovals, as shown in
Figure 18.12b. The circles are centered in the pane. The gap between two adjacent
circles is 10 pixels, and the gap between the border of the pane and the
largest circle is also 10.*/
package c18_Recursion;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Ellipse;
import javafx.stage.Stage;

public class E1820 extends Application {
    @Override
    public void start (Stage primaryStage) {
        BorderPane pane = new BorderPane();
        OvalPane ovals = new OvalPane();
        pane.setCenter(ovals);

        Scene scene = new Scene(pane, 200,210);
        primaryStage.setTitle("Oval pane");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}

