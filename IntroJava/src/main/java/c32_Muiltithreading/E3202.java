/*(Racing cars) Rewrite Programming Exercise 15.29 using a thread to control car
racing. Compare the program with Programming Exercise 15.29 by setting the
delay time to 10 in both the programs. Which one runs the animation faster?*/

package c32_Muiltithreading;

import c15_EventsAnimations.CarPane;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class E3202 extends Application {
    @Override
    public void start(Stage primaryStage) {
        VBox pane = new VBox();
        pane.setAlignment(Pos.CENTER);

        //Set up control panel
        HBox controlPanel = new HBox(50);
        controlPanel.setPadding(new Insets(10,10,10,10));
        controlPanel.setAlignment(Pos.CENTER);
        Button pause = new Button("Pause");
        Button resume = new Button("Resume");
        Button speedUp = new Button("Speed up");
        Button speedDown = new Button("Speed down");
        controlPanel.getChildren().addAll(pause,resume,speedUp, speedDown);

        CarPane car = new CarPane();
        car.play();
        pane.getChildren().addAll(car, controlPanel);

        pause.setOnAction(e -> car.pause());
        resume.setOnAction(e -> car.play());
        speedUp.setOnAction(e -> car.setSpeed(car.getSpeed() + 1));
        speedDown.setOnAction(e -> {
            if (car.getSpeed() > 1) car.setSpeed(car.getSpeed() - 1);
            else  car.setSpeed(1);
        });

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Racing car");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args ){
        launch(args);
    }
}
