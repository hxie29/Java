/* 
(Display a pie chart) Write a program that uses a pie chart to display the percentages
of the overall market share represented by Apple, HTC, Samsung, and
Others, as shown in Figure 14.46c. Suppose that Apple takes 26 percent and is
displayed in red, HTC takes 26 percent and is displayed in blue, Samsung takes
28 percent and is displayed in green, and the Others take 26 percent and are displayed
in orange. Use the Arc class to display the pies. Interested readers may
explore the JavaFX PieChart class for further study.
*/

package c14_JavaFX;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;

public class E1413 extends Application {
    @Override
    public void start(Stage primaryStage) {
        HBox pane = new HBox(10);
        pane.setAlignment(Pos.CENTER);
        String[] names = {"Apple", "HTC", "Samsung", "Others"};
        double[] percent = {20,26,28,26};
        Color[] color = {Color.RED, Color.BLUE, Color.GREEN, Color.ORANGE};
        pane.getChildren().add(new PieChart(names, percent, color));

        Scene scene = new Scene(pane, 600, 300);
        primaryStage.setTitle("Pie char");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }

}

