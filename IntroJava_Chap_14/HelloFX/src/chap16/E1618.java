/* 
(Use ScrollBar and Slider) Write a program that uses scroll bars or sliders
to select the color for a text, as shown in Figure 16.43b. Four horizontal scroll
bars are used for selecting the colors: red, green, blue, and opacity percentages.
 */
package chap16;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import chap15.FanPane;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Slider;
import javafx.scene.control.Button;


public class E1618 extends Application {
    private FanPane fan = new FanPane();

    @Override
    public void start(Stage primaryStage) {
        VBox pane = new VBox(10);
        pane.setAlignment(Pos.CENTER);

        HBox topPanel = new HBox(10);
        topPanel.setAlignment(Pos.CENTER);
        Button btPause = new Button("Pause");
        Button btResume = new Button("Resume");
        Button btReverse = new Button("Reverse");
        topPanel.getChildren().addAll(btPause, btResume, btReverse);

        Slider sld = new Slider();
        pane.getChildren().addAll(topPanel, fan, sld);

        Timeline animation = new Timeline(new KeyFrame(Duration.millis(50), e -> fan.spinBlades()));
        animation.setCycleCount(Timeline.INDEFINITE);
        animation.play();

        btPause.setOnAction(e -> animation.pause());
        btResume.setOnAction(e -> animation.play());
        btReverse.setOnAction(e -> fan.changeDirection());
        sld.valueProperty().addListener(ov -> fan.setSpeed((int)(50 * sld.getValue() * 1.0 / sld.getMax() + 10)));

        Scene scene = new Scene(pane, 450, 200);
        primaryStage.setTitle("Fam");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args ){
        launch(args);
    }
    
}