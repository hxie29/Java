/* 
(Random time) Modify the ClockPane class with three new Boolean properties—
hourHandVisible, minuteHandVisible, and secondHandVisible—and
their associated accessor and mutator methods. You can use the set methods
to make a hand visible or invisible. Write a test program that displays only the
hour and minute hands. The hour and minute values are randomly generated.
The hour is between 0 and 11, and the minute is either 0 or 30, as shown in
Figure 14.52b.
 */
package c14_JavaFX;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;


public class E1428 extends Application {
    @Override
    public void start(Stage primaryStage) {
        RandomClockPane clock = new RandomClockPane();
        clock.setSecondVisible(false);
        String time = clock.getHour() + ":" + clock.getMinute() + ":" + clock.getSeconds();
        Label timeLabel = new Label(time);

        BorderPane pane = new BorderPane();
        pane.setBottom(timeLabel);
        pane.setCenter(clock);
        BorderPane.setAlignment(timeLabel, Pos.TOP_CENTER);
        

        // Using border pane along with group can make sure the contents are always centered when resizing the window
        Scene scene = new Scene(pane, 300,200);
        primaryStage.setTitle("Show Clock");
        primaryStage.setScene(scene);
        primaryStage.show();
    }   

    
    public static void main(String[] args) {
        Application.launch(args);
    }
}

