/* 
(Random points on a circle) Modify Programming Exercise 4.6 to create five
random points on a circle, form a polygon by connecting the points clockwise,
and display the circle and the polygon, as shown in Figure 14.51b.
}
*/

package chap14;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;

public class E1426 extends Application {
    @Override
    public void start(Stage primaryStage) {
        HBox pane = new HBox(20);
        pane.setPadding(new Insets(50,50,50,50));
        pane.setAlignment(Pos.CENTER);
        pane.getChildren().addAll(new ClockPane(4, 20, 25), new ClockPane(22,46,15));

        Scene scene = new Scene(new BorderPane(pane), 1600, 1300);
        primaryStage.setTitle("Show two clocks");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }

}
