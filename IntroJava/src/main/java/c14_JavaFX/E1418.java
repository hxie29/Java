/* 
(Plot the cube function) Write a program that draws a diagram for the function
f(x) = x3 (see Figure 14.48b).
Hint: Add points to a polyline using the following code:
Polyline polyline = new Polyline();
ObservableList<Double> list = polyline.getPoints();
double scaleFactor = 0.0125;
for (int x = –100; x <= 100; x++) {
list.add(x + 200.0);
list.add(scaleFactor * x * x * x);
}
*/

package c14_JavaFX;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;


public class E1418 extends Application {
    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10,10,10,10));
        pane.getChildren().add(new CubeFunctionGraph());
       
        Scene scene = new Scene(pane, 600, 300);
        primaryStage.setTitle("Show cube function graph");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }

}

