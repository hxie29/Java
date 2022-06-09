/* 
(Racing car) Write a program that simulates car racing, as shown in
Figure 15.36a. The car moves from left to right. When it hits the right end, it
restarts from the left and continues the same process. You can use a timer to
control animation. Redraw the car with new base coordinates (x, y), as shown
in Figure 15.36b. Also let the user pause/resume the animation with a button
press/release and increase/decrease the car speed by pressing the up and down
arrow keys.
 */
package c15_EventsAnimations;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.VBox;


public class E1529 extends Application {

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
        primaryStage.setTitle("Spining fan");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    public static void main(String[] args ){
        launch(args);
    }
}
