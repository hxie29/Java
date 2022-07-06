/*(Display a running fan) Rewrite Programming Exercise 15.28 using a thread to
control the fan animation.*/
/* (Display a running fan) Write a program that displays a running fan, as shown
in Figure 15.35c. Use the Pause, Resume, Reverse buttons to pause, resume,
and reverse fan running. */
package c32_Muiltithreading;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class E3205 extends Application {

    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();

        HBox controlPanel = new HBox(50);
        controlPanel.setPadding(new Insets(10,10,10,10));
        controlPanel.setAlignment(Pos.CENTER);
        Button pause = new Button("Pause");
        Button resume = new Button("Resume");
        Button reverse = new Button("Reverse");
        Button speedUp = new Button("Speed up");
        Button speedDown = new Button("Speed down");
        controlPanel.getChildren().addAll(pause,resume,reverse, speedUp, speedDown);
        pane.setBottom(controlPanel);
        BorderPane.setAlignment(controlPanel, Pos.CENTER);
        
        FanPaneR fan = new FanPaneR();
        pane.setCenter(fan);
        Platform.runLater(fan);

        pause.setOnAction(e -> fan.pause());
        resume.setOnAction(e -> fan.play());
        reverse.setOnAction(e -> fan.changeDirection());
        speedUp.setOnAction(e -> fan.speedUp());
        speedDown.setOnAction(e -> fan.speedUp());

        Scene scene = new Scene(pane);
        primaryStage.setTitle("Spinning fan");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    public static void main(String[] args ){
        launch(args);
    }
}