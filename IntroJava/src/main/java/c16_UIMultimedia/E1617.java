/* 
(Use ScrollBar and Slider) Write a program that uses scroll bars or sliders
to select the color for a text, as shown in Figure 16.43b. Four horizontal scroll
bars are used for selecting the colors: red, green, blue, and opacity percentages.
 */
package c16_UIMultimedia;

import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.Label;


public class E1617 extends Application {
    private final Slider[] sliders = new Slider[4];
    private final Text text = new Text("Show color");

    @Override
    public void start(Stage primaryStage) {
        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);

        GridPane controlPanel = new GridPane();
        controlPanel.setVgap(10);
        controlPanel.setHgap(10);
        controlPanel.setAlignment(Pos.CENTER);
        controlPanel.add(new Label("Red"), 0,0);
        controlPanel.add(new Label("Green"), 0,1);
        controlPanel.add(new Label("Blue"), 0,2);
        controlPanel.add(new Label("Opacity"), 0,3);
        for (int i = 0; i < sliders.length; i++) {
            sliders[i] = new Slider();
            if (i < 3) {
                sliders[i].setMax(255);
                sliders[i].setValue(255);
            }
            else {
                sliders[i].setMax(1);
                sliders[i].setValue(1);
            }
            controlPanel.add(sliders[i], 1,i);
            sliders[i].valueProperty().addListener((obser, old, newV)  -> text.setFill(getColor()));
        }
       

        pane.getChildren().addAll(text, controlPanel);
        text.setStrokeWidth(30);
        text.setFill(Color.RED);

        Scene scene = new Scene(pane, 450, 200);
        primaryStage.setTitle("Text color");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private Color getColor() {
        return Color.rgb((int)sliders[0].getValue(), (int)sliders[1].getValue(), (int)sliders[2].getValue(), sliders[3].getValue());
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}