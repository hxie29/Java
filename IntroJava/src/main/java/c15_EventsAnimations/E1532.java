/* 
(Control a clock) Modify Listing 14.21, ClockPane.java, to add the animation
into this class and add two methods start() and stop() to start and stop the
clock, respectively. Write a program that lets the user control the clock with the
Start and Stop buttons, as shown in Figure 15.38a.
}
*/

package c15_EventsAnimations;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import javafx.geometry.Insets;
import javafx.geometry.Pos;


public class E1532 extends Application {
    @Override
    public void start(Stage primaryStage) {
        BorderPane pane = new BorderPane();

        HBox controlPanel = new HBox(50);
        controlPanel.setPadding(new Insets(10,10,10,10));
        controlPanel.setAlignment(Pos.CENTER);
        Button stop = new Button("Stop");
        Button start = new Button("Start");
        
        controlPanel.getChildren().addAll(stop,start);
        pane.setBottom(controlPanel);
        BorderPane.setAlignment(controlPanel, Pos.CENTER);
        
        ClockPane2 clock = new ClockPane2();
        pane.setCenter(clock);

        stop.setOnAction(e -> clock.stop());
        start.setOnAction(e -> clock.start());
        
        Scene scene = new Scene(pane);
        primaryStage.setTitle("Spining fan");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    
    public static void main(String[] args ){
        launch(args);
    }
}
