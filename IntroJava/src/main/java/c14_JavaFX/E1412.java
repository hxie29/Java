/* 
(Display a bar chart) Write a program that uses a bar chart to display the percentages
of the overall market share represented by Apple, HTC, Samsung, and
Others, as shown in Figure 14.46b. Suppose that Apple takes 20 percent and is
displayed in red, HTC takes 26 percent and is displayed in blue, Samsung takes
28 percent and is displayed in green, and the Others take 26 and are displayed
in orange. Use the Rectangle class to display the bars. Interested readers may
explore the JavaFX BarChart class for further study.
*/

package c14_JavaFX;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.layout.HBox;

public class E1412 extends Application {
    @Override
    public void start(Stage primaryStage) {
        HBox pane = new HBox(10);
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(new BarChart("Apple", 20, Color.RED),
                                 new BarChart("HTC", 26, Color.BLUE),
                                 new BarChart("Samsung", 28, Color.GREEN),
                                 new BarChart("Others", 26, Color.ORANGE));

        Scene scene = new Scene(pane, 600, 300);
        primaryStage.setTitle("Bar Chart");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }

}

