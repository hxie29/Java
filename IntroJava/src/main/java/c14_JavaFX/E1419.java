/* 
(Plot the sine and tangent functions) Write a program that plots the sine function
in red and tangent in blue, as shown in Figure 14.48c.
Hint: The Unicode for p is \u03c0. To display -2p, use Text(x, y, "–2\u03c0").
For a trigonometric function like sin(x), x is in radians. Use the following loop
to add the points to a polyline:
Polyline polyline = new Polyline();
ObservableList<Double> list = polyline.getPoints();
double scaleFactor = 50;
for (int x = −170; x <= 170; x++) {
list.add(x + 200.0);
list.add(100 – 50 * Math.sin((x / 100.0) * 2 * Math.PI));
}
*/

package c14_JavaFX;


import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.StackPane;


public class E1419 extends Application {
    @Override
    public void start(Stage primaryStage) {
        StackPane pane = new StackPane();
        pane.setAlignment(Pos.CENTER);
        pane.setPadding(new Insets(10,10,10,10));
        pane.getChildren().add(new SinTanGraph());
       
        Scene scene = new Scene(pane, 600, 300);
        primaryStage.setTitle("Show cube function graph");
        primaryStage.setScene(scene);
        primaryStage.show();

    }
    public static void main(String[] args) {
        Application.launch(args);
    }

}

